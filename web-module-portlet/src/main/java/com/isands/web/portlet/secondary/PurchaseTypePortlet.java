package com.isands.web.portlet.secondary;


import com.isands.service.builder.exception.ConsistencyViolationException;
import com.isands.service.builder.model.PurchaseType;
import com.isands.service.builder.service.PurchaseTypeLocalService;
import com.isands.web.constants.PurchaseTypePortletKeys;
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
                "javax.portlet.display-name=PURCHASE TYPE",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/purchase-type/view.jsp",
                "javax.portlet.name=" + PurchaseTypePortletKeys.PURCHASE_TYPE,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)

public class PurchaseTypePortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(PurchaseTypePortlet.class);
    @Reference
    private PurchaseTypeLocalService _purchaseTypeLocalService;

    public void addPurchaseType(ActionRequest request, ActionResponse response) {
        String purchaseTypeName = ParamUtil.getString(request, "name");
        int purchaseTypeCount = _purchaseTypeLocalService.getPurchaseTypesCount();
        if (purchaseTypeName == null || purchaseTypeName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/purchase-type/edit.jsp");
        } else {
            PurchaseType purchaseType = _purchaseTypeLocalService.createPurchaseType(purchaseTypeCount + 1);
            purchaseType.setName(purchaseTypeName);
            purchaseType.setCompanyId(1);
            _purchaseTypeLocalService.addPurchaseType(purchaseType);
            SessionMessages.add(request, "purchase-type-added");
            logger.info("Purchase type was created");
        }
    }

    public void updatePurchaseType(ActionRequest request, ActionResponse response) throws PortalException {
        String purchaseTypeName = ParamUtil.getString(request, "name");
        long purchaseTypeId = ParamUtil.getLong(request, "purchaseTypeId");
        if (purchaseTypeName == null || purchaseTypeName.equals("")) {
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/purchase-type/edit.jsp");
        } else {
            PurchaseType purchaseType = _purchaseTypeLocalService.getPurchaseType(purchaseTypeId);
            purchaseType.setPurchaseTypeId(purchaseTypeId);
            purchaseType.setName(purchaseTypeName);
            purchaseType.setCompanyId(1);
            _purchaseTypeLocalService.updatePurchaseType(purchaseType);
            SessionMessages.add(request, "purchase-type-updated");
            logger.info("Purchase type was updated");
        }
    }

    public void deletePurchaseType(ActionRequest request, ActionResponse response) {
        try {
            long purchaseTypeId = ParamUtil.getLong(request, "purchaseTypeId");
            _purchaseTypeLocalService.deletePurchaseType(purchaseTypeId);
            SessionMessages.add(request, "purchase-type-deleted");
            logger.info("PurchaseType was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove the PurchaseType that has purchases he consults about attached!");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "error-key");
        }
    }
}
