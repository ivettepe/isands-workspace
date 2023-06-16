<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Employee employee = (Employee) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployeeId()) %>"/>
        <portlet:param name="mvcPath" value="/employee/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL %>"/>

    <portlet:actionURL name="deleteEmployee" var="deleteURL">
        <portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL %>"/>

</liferay-ui:icon-menu>