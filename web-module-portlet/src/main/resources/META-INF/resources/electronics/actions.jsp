<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.isands.service.builder.model.Electronics" %>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Electronics electronics = (Electronics) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="electronicsId" value="<%=String.valueOf(electronics.getElectronicsId()) %>"/>
        <portlet:param name="mvcPath" value="/electronics/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL %>"/>

    <portlet:actionURL name="deleteElectronics" var="deleteURL">
        <portlet:param name="electronicsId" value="<%= String.valueOf(electronics.getElectronicsId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL %>"/>

</liferay-ui:icon-menu>
