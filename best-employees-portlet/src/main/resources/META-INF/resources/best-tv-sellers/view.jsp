<%@ page import="com.isands.service.builder.service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.isands.service.builder.model.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="../init.jsp" %>
<%
    long electroTypeId = 1;
    List<ElectroType> electroTypes = ElectroTypeLocalServiceUtil.getElectroTypes(0, Integer.MAX_VALUE);
    for (ElectroType electroType : electroTypes) {
        if (electroType.getName().equals("TVs")) {
            electroTypeId = electroType.getElectroTypeId();
            break;
        }
    }
    Calendar calendar = GregorianCalendar.getInstance();
    Date until = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(until);
    c.add(Calendar.MONTH, -1);
    Date from = c.getTime();
    List<Purchase> purchaseList = PurchaseLocalServiceUtil.getPurchases(0, Integer.MAX_VALUE);
    List<Employee> employeeList = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    for (Purchase purchase : purchaseList) {
        Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectronicsId());
        if (electronics.getElectroTypeId() == electroTypeId && purchase.getPurchaseDate().after(from)) {
            Employee employee = EmployeeLocalServiceUtil.getEmployee(purchase.getEmployeeId());
            employeeList.add(employee);
            count.add(purchase.getCount());
        }
    }
    long[] ids = employeeList.stream().mapToLong(Employee::getEmployeeId).toArray();
    int[] counts = new int[count.size()];
    for (int i = 0; i < counts.length; i++) {
        counts[i] = count.get(i);
    }
    for (int i = 0; i < counts.length - 1; i++) {
        for (int k = i + 1; k < counts.length; k++) {
            if (counts[k] > counts[i]) {
                int tempCount = counts[i];
                counts[i] = counts[k];
                counts[k] = tempCount;

                long tempId = ids[i];
                ids[i] = ids[k];
                ids[k] = tempId;
            }
        }
    }
    employeeList = new ArrayList<>();
    for (long id : ids) {
        try {
            employeeList.add(EmployeeLocalServiceUtil.getEmployee(id));
        } catch (PortalException ignored) {
        }
    }
    Comparator<Integer> comparator = (c1, c2) -> c2.compareTo(c1);
    count.sort(comparator);
    int allTvs = 0;
    for (int current : count) {
        allTvs += current;
    }
    int iterator = 0;
%>
<p>
    <b><liferay-ui:message key="besttvsellers.caption"/></b>
</p>

<liferay-ui:search-container emptyResultsMessage="no-data.caption">
    <liferay-ui:search-container-results
            results="<%= EmployeeLocalServiceUtil.getEmployees(0, employeeList.size())%>"/>

    <liferay-ui:search-container-row
            className="com.isands.service.builder.model.Employee" modelVar="employee">
        <liferay-ui:search-container-column-text name="Last name"
                                                 value="<%=employeeList.get(iterator).getLastName()%>"/>
        <liferay-ui:search-container-column-text name="First name"
                                                 value="<%=employeeList.get(iterator).getFirstName()%>"/>
        <liferay-ui:search-container-column-text name="Patronomic"
                                                 value="<%=employeeList.get(iterator).getPatronymic()%>"/>

        <liferay-ui:search-container-column-text name="TVs count" value="<%=String.valueOf(count.get(iterator))%>"/>
        <%iterator += 1;%>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>



