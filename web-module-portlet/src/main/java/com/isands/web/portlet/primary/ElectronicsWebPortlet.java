package com.isands.web.portlet.primary;

import com.isands.service.builder.exception.ConsistencyViolationException;
import com.isands.service.builder.model.Electronics;
import com.isands.service.builder.service.ElectronicsLocalService;
import com.isands.web.constants.ElectronicsPortletKeys;
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

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ELECTRONICS",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/electronics/view.jsp",
                "javax.portlet.name=" + ElectronicsPortletKeys.ELECTRONICS,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class)
public class ElectronicsWebPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(ElectronicsWebPortlet.class);
    @Reference
    private ElectronicsLocalService _electronicsLocalService;

    public void addElectronics(ActionRequest request, ActionResponse response) {
        String name = ParamUtil.getString(request, "name");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        boolean archive = ParamUtil.getBoolean(request, "archive");
        long electroTypeId = ParamUtil.getLong(request, "ElectroTypeId");
        String description = ParamUtil.getString(request, "description");
        int electronicsCount = _electronicsLocalService.getElectronicsesCount();
        if (name == null || name.equals("")) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("One or more of the fields are empty");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (price < 0) {
            SessionErrors.add(request, "invalid-electronics-price");
            logger.error("Price can not be less than 0");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (electroTypeId == 0) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("Invalid electro type param");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (count < 0) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can`t be less than 0");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else {
            Electronics electronics = _electronicsLocalService.createElectronics(electronicsCount + 1);
            electronics.setName(name);
            electronics.setElectroTypeId(electroTypeId);
            electronics.setPrice(price);
            electronics.setInStock(true);
            electronics.setCount(count);
            electronics.setArchive(archive);
            electronics.setCompanyId(1);
            electronics.setDescription(description);
            _electronicsLocalService.addElectronics(electronics);
            SessionMessages.add(request, "electronics-added");
            logger.info("Electronics was created");
        }
    }

    public void updateElectronics(ActionRequest request, ActionResponse response) throws PortalException {
        long electronicsId = ParamUtil.getLong(request, "electronicsId");
        String name = ParamUtil.getString(request, "name");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        boolean archive = ParamUtil.getBoolean(request, "archive");
        long electroTypeId = ParamUtil.getLong(request, "ElectroTypeId");
        String description = ParamUtil.getString(request, "description");
        if (name == null || name.equals("")) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("One or more of the fields are empty");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (price < 0) {
            SessionErrors.add(request, "invalid-electronics-price");
            logger.error("Price can not be less than 0");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (electroTypeId == 0) {
            SessionErrors.add(request, "required-field-empty");
            logger.error("Invalid electro type param");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else if (count < 0) {
            SessionErrors.add(request, "invalid-electronics-count");
            logger.error("Count can`t be less than 0");
            response.setRenderParameter("mvcPath", "/electronics/edit.jsp");
        } else {
            Electronics electronics = _electronicsLocalService.getElectronics(electronicsId);
            electronics.setName(name);
            electronics.setElectroTypeId(electroTypeId);
            electronics.setPrice(price);
            electronics.setInStock(true);
            electronics.setCount(count);
            electronics.setArchive(archive);
            electronics.setDescription(description);
            _electronicsLocalService.updateElectronics(electronics);
            SessionMessages.add(request, "electronics-updated");
            logger.info("Electronics was updated");
        }
    }

    public void deleteElectronics(ActionRequest request, ActionResponse response) {
        try {
            long electronicsId = ParamUtil.getLong(request, "electronicsId");
            _electronicsLocalService.deleteElectronics(electronicsId);
            SessionMessages.add(request, "electronics-deleted");
            logger.info("Electronics was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove the electronics that has purchases he consults about attached!");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "error-key");
        }
    }

}
