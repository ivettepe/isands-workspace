<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.isands.service.builder.service.*" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="purchase.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="editPurchaseURL">
        <portlet:param name="mvcPath" value="/purchase/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=editPurchaseURL%>" value="Make purchase"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption">
    <liferay-ui:search-container-results>
        <%
            String sortByType = ParamUtil.getString(request, "orderByType");
            boolean desc = true;
            if (sortByType != null)
                desc = sortByType.equals("desc");

            List<Purchase> purchases = PurchaseLocalServiceUtil.getPurchases(searchContainer.getStart(),
                    searchContainer.getEnd(), OrderByComparatorFactoryUtil.create("Purchase", "purchaseDate", desc));
            pageContext.setAttribute("results", purchases);
            pageContext.setAttribute("total", purchases.size());
        %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
            className="com.isands.service.builder.model.Purchase" modelVar="purchase">

        <%
            Employee employee = null;
            try {
                employee = EmployeeLocalServiceUtil.getEmployee(purchase.getEmployeeId());
            } catch (Exception ignored) {

            }
            String employeeName = employee == null ? "Unknown" : employee.getLastName() + " " + employee.getFirstName();
        %>

        <%
            Electronics electronics = null;
            try {
                electronics = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectronicsId());
            } catch (Exception ignored) {

            }
            String electronicsName = electronics == null ? "Unknown" : electronics.getName();
        %>

        <%
            PurchaseType purchaseType = null;
            try {
                purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchaseTypeId());
            } catch (Exception ignored) {

            }
            String purchaseTypeName = purchaseType == null ? "Unknown" : purchaseType.getName();
        %>

        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        %>

        <liferay-ui:search-container-column-text
                name="date"
                orderable="true"
                value="<%= sdf.format(purchase.getPurchaseDate()) %>"
        />

        <liferay-ui:search-container-column-text
                name="Name"
                value="<%=employeeName%>"
        />

        <liferay-ui:search-container-column-text
                name="Electronics"
                value="<%=electronicsName%>"
        />

        <liferay-ui:search-container-column-text
                name="Purchase type"
                value="<%=purchaseTypeName%>"
        />

        <liferay-ui:search-container-column-text
                name="Count"
                value="<%=String.valueOf(purchase.getCount())%>"
        />

        <liferay-ui:search-container-column-text
                name="Sum"
                value="<%=String.valueOf(purchase.getCount() * electronics.getPrice())%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/purchase/actions.jsp"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>