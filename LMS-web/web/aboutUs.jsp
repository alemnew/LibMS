<%-- 
    Document   : aboutUs
    Created on : Apr 6, 2013, 11:58:27 AM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="aboutUs.jsp"/>
    <jsp:param name="title" value="MK RC | About Us" />
</jsp:include>
<div class="welcome">
    <h1>Welcome to Mahibere Kidusan Research Center Library</h1>

    <img src="images/logo.jpg" width="350" height="338" alt="Mahibere Kidusan"/>
</div>

<%@include file="footer.jsp" %>