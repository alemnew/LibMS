<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="deletePublication.jsp"/>
    <jsp:param name="title" value="MK RC | Delete Publication" />
</jsp:include>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head/>
<s:form action="deletePublication" cssClass="form">
    <s:textfield key="pubId" label="Enter Publication Id"/>
    <s:submit value="Delete" cssClass="submit"/>
</s:form>

<%@include file="footer.jsp" %>