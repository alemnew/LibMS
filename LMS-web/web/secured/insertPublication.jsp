<%-- 
    Document   : addPublication
    Created on : Mar 30, 2013, 3:50:41 PM
    Author     : alemnew
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="insertPublication.jsp"/>
    <jsp:param name="title" value="MK RC | Insert Publication" />
</jsp:include>
 
<s:form action="InsertPublication" cssClass="form">
    <s:if test="hasActionErrors()">
        <div class="errorMsg">
            <s:actionerror/>
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div class="successMsg">
            <s:actionmessage/>
        </div>
    </s:if>
    <s:textfield key="label.title" name="title"/>
    <s:textfield key="label.author" name="author"/>
    <s:textfield key="label.pubdate" name="pubDate"/>
    <s:textfield key="label.type" name="type"/>
    <s:textfield key="label.callnumber" name="callnumber"/>
    <s:textfield key="label.status" name="status"/>

    <s:submit value="Insert" cssClass="submit" />
</s:form>
<%@include  file="footer.jsp" %>