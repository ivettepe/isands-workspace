<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.isands.service.builder.service.*" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    long purchaseTypeId = ParamUtil.getLong(request, "purchaseId");
    Purchase purchase = null;
    if (purchaseTypeId > 0) {
        try {
            purchase = PurchaseLocalServiceUtil.getPurchase(purchaseTypeId);
        } catch (Exception ignored) {
        }
    }

    List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(0, Integer.MAX_VALUE);
    List<Electronics> electronicss = ElectronicsLocalServiceUtil.getElectronicses(0, Integer.MAX_VALUE);
    List<PurchaseType> purchaseTypes = PurchaseTypeLocalServiceUtil.getPurchaseTypes(0, Integer.MAX_VALUE);

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/purchase/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= purchase == null ? "makePurchase" : "updatePurchase"%>' var="makePurchaseURL"/>

<aui:form action="<%= makePurchaseURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= "Making purchase" %>
    </h3>
    <liferay-ui:error key="invalid-electronics-count" message="failure.invalid-electronics-count"/>
    <liferay-ui:error key="invalid-employee" message="failure.invalid-employee"/>
    <aui:fieldset>

        <aui:input name="purchaseId" type="hidden" value='<%= purchase == null ? "" : purchase.getPurchaseId() %>'/>


        <aui:select name="employeeId"
                    value='<%= purchase == null ? "" : purchase.getEmployeeId() %>'
        >
            <c:forEach items="<%=employees%>" var="employee">
                <aui:option
                        value="${employee.employeeId}">${employee.lastName.concat(" ").concat(employee.firstName) }</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="electronicsId"
                    value='<%= purchase == null ? "" : purchase.getElectronicsId() %>'
        >
            <c:forEach items="<%=electronicss%>" var="electronics">
                <aui:option value="${electronics.electronicsId}">${electronics.name}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="purchaseTypeId"
                    value='<%= purchase == null ? "" : purchase.getPurchaseTypeId() %>'
        >
            <c:forEach items="<%=purchaseTypes%>" var="purchaseType">
                <aui:option value="${purchaseType.purchaseTypeId}">${purchaseType.name}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:input name="count" value='<%= purchase == null ? "1" : purchase.getCount() %>'>
            <aui:validator name="min">1</aui:validator>
        </aui:input>

    </aui:fieldset>


    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>