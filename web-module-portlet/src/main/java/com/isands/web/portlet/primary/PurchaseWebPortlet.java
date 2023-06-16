package com.isands.web.portlet.primary;

import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.model.Electronics;
import com.isands.service.builder.model.Purchase;
import com.isands.service.builder.service.ElectroEmployeeLocalServiceUtil;
import com.isands.service.builder.service.ElectronicsLocalServiceUtil;
import com.isands.service.builder.service.PurchaseLocalServiceUtil;
import com.isands.web.constants.PurchasePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;


import javax.portlet.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=PURCHASE",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/purchase/view.jsp",
                "javax.portlet.name=" + PurchasePortletKeys.PURCHASE,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)

public class PurchaseWebPortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseWebPortlet.class);

    public void makePurchase(ActionRequest request, ActionResponse response) throws PortalException, ParseException {
        long employeeId = ParamUtil.getLong(request, "employeeId");
        long electronicsId = ParamUtil.getLong(request, "electronicsId");
        int count = ParamUtil.getInteger(request, "count");
        int purchaseTypeId = ParamUtil.getInteger(request, "purchaseTypeId");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String formattedDate = formatter.format(date);
        Date purchaseDate = formatter.parse(formattedDate);
        int countPurchase = PurchaseLocalServiceUtil.getPurchasesCount();

        long electroTypeId = ElectronicsLocalServiceUtil.getElectronics(electronicsId).getElectroTypeId();
        List<ElectroEmployee> electroEmployeeList = ElectroEmployeeLocalServiceUtil.getElectroEmployees(0, Integer.MAX_VALUE);
        int flag = 0;
        for (ElectroEmployee electroEmployee : electroEmployeeList) {
            if (electroEmployee.getEmployeeId() == employeeId && electroEmployee.getElectroTypeId() == electroTypeId) {
                flag = 1;
                break;
            }
        }
        if (count < 1) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can not be less than 1");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else if (count > ElectronicsLocalServiceUtil.getElectronics(electronicsId).getCount()) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can not be more than we have in stock");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else if (flag == 0) {
            SessionErrors.add(request, "invalid-employee");
            logger.error("This employee have not permission to make purchase.");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else {
            Purchase purchase = PurchaseLocalServiceUtil.createPurchase(countPurchase + 1);
            Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(electronicsId);
            purchase.setElectronicsId(electronicsId);
            purchase.setEmployeeId(employeeId);
            purchase.setPurchaseTypeId(purchaseTypeId);
            purchase.setCompanyId(electronics.getCount());
            purchase.setCount(count);
            purchase.setPurchaseDate(purchaseDate);
            electronics.setCount(electronics.getCount() - count);
            ElectronicsLocalServiceUtil.updateElectronics(electronics);
            PurchaseLocalServiceUtil.addPurchase(purchase);
            logger.error("Purchase made");
            SessionMessages.add(request, "purchase-success");
        }
    }

    public void updatePurchase(ActionRequest request, ActionResponse response) throws PortalException {
        long purchaseId = ParamUtil.getLong(request, "purchaseId");
        long employeeId = ParamUtil.getLong(request, "employeeId");
        long electronicsId = ParamUtil.getLong(request, "electronicsId");
        int count = ParamUtil.getInteger(request, "count");
        int purchaseTypeId = ParamUtil.getInteger(request, "purchaseTypeId");
        long electroTypeId = ElectronicsLocalServiceUtil.getElectronics(electronicsId).getElectroTypeId();
        List<ElectroEmployee> electroEmployeeList = ElectroEmployeeLocalServiceUtil.getElectroEmployees(0, Integer.MAX_VALUE);
        int flag = 0;
        for (ElectroEmployee electroEmployee : electroEmployeeList) {
            if (electroEmployee.getEmployeeId() == employeeId && electroEmployee.getElectroTypeId() == electroTypeId) {
                flag = 1;
                break;
            }
        }
        Purchase purchase = PurchaseLocalServiceUtil.getPurchase(purchaseId);
        if (count < 1) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can not be less than 1");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else if (count > purchase.getCompanyId()) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can not be more than we have in stock");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else if (flag == 0) {
            SessionErrors.add(request, "invalid-employee");
            logger.error("This employee have not permission to make purchase.");
            response.setRenderParameter("mvcPath", "/purchase/edit.jsp");
        } else {
            Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(electronicsId);
            purchase.setElectronicsId(electronicsId);
            purchase.setEmployeeId(employeeId);
            purchase.setPurchaseTypeId(purchaseTypeId);
            purchase.setCount(count);
            electronics.setCount((int) (purchase.getCompanyId() - count));
            ElectronicsLocalServiceUtil.updateElectronics(electronics);
            PurchaseLocalServiceUtil.updatePurchase(purchase);
            logger.error("Purchase updated.");
            SessionMessages.add(request, "purchase-updated");
        }
    }
}
