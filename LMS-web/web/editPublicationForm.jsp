<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="editPublicationForm.jsp"/>
    <jsp:param name="title" value="MK RC | Edit Publication Form" />
</jsp:include>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head/>
<s:form action="EditPublication" cssClass="form">
    <s:textfield key="pubId" label="Publication Id" value=""/>
</s:form>
<s:iterator value="PubList" var="publication">

</s:iterator>

<%@include file="footer.jsp" %>