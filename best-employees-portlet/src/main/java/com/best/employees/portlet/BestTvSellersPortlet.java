package com.best.employees.portlet;

import com.best.employees.constants.BestTvSellersPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

/**
 * @author Roma K
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=BEST TV SELLERS",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/best-tv-sellers/view.jsp",
                "javax.portlet.name=" + BestTvSellersPortletKeys.BEST_TV_SELLERS,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)
public class BestTvSellersPortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(BestTvSellersPortlet.class);

    public void getBestTvSellersPortlet(ActionRequest request, ActionResponse response) throws PortalException {
    }
}
