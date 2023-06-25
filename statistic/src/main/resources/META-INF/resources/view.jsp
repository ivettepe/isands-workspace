<%@ page import="com.isands.service.builder.model.Purchase" %>
<%@ page import="com.isands.service.builder.service.*" %>
<%@ page import="java.util.*" %>
<%@ include file="init.jsp" %>

<p>
    <b><liferay-ui:message key="statistic.caption"/></b>
</p>

<%
    List<Purchase> purchaseList = PurchaseLocalServiceUtil.getPurchases(0, PurchaseLocalServiceUtil.getPurchasesCount());
    List<Employee> employeeList = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
    List<Electronics> electronicsList = ElectronicsLocalServiceUtil.getElectronicses(0, ElectronicsLocalServiceUtil.getElectronicsesCount());
    List<ElectroType> electroTypes = ElectroTypeLocalServiceUtil.getElectroTypes(0, ElectroTypeLocalServiceUtil.getElectroTypesCount());
    long totalMoney = 0;
    Map<Integer, Map<Integer, Integer>> salesByEmployeeAndElectroType = new java.util.HashMap<>();
    for (Purchase purchase : purchaseList) {
        long employeeId = purchase.getEmployeeId();
        long electronicsId = purchase.getElectronicsId();
        int count = purchase.getCount();
        Electronics electronics = electronicsList.get((int) (electronicsId - 1));
        ElectroType electroType = electroTypes.get((int) (electronics.getElectroTypeId() - 1));
        if (electroType.getName().equalsIgnoreCase("Smartphones") || electroType.getName().equalsIgnoreCase("Tablets")) {
            long totalPrice = count * electronics.getPrice();
            long currentSales = salesByEmployeeAndElectroType.
                    getOrDefault((int) employeeId, new HashMap<>()).getOrDefault((int) electroType.getElectroTypeId(), 0);
            salesByEmployeeAndElectroType.computeIfAbsent((int) employeeId, k -> new HashMap<>()).
                    put((int) electroType.getElectroTypeId(), (int) (currentSales + totalPrice));
            totalMoney += totalPrice;
        }
        if (electroType.getName().equalsIgnoreCase("Smart watches")) {
            long totalPrice = count * electronics.getPrice();
            totalMoney += totalPrice;
        }
    }
    int maxSales = 0;
    Employee topSalesEmployee = null;
    for (Map.Entry<Integer, Map<Integer, Integer>> entry : salesByEmployeeAndElectroType.entrySet()) {
        int employeeId = entry.getKey();
        Employee employee = employeeList.get(employeeId - 1);
        int totalSales = 0;
        Map<Integer, Integer> salesByElectroType = entry.getValue();
        for (Map.Entry<Integer, Integer> salesEntry : salesByElectroType.entrySet()) {
            totalSales += salesEntry.getValue();
        }
        if (totalSales > maxSales && PositionTypeLocalServiceUtil.getPositionType(employee.getPositionId()).getName().equals("Intern")) {
            maxSales = totalSales;
            topSalesEmployee = employee;
        }
    }
    String bestIntern;
    if (topSalesEmployee != null) {
        bestIntern = topSalesEmployee.getLastName() +
                " " + topSalesEmployee.getFirstName() + " " + topSalesEmployee.getPatronymic();
    } else {
        bestIntern = "No employee with type Intern found.";
    }

    long electroTypeId = 1;
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
    List<Purchase> purchases = PurchaseLocalServiceUtil.getPurchases(0, Integer.MAX_VALUE);
    List<Integer> count = new ArrayList<>();
    for (Purchase purchase : purchases) {
        Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectronicsId());
        if (electronics.getElectroTypeId() == electroTypeId && purchase.getPurchaseDate().after(from)) {
            count.add(purchase.getCount());
        }
    }
    int allTvs = 0;
    for (int current : count) {
        allTvs += current;
    }
%>

<liferay-ui:error key="card-error" message="failure.card-error"/>
<liferay-ui:error key="archived-error" message="failure.archived-error"/>
<br>
<h4>
    <b>The best smartphone and tablet sales intern: <%=bestIntern%>
    </b>
</h4>
<br>
<h4>
    <b>Total sold smartphones, tablets and smart watches for: <%= totalMoney%>
    </b>
</h4>
<br>
<h4>
    <b>Number of TVs sold in the last month: <%= allTvs%>
    </b>
</h4>