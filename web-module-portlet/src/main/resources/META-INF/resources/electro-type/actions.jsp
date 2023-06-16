<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    ElectroType electroType = (ElectroType) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="electroTypeId"
                       value="<%=String.valueOf(electroType.getElectroTypeId()) %>"/>
        <portlet:param name="mvcPath"
                       value="/electro-type/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL %>"/>

    <portlet:actionURL name="deleteElectroType" var="deleteURL">
        <portlet:param name="electroTypeId"
                       value="<%= String.valueOf(electroType.getElectroTypeId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL %>"/>

</liferay-ui:icon-menu>
