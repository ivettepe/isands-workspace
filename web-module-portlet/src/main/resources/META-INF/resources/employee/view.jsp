<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
    <b><liferay-ui:message key="employee.caption"/></b>
</p>
<liferay-ui:error key="consistency-violation" message="failure.consistency-violation"/>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addEmployeeURL">
        <portlet:param name="mvcPath" value="/employee/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addEmployeeURL%>" value="Add employee"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=EmployeeLocalServiceUtil.getEmployeesCount()%>">
    <liferay-ui:search-container-results
            results="<%=EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd())%>"/>

    <liferay-ui:search-container-row
            className="com.isands.service.builder.model.Employee" modelVar="employee">
        <%
            String positionType = "UNKNOWN";
            try {
                positionType = PositionTypeLocalServiceUtil.getPositionType(employee.getPositionId()).getName();
            } catch (Exception ignored) {
            }
        %>
        <%
            String gender;
            try {
                if (EmployeeLocalServiceUtil.getEmployee(employee.getEmployeeId()).getGender() == 0)
                    gender = "male";
                else
                    gender = "female";
            } catch (com.liferay.portal.kernel.exception.PortalException e) {
                throw new RuntimeException(e);
            }
        %>
        <liferay-ui:search-container-column-text name="Firs name" value="<%=employee.getFirstName()%>"/>
        <liferay-ui:search-container-column-text name="Last name" value="<%=employee.getLastName()%>"/>
        <liferay-ui:search-container-column-text name="Patronymic" value="<%=employee.getPatronymic()%>"/>
        <liferay-ui:search-container-column-text name="Gender" value="<%=gender%>"/>
        <%SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
        <liferay-ui:search-container-column-text name="date"
                                                 value="<%=simpleDateFormat.format(employee.getBirthDay())%>"/>
        <liferay-ui:search-container-column-text name="Position" value="<%=positionType%>"/>
        <liferay-ui:search-container-column-jsp name="Consults about" path="/employee/consulting.jsp"/>
        <liferay-ui:search-container-column-jsp name="Manage" path="/employee/actions.jsp"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>