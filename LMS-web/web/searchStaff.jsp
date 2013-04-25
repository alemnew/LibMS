<%-- 
    Document   : searchStaff
    Created on : Apr 6, 2013, 2:51:45 PM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="searchStaff.jsp"/>
    <jsp:param name="title" value="MK RC | Search Staff" />
</jsp:include>
<h1><s:property value="size"/> 
    SUCCESS
</h1>

<%@include file="footer.jsp" %>