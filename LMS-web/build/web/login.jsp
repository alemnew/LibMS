<%-- 
    Document   : login
    Created on : Mar 30, 2013, 3:21:50 PM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MK RC | Login Page</title>
    </head>
    <body>
         <s:form action="Login">
            <s:textfield key="username" label="Username"/>
            <s:password key="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>
