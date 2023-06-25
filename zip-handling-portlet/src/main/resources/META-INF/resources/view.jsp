<%@include file="init.jsp" %>

<portlet:actionURL name="uploadZippedCsvData" var="uploadFileURL"/>
<h3>Upload zipped tables data</h3>
<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
    <liferay-ui:error key="cant-read-file" message="One of the files can not be read"/>
    <liferay-ui:error key="invalid-data-format" message="Invalid data formatting in .csv files"/>
    <liferay-ui:error key="table-not-found" message="One of csv files references not existing table"/>
    <liferay-ui:error key="unsupported-file-format" message="This kind of archive is not supported"/>
    <liferay-ui:error key="error" message="Error when performing request"/>

    <aui:input label="Zip archive" type="file" name="uploadedFile">
        <aui:validator name="acceptFiles">'zip, 7z'</aui:validator>
    </aui:input>

    <aui:input type="submit" value="Upload data" name="submit"/>
</aui:form>
