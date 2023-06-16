<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
    <b><liferay-ui:message key="electronics.caption"/></b>
</p>
<liferay-ui:error key="consistency-violation" message="failure.consistency-violation"/>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addElectronicsURL">
        <portlet:param name="mvcPath" value="/electronics/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addElectronicsURL%>" value="Add electronics"/>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=ElectronicsLocalServiceUtil.getElectronicsesCount()%>">
    <liferay-ui:search-container-results
            results="<%=ElectronicsLocalServiceUtil.getElectronicses(searchContainer.getStart(), searchContainer.getEnd())%>"/>

    <liferay-ui:search-container-row className="com.isands.service.builder.model.Electronics" modelVar="electronics">
        <%
            String electroTypeName = "UNKNOWN";
            try {
                electroTypeName = ElectroTypeLocalServiceUtil.getElectroType(electronics.getElectroTypeId()).getName();
            } catch (PortalException ignored) {
            }
        %>
        <liferay-ui:search-container-column-text name="Name" value="<%=electronics.getName()%>"/>
        <liferay-ui:search-container-column-text name="Price">
            ${electronics.getPrice()}
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Number of electronicss in stock">
            ${electronics.getCount()}
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Available is stock"
                                                 value='<%=electronics.getInStock() ? "In stock" : "Out of stock"%>'/>
        <liferay-ui:search-container-column-text name="Electronics type" value="<%=electroTypeName%>"/>
        <liferay-ui:search-container-column-text name="Archived"
                                                 value='<%=electronics.getArchive() ? "Archived" : "Not archived"%>'/>
        <liferay-ui:search-container-column-text name="Description" value="<%=electronics.getDescription()%>"/>

        <liferay-ui:search-container-column-jsp name="Manage" path="/electronics/actions.jsp"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>