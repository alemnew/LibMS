<%-- 
    Document   : addPublication
    Created on : Mar 30, 2013, 3:50:41 PM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MKRC | Add Publication  </title>
    </head>
    <body>
        <s:form action="AddPublication">
            <s:textfield key="title" label="Enter Title"/>
            <s:textfield key="author" label="Enter the Author"/>
            <s:textfield key="pubDate" label="Enter Publicaiton Date"/>
            <s:textfield key="type" label="Enter Type"/>
            <s:textfield key="callNumber" label="Enter Call Number"/>
            <s:textfield key="status" label="Enter Status"/>
            
            <s:submit value="Insert"/>
        </s:form>
    </body>
</html>