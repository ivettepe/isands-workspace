<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.isands.service.builder.service.ElectronicsLocalServiceUtil" %>
<%@ page import="com.isands.service.builder.service.ElectroTypeLocalServiceUtil" %>
<%@include file="../init.jsp" %>

<%
    long electronicsId = ParamUtil.getLong(request, "electronicsId");
    Electronics electronics = null;
    if (electronicsId > 0) {
        try {
            electronics = ElectronicsLocalServiceUtil.getElectronics(electronicsId);
        } catch (PortalException ignored) {
        }
    }
%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/electronics/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name='<%= electronics == null ? "addElectronics" : "updateElectronics"%>' var="editElectronicsURL"/>


<aui:form action="<%= editElectronicsURL %>" name="<portlet:namespace />fm" method="post">
    <h3>
        <%= electronics == null ? "Create electronics" : "Edit existing electronics"%>
    </h3>

    <liferay-ui:error key="required-field-empty" message="failure.required-field-empty"/>
    <liferay-ui:error key="invalid-electronics-price" message="failure.invalid-electronics-price"/>
    <liferay-ui:error key="invalid-electronics-count" message="failure.invalid-electronics-count"/>

    <aui:fieldset>
        <aui:input name="electronicsId" type="hidden"
                   value='<%= electronics == null ? "" : electronics.getElectronicsId() %>'>
        </aui:input>

        <aui:input label="Electronics name" name="name" value='<%= electronics == null ? "" : electronics.getName() %>'>
            <aui:validator name="maxLength">150</aui:validator>
        </aui:input>

        <aui:input label="Price" name="price" min="0" value='<%= electronics == null ? "" : electronics.getPrice() %>'>
            <aui:validator name="min">1</aui:validator>
        </aui:input>

        <aui:select label="Electro type" name="ElectroTypeId"
                    value='<%= electronics == null ? "" : electronics.getElectroTypeId() %>'>
            <c:forEach
                    items="<%=ElectroTypeLocalServiceUtil.getElectroTypes(0, Integer.MAX_VALUE)%>"
                    var="electroType">
                <aui:option value="${electroType.getElectroTypeId()}">${electroType.getName()}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:input label="Count in stock" type="text" min="0" name="count"
                   value='<%= electronics == null ? "" : electronics.getCount() %>'>
            <aui:validator name="min">0</aui:validator>
        </aui:input>

        <aui:input label="Archive" type="checkbox" name="archive"
                   value='<%=electronics != null && electronics.getArchive() %>'/>

        <aui:input label="Description" type="textarea" name="description"
                   value='<%= electronics == null ? "" : electronics.getDescription() %>'>
            <aui:validator name="maxLength">5000</aui:validator>
        </aui:input>

    </aui:fieldset>
    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>