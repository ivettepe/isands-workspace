package com.best.employees.portlet;

import com.best.employees.constants.BestEmployeesPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roma K
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=isands",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=BEST EMPLOYEES ",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/best-employees/view.jsp",
                "javax.portlet.name=" + BestEmployeesPortletKeys.BESTEMPLOYEES,
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)
public class BestEmployeesPortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(BestEmployeesPortlet.class);

    public void getBestEmployees(ActionRequest request, ActionResponse response) throws PortalException {
    }

}

