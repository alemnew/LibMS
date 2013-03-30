<%-- 
    Document   : register_staff
    Created on : Mar 30, 2013, 1:01:13 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MKRC | Register Staffs </title>
    </head>
    <body>
        <s:form action="RegisterStaff">
            <s:textfield key="fullname" label="Enter Full name"/>
            <s:textfield key="email" label="Enter Email Address"/>
            <s:textfield key="username" label="Enter Username"/>
            <s:password key="password" label="Enter Password"/>
            <s:submit value="Register"/>
        </s:form>
    </body>
</html>
