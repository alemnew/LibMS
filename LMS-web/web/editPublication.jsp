<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="editPublication.jsp"/>
    <jsp:param name="title" value="MK RC | Edit Publication" />
</jsp:include>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:form action="ListPublication" cssClass="form">
    <s:textfield key="pubId" label="Enter Publication Id"/>
    <s:submit value="Search" cssClass="submit"/>
</s:form>

<%@include file="footer.jsp" %>