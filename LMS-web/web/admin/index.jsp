<%-- 
    Document   : index
    Created on : Mar 29, 2013, 1:37:26 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="index.jsp"/>
    <jsp:param name="title" value="MK RC | Home page" />
</jsp:include>
<s:if test="%{#session.loggedin != 'true'}">
    <s:if test="%{#session.user != 'admin'}">
        <%
            response.sendRedirect("logins.jsp");
        %>
    </s:if>
</s:if>
<div class="welcome">
    <h1>Welcome to Mahibere Kidusan Research Center Library</h1>

    <img src="../images/logo.jpg" width="350" height="338" alt="Mahibere Kidusan"/>
</div>


<%@include file="footer.jsp" %>