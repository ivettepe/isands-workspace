<%@ page import="com.isands.service.builder.service.*" %>
<%@ page import="com.isands.service.builder.model.Purchase" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="java.util.*" %>
<%@ include file="../init.jsp" %>
<%
    List<PositionType> positionTypes = PositionTypeLocalServiceUtil.getPositionTypes(0, Integer.MAX_VALUE);
%>
<p>
    <b><liferay-ui:message key="bestemployee.caption"/></b>
</p>

<portlet:actionURL name="getBestEmployees" var="getBestEmployeesURL"/>

<%
    String criteria = ParamUtil.getString(request, "criteria");
    long positionTypeId = ParamUtil.getLong(request, "positionTypeId");

%>

<aui:form action="<%= getBestEmployeesURL %>" name="<portlet:namespace />fm" method="post">

    <aui:select name="criteria">
        <aui:option value="sum">Amount of money</aui:option>
        <aui:option value="count">Count of devices</aui:option>
    </aui:select>

    <aui:select name="positionTypeId">
        <c:forEach items="<%=positionTypes%>" var="positionType">
            <aui:option value="${positionType.positionTypeId}">${positionType.name}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:button-row cssClass="crud-buttons">
        <aui:button type="submit" value="Get employees"/>
    </aui:button-row>
</aui:form>
<%
    PurchaseLocalServiceUtil.getPurchases(0, Integer.MAX_VALUE);
    int count = EmployeeLocalServiceUtil.getEmployeesCount();
    long[] employeesSoldCount = new long[count];
    long[] emp = new long[count];
    long[] sum = new long[count];
    long temp = 0;
    int j = 0;
    List<Purchase> purchaseList = PurchaseLocalServiceUtil.getPurchases(0, Integer.MAX_VALUE);
    for (Purchase purchase : purchaseList) {
        long employeeId = 0;
        try {
            employeeId = purchase.getEmployeeId();
            temp = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectronicsId()).getPrice();
        } catch (PortalException ignored) {
        } finally {
            temp *= purchase.getCount();
            sum[(int) (employeeId - 1)] += temp;
            employeesSoldCount[(int) (employeeId - 1)] += purchase.getCount();
            j++;
        }
    }
    for (int i = 0; i < count; i++)
        emp[i] = i + 1;
%>
<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=EmployeeLocalServiceUtil.getEmployeesCount()%>">
    <%
        List<Long> listEmp = new ArrayList<>(), listCount = new ArrayList<>(), listSum = new ArrayList<>();
        for (long l : sum)
            listSum.add(l);
        for (long l : employeesSoldCount)
            listCount.add(l);
        j = 0;
        for (long l : emp) {
            listEmp.add(l);
            try {
                if (EmployeeLocalServiceUtil.getEmployee(l).getPositionId() != positionTypeId && positionTypeId != 0) {
                    count--;
                    listEmp.remove(l);
                    listCount.remove(employeesSoldCount[j]);
                    listSum.remove(sum[j]);
                }
            } catch (PortalException ignored) {
            }
            j++;
        }
        emp = new long[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
            emp[i] = listEmp.get(i);
        }
        sum = new long[listSum.size()];
        for (int i = 0; i < listSum.size(); i++) {
            sum[i] = listSum.get(i);
        }
        employeesSoldCount = new long[listCount.size()];
        for (int i = 0; i < listCount.size(); i++) {
            employeesSoldCount[i] = listCount.get(i);
        }
        if (criteria.equals("count")) {
            for (int i = 0; i < employeesSoldCount.length - 1; i++) {
                for (int k = i + 1; k < employeesSoldCount.length; k++) {
                    if (employeesSoldCount[k] > employeesSoldCount[i]) {
                        long tempEmp = emp[i];
                        emp[i] = emp[k];
                        emp[k] = tempEmp;

                        long tempCount = employeesSoldCount[i];
                        employeesSoldCount[i] = employeesSoldCount[k];
                        employeesSoldCount[k] = tempCount;

                        long tempSum = sum[i];
                        sum[i] = sum[k];
                        sum[k] = tempSum;
                    }
                }
            }
        } else {
            for (int i = 0; i < sum.length - 1; i++) {
                for (int k = i + 1; k < sum.length; k++) {
                    if (sum[k] > sum[i]) {
                        long tempEmp = emp[i];
                        emp[i] = emp[k];
                        emp[k] = tempEmp;

                        long tempCount = employeesSoldCount[i];
                        employeesSoldCount[i] = employeesSoldCount[k];
                        employeesSoldCount[k] = tempCount;

                        long tempSum = sum[i];
                        sum[i] = sum[k];
                        sum[k] = tempSum;
                    }
                }
            }
        }
        int iterator = 0;
    %>
    <liferay-ui:search-container-results
            results="<%=EmployeeLocalServiceUtil.getEmployees(0, count)%>"/>
    <liferay-ui:search-container-row
            className="com.isands.service.builder.model.Employee" modelVar="employee">
        <liferay-ui:search-container-column-text name="Last name"
                                                 value="<%=EmployeeLocalServiceUtil.getEmployee(emp[iterator]).getLastName()%>"/>
        <liferay-ui:search-container-column-text name="First name"
                                                 value="<%=EmployeeLocalServiceUtil.getEmployee(emp[iterator]).getFirstName()%>"/>
        <liferay-ui:search-container-column-text name="Patronomic"
                                                 value="<%=EmployeeLocalServiceUtil.getEmployee(emp[iterator]).getPatronymic()%>"/>

        <liferay-ui:search-container-column-text name="Electronics count"
                                                 value="<%=String.valueOf(employeesSoldCount[iterator])%>"/>

        <liferay-ui:search-container-column-text name="Sold electronics on"
                                                 value="<%=String.valueOf(sum[iterator])%>"/>
        <%
            iterator += 1;
        %>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>



