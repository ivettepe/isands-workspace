package com.isands.web.portlet.secondary;


import com.isands.service.builder.exception.ConsistencyViolationException;
import com.isands.service.builder.model.ElectroType;
import com.isands.service.builder.service.ElectroTypeLocalService;
import com.isands.web.constants.ElectroTypePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ELECTRO TYPE",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/electro-type/view.jsp",
                "javax.portlet.name=" + ElectroTypePortletKeys.ELECTRO_TYPE,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)
public class ElectroTypeWebPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(ElectroTypeWebPortlet.class);
    @Reference
    private ElectroTypeLocalService _electroTypeLocalService;

    public void addElectroType(ActionRequest request, ActionResponse response) {
        String electroTypeName = ParamUtil.getString(request, "name");
        int electroTypesCount = _electroTypeLocalService.getElectroTypesCount();
        if (electroTypeName == null || electroTypeName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/electro-type/edit.jsp");
        } else {
            ElectroType electroType = _electroTypeLocalService.createElectroType(electroTypesCount + 1);
            electroType.setName(electroTypeName);
            electroType.setCompanyId(1);
            _electroTypeLocalService.addElectroType(electroType);
            SessionMessages.add(request, "electro-type-added");
            logger.info("Electro type was created");
        }
    }

    public void updateElectroType(ActionRequest request, ActionResponse response) throws PortalException {
        String electroTypeName = ParamUtil.getString(request, "name");
        long electroTypeId = ParamUtil.getLong(request, "electroTypeId");
        if (electroTypeName == null || electroTypeName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/electro-type/edit.jsp");
        } else {
            ElectroType electroType = _electroTypeLocalService.getElectroType(electroTypeId);
            electroType.setElectroTypeId(electroTypeId);
            electroType.setName(electroTypeName);
            electroType.setCompanyId(1);
            _electroTypeLocalService.updateElectroType(electroType);
            SessionMessages.add(request, "electro-type-updated");
            logger.info("Electro type was updated");
        }
    }

    public void deleteElectroType(ActionRequest request, ActionResponse response) {
        try {
            long electroTypeId = ParamUtil.getLong(request, "electroTypeId");
            _electroTypeLocalService.deleteElectroType(electroTypeId);
            SessionMessages.add(request, "electro-type-deleted");
            logger.info("ElectroType was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove the ElectroType that has purchases he consults about attached!");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "error-key");
        }
    }
}