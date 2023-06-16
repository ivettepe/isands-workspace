<%@include file="../init.jsp" %>

<%
    long positionId = ParamUtil.getLong(request, "positionId");
    PositionType positionType = null;
    if (positionId > 0) {
        try {
            positionType = PositionTypeLocalServiceUtil.getPositionType(positionId);
        } catch (Exception ignored) {
        }
    }

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/position-type/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= positionType == null ? "addPosition" : "updatePosition"%>' var="editPositionURL"/>

<aui:form action="<%= editPositionURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= positionType == null ? "Create position type" : "Edit position type"%>
    </h3>
    <liferay-ui:error key="empty-name" message="failure.empty-name"/>
    <aui:fieldset>
        <aui:input name="positionId" type="hidden"
                   value='<%= positionType == null ? "" : positionType.getPositionTypeId() %>'/>

        <aui:input label="Position name" name="name" value='<%= positionType == null ? "" : positionType.getName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>