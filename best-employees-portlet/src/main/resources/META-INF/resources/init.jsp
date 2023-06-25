<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@
        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@
        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@
        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.isands.service.builder.model.ElectroType" %>
<%@ page import="com.isands.service.builder.model.PositionType" %>
<%@ page import="com.isands.service.builder.service.ElectroTypeLocalServiceUtil" %>
<%@ page import="com.isands.service.builder.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.isands.service.builder.service.PositionTypeLocalServiceUtil" %>
<%@ page import="com.isands.service.builder.service.EmployeeWithSummaryLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.List" %>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>