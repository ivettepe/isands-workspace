<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
    <b><liferay-ui:message key="employee.position.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addPostionURL">
        <portlet:param name="mvcPath" value="/position-type/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addPostionURL%>" value="Add position type"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=PositionTypeLocalServiceUtil.getPositionTypesCount()%>">
    <liferay-ui:search-container-results
            results="<%=PositionTypeLocalServiceUtil.getPositionTypes(0, Integer.MAX_VALUE)%>"/>

    <liferay-ui:search-container-row className="com.isands.service.builder.model.PositionType" modelVar="positionType">
        <liferay-ui:search-container-column-text name="Name" value="<%= positionType.getName()%>"/>
        <liferay-ui:search-container-column-jsp name="Manage" path="/position-type/actions.jsp"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>