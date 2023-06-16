<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.isands.service.builder.model.*" %>
<%@ page import="com.isands.service.builder.service.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@include file="../init.jsp" %>

<%
    String name = null;
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Employee employee = (Employee) row.getObject();
    List<ElectroEmployee> employeeConsultingDeviceTypes = ElectroEmployeeLocalServiceUtil.findByElectroType(employee.getEmployeeId());
%>

<%
    for (ElectroEmployee electroEmployee : employeeConsultingDeviceTypes) {
        try {
            name = ElectroTypeLocalServiceUtil.getElectroType(electroEmployee.getElectroTypeId()).getName();
        } catch (PortalException ignored) {
        }

%>
<%= name %> <br>
<%}%>