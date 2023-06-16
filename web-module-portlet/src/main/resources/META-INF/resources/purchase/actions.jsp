<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Purchase purchase = (Purchase) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="purchaseId" value="<%=String.valueOf(purchase.getPurchaseId()) %>"/>
        <portlet:param name="mvcPath" value="/purchase/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL %>"/>

</liferay-ui:icon-menu>