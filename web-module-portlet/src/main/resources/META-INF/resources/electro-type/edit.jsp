<%@include file="../init.jsp" %>

<%
    long electroTypeId = ParamUtil.getLong(request, "electroTypeId");
    ElectroType electroType = null;
    if (electroTypeId > 0) {
        try {
            electroType = ElectroTypeLocalServiceUtil.getElectroType(electroTypeId);
        } catch (Exception ignored) {
        }
    }

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/electro-type/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= electroType == null ? "addElectroType" : "updateElectroType"%>' var="editElectroTypeURL"/>


<aui:form action="<%= editElectroTypeURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= electroType == null ? "Create electroType" : "Edit existing electroType"%>
    </h3>

    <liferay-ui:error key="empty-name" message="failure.empty-name"/>

    <aui:input name="electroTypeId" type="hidden"
               value='<%= electroType == null ? "" : electroType.getElectroTypeId() %>'/>

    <aui:fieldset>
        <aui:input name="name" value='<%= electroType == null ? "" : electroType.getName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>
    </aui:button-row>
</aui:form>