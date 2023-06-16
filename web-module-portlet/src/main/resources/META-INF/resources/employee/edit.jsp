<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.isands.service.builder.service.*" %>
<%@ page import="com.isands.service.builder.model.*" %>
<%@include file="../init.jsp" %>

<%
    long employeeId = ParamUtil.getLong(request, "employeeId");
    Employee employee = null;
    List<ElectroEmployee> employeeConsultingElectroTypes = ElectroEmployeeLocalServiceUtil.findByElectroType(employeeId);
    if (employeeId > 0) {
        try {
            employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }
%>
<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/employee/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= employee == null ? "addEmployee" : "updateEmployee"%>' var="editEmployeeURL"/>


<aui:form action="<%= editEmployeeURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= employee == null ? "Create employee" : "Edit existing employee"%>
    </h3>

    <liferay-ui:error key="empty-person-name" message="failure.empty-person-name"/>
    <liferay-ui:error key="required-field-empty" message="failure.required-field-empty"/>
    <liferay-ui:error key="invalid-birth-date" message="failure.invalid-birth-date"/>
    <liferay-ui:error key="invalid-consulted" message="failure.invalid-consulted"/>

    <aui:fieldset>
        <aui:input name="employeeId" type="hidden" value='<%= employee == null ? "" : employee.getEmployeeId() %>'/>

        <aui:input name="firstName" value='<%= employee == null ? "" : employee.getFirstName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>

        <aui:input name="lastName" value='<%= employee == null ? "" : employee.getLastName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>
        <aui:input name="patronymic" value='<%= employee == null ? "" : employee.getPatronymic() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>

        <aui:input name="birthDate" label="Birth date"
                   value="<%= employee == null ? simpleDateFormat.format(new Date()) : simpleDateFormat.format(employee.getBirthDay()) %>"/>

        <%
            for (ElectroType electroType : ElectroTypeLocalServiceUtil.getElectroTypes(0, Integer.MAX_VALUE)) {
                boolean checked = false;
                if (employeeConsultingElectroTypes != null)
                    checked = employeeConsultingElectroTypes.stream().anyMatch(dt -> dt.getElectroTypeId() == electroType.getElectroTypeId());
        %>

        <label>
            <input type="checkbox" name="<portlet:namespace/>electroTypes"
                    <%= checked ? "checked" : null %>
                   value="<%= electroType.getElectroTypeId()%>">
        </label>
        <%= electroType.getName()%><br>
        <%
            }
        %>

        <aui:select name="gender"
                    value='<%= employee == null ? "" : EmployeeLocalServiceUtil.getGenderById(employee.getGender()) %>'>
            <c:forEach items="<%=EmployeeLocalServiceUtil.getGenderList()%>" var="gender">
                <aui:option value="${gender}">${gender}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="positionId" value='<%= employee == null ? "" : employee.getPositionId() %>'>
            <c:forEach items="<%=PositionTypeLocalServiceUtil.getPositionTypes(0, Integer.MAX_VALUE)%>" var="position">
                <aui:option value="${position.positionTypeId}">${position.name}</aui:option>
            </c:forEach>
        </aui:select>

    </aui:fieldset>
    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>