<%-- 
    Document   : usersList
    Created on : Apr 1, 2013, 1:59:31 PM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="userList.jsp"/>
    <jsp:param name="title" value="MK RC | User List" />
</jsp:include>
<h1><s:property value="size"/> 
    SUCCESS
</h1>

<%@include file="footer.jsp" %>
