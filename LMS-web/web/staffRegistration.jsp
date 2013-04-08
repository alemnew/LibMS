<%-- 
    Document   : register_staff
    Created on : Mar 30, 2013, 1:01:13 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="register_staff.jsp"/>
    <jsp:param name="title" value="MK RC | Register Staff" />
</jsp:include>

<s:form action="RegisterStaff" cssClass="form">
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

    <s:textfield key="label.fullname" name="fullname" required="true" requiredposition="right"/>
    <s:textfield key="label.email" name="email" required="true"/>
    <s:textfield key="label.username" name="username" required="true"/>
    <s:password key="label.password" name="password" required="true"/>
    <s:submit value="Register" cssClass="submit"/>
</s:form>
<%@include file="footer.jsp" %>
