<%@ page import="com.isands.service.builder.service.*" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
    <b><liferay-ui:message key="purchase.type.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addPurchaseTypeURL">
        <portlet:param name="mvcPath" value="/purchase-type/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addPurchaseTypeURL%>" value="Add purchase type"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=PurchaseTypeLocalServiceUtil.getPurchaseTypesCount()%>">
    <liferay-ui:search-container-results
            results="<%=PurchaseTypeLocalServiceUtil.getPurchaseTypes(0, Integer.MAX_VALUE)%>"/>

    <liferay-ui:search-container-row className="com.isands.service.builder.model.PurchaseType" modelVar="purchaseType">

        <liferay-ui:search-container-column-text name="Name" value="<%=purchaseType.getName()%>"/>

        <liferay-ui:search-container-column-jsp name="Manage" path="/purchase-type/actions.jsp"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>