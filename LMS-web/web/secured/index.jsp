<%-- 
    Document   : login
    Created on : Mar 30, 2013, 3:21:50 PM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="login.jsp"/>
    <jsp:param name="title" value="MK RC | Login" />
</jsp:include>
<s:if test="hasActionErrors()">
    <div class="errorMsg">
        <s:actionerror/>
    </div>
</s:if>

<div id="loginbox">
    <div class="elements">
        <div class="avatar"></div>

        <s:form action="authenticateUser">
            <s:textfield key="email" required="true"  labelSeparator="" label="" cssClass="username" placeholder="Username or Email" />
            <s:password key="password" required="true"  labelSeparator="" label="" cssClass="password" placeholder="••••••••" />
            <s:checkbox key="remember" label="Remember?"   cssClass="checkbox" value="1" />
            <s:submit value="Login" cssClass="submit"  />
        </s:form>
    </div> 
</div>
<%@include file="footer.jsp" %>