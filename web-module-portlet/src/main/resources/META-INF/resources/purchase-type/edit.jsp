<%@ page import="com.isands.service.builder.service.*" %>
<%@include file="../init.jsp" %>

<%
    long purchaseTypeId = ParamUtil.getLong(request, "purchaseTypeId");
    PurchaseType purchaseType = null;
    if (purchaseTypeId > 0) {
        try {
            purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchaseTypeId);
        } catch (Exception ignored) {
        }
    }

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/purchase-type/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= purchaseType == null ? "addPurchaseType" : "updatePurchaseType"%>'
                   var="editPurchaseTypeURL"/>

<aui:form action="<%= editPurchaseTypeURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= purchaseType == null ? "Create purchase type" : "Edit purchase type"%>
    </h3>
    <liferay-ui:error key="empty-name" message="failure.empty-name"/>
    <aui:fieldset>
        <aui:input name="purchaseTypeId" type="hidden"
                   value='<%= purchaseType == null ? "" : purchaseType.getPurchaseTypeId() %>'/>

        <aui:input name="name" value='<%= purchaseType == null ? "" : purchaseType.getName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>