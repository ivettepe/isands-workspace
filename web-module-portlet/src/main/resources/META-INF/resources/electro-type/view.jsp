<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
    <b><liferay-ui:message key="electro.type.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addElectroTypeURL">
        <portlet:param name="mvcPath" value="/electro-type/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addElectroTypeURL%>" value="Add electro type"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=ElectroTypeLocalServiceUtil.getElectroTypesCount()%>">
    <liferay-ui:search-container-results
            results="<%=ElectroTypeLocalServiceUtil.getElectroTypes(0, Integer.MAX_VALUE)%>"/>

    <liferay-ui:search-container-row className="com.isands.service.builder.model.ElectroType" modelVar="electroType">
        <liferay-ui:search-container-column-text name="name" value="<%=electroType.getName()%>"/>
        <liferay-ui:search-container-column-jsp name="Manage" path="/electro-type/actions.jsp"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>