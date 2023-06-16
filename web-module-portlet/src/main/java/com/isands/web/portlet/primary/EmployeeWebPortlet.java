package com.isands.web.portlet.primary;

import com.isands.service.builder.exception.ConsistencyViolationException;
import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.model.Employee;
import com.isands.service.builder.service.ElectroEmployeeLocalServiceUtil;
import com.isands.service.builder.service.EmployeeLocalService;
import com.isands.web.constants.EmployeePortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=EMPLOYEES",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/employee/view.jsp",
                "javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)

public class EmployeeWebPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(EmployeeWebPortlet.class);
    @Reference
    private EmployeeLocalService _employeeLocalService;

    public void addEmployee(ActionRequest request, ActionResponse response) {
        String firstName = ParamUtil.getString(request, "firstName");
        String lastName = ParamUtil.getString(request, "lastName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String genderString = ParamUtil.getString(request, "gender");
        Date birthDate = ParamUtil.getDate(request, "birthDate", new SimpleDateFormat("dd/MM/yyyy"));
        long positionId = ParamUtil.getLong(request, "positionId");
        List<Long> consultedElectroTypeIds = Arrays
                .stream(ParamUtil.getLongValues(request, "electroTypes"))
                .boxed()
                .collect(Collectors.toList());
        Calendar calendar = GregorianCalendar.getInstance();
        Date until = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(until);
        c.add(Calendar.YEAR, -14);
        Date from = c.getTime();
        int count = _employeeLocalService.getEmployeesCount();
        if (firstName == null || lastName == null || firstName.equals("") || lastName.equals("")) {
            SessionErrors.add(request, "empty-person-name");
            logger.error("Names must not be empty");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (birthDate == null) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (birthDate.after(from)) {
            SessionErrors.add(request, "invalid-birth-date");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (consultedElectroTypeIds.isEmpty()) {
            SessionErrors.add(request, "invalid-consulted");
            logger.error("You haven`t selected any electro type");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else {
            Employee employee = _employeeLocalService.createEmployee(count + 1);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPatronymic(patronymic);
            int gender;
            if (genderString.equals("MALE"))
                gender = 0;
            else if (genderString.equals("FEMALE"))
                gender = 1;
            else
                gender = 2;
            employee.setGender(gender);
            employee.setPositionId(positionId);
            employee.setBirthDay(birthDate);
            for (Long electroTypeId : consultedElectroTypeIds) {
                ElectroEmployee electroEmployee = ElectroEmployeeLocalServiceUtil.createElectroEmployee(CounterLocalServiceUtil.increment());
                electroEmployee.setEmployeeId(employee.getEmployeeId());
                electroEmployee.setElectroTypeId(electroTypeId);
                ElectroEmployeeLocalServiceUtil.addElectroEmployee(electroEmployee);
            }
            logger.info("Employee was created");
            _employeeLocalService.addEmployee(employee);
            SessionMessages.add(request, "employee-added");
        }
    }

    public void updateEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        long employeeId = ParamUtil.getLong(request, "employeeId");
        String firstName = ParamUtil.getString(request, "firstName");
        String lastName = ParamUtil.getString(request, "lastName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String genderString = ParamUtil.getString(request, "gender");
        long positionId = ParamUtil.getLong(request, "positionId");
        Date birthDate = ParamUtil.getDate(request, "birthDate", new SimpleDateFormat("dd/MM/yyyy"));
        List<Long> consultedElectroTypeIds = Arrays
                .stream(ParamUtil.getLongValues(request, "electroTypes"))
                .boxed()
                .collect(Collectors.toList());
        Calendar calendar = GregorianCalendar.getInstance();
        Date until = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(until);
        c.add(Calendar.YEAR, -14);
        Date from = c.getTime();
        if (firstName == null || lastName == null || firstName.equals("") || lastName.equals("")) {
            SessionErrors.add(request, "empty-person-name");
            logger.error("Names must not be empty");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (birthDate == null) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (birthDate.after(from)) {
            SessionErrors.add(request, "invalid-birth-date");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else if (consultedElectroTypeIds.isEmpty()) {
            SessionErrors.add(request, "invalid-consulted");
            logger.error("You haven`t selected any electro type");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        } else {
            Employee employee = _employeeLocalService.getEmployee(employeeId);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPatronymic(patronymic);
            int gender;
            if (genderString.equals("MALE"))
                gender = 0;
            else if (genderString.equals("FEMALE"))
                gender = 1;
            else
                gender = 2;
            employee.setGender(gender);
            employee.setPositionId(positionId);
            employee.setBirthDay(birthDate);
            List<ElectroEmployee> toDelete = ElectroEmployeeLocalServiceUtil.findByElectroType(employeeId);
            for (ElectroEmployee electroEmployee : toDelete) {
                ElectroEmployeeLocalServiceUtil.deleteElectroEmployee(electroEmployee.getId());
            }
            for (Long electroTypeId : consultedElectroTypeIds) {
                ElectroEmployee electroEmployee =
                        ElectroEmployeeLocalServiceUtil.createElectroEmployee(CounterLocalServiceUtil.increment());
                electroEmployee.setEmployeeId(employee.getEmployeeId());
                electroEmployee.setElectroTypeId(electroTypeId);
                ElectroEmployeeLocalServiceUtil.addElectroEmployee(electroEmployee);
            }
            _employeeLocalService.updateEmployee(employee);
            SessionMessages.add(request, "employee-updated");
            logger.info("Employee was updated");
        }
    }

    public void deleteEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        try {
            long employeeId = ParamUtil.getLong(request, "employeeId");
            List<ElectroEmployee> toDelete = ElectroEmployeeLocalServiceUtil.findByElectroType(employeeId);
            for (ElectroEmployee electroEmployee : toDelete) {
                ElectroEmployeeLocalServiceUtil.deleteElectroEmployee(electroEmployee.getId());
            }
            _employeeLocalService.deleteEmployee(employeeId);
            SessionMessages.add(request, "employee-deleted");
            logger.info("Employee was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove a user who has purchases attached to him");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException t) {
            logger.error("Error occurred when deleting employee!", t);
            SessionErrors.add(request, "error-key");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
}
