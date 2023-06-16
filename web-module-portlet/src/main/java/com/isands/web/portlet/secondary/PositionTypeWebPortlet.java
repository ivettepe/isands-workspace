package com.isands.web.portlet.secondary;

import com.isands.service.builder.exception.ConsistencyViolationException;
import com.isands.service.builder.model.PositionType;
import com.isands.service.builder.service.PositionTypeLocalService;
import com.isands.web.constants.PositionTypePortletKeys;
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
                "javax.portlet.display-name=POSITION TYPE",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/position-type/view.jsp",
                "javax.portlet.name=" + PositionTypePortletKeys.POSITION_TYPE,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)

public class PositionTypeWebPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(PositionTypeWebPortlet.class);
    @Reference
    private PositionTypeLocalService _positionTypeLocalService;

    public void addPosition(ActionRequest request, ActionResponse response) {
        String positionName = ParamUtil.getString(request, "name");
        int positionTypeCount = _positionTypeLocalService.getPositionTypesCount();
        if (positionName == null || positionName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/position-type/edit.jsp");
        } else {
            PositionType positionType = _positionTypeLocalService.createPositionType(positionTypeCount + 1);
            positionType.setName(positionName);
            positionType.setCompanyId(1);
            _positionTypeLocalService.addPositionType(positionType);
            SessionMessages.add(request, "position-type-added");
            logger.info("Position was created");
        }
    }

    public void updatePosition(ActionRequest request, ActionResponse response) throws PortalException {
        String positionName = ParamUtil.getString(request, "name");
        long positionId = ParamUtil.getLong(request, "positionId");
        if (positionName == null || positionName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/position-type/edit.jsp");
        } else {
            PositionType positionType = _positionTypeLocalService.getPositionType(positionId);
            positionType.setPositionTypeId(positionId);
            positionType.setName(positionName);
            positionType.setCompanyId(1);
            _positionTypeLocalService.updatePositionType(positionType);
            SessionMessages.add(request, "position-type-updated");
            logger.info("Position was updated");
        }
    }

    public void deletePosition(ActionRequest request, ActionResponse response) {
        try {
            long positionId = ParamUtil.getLong(request, "positionId");
            _positionTypeLocalService.deletePositionType(positionId);
            SessionMessages.add(request, "position-type-deleted");
            logger.info("PositionType was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove the PositionType that has purchases he consults about attached!");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "error-key");
        }
    }
}
