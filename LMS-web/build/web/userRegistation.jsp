<%-- 
    Document   : userRegistation
    Created on : Mar 30, 2013, 5:07:05 PM
    Author     : alemnew
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MKRC | User Registration  </title>
    </head>
    <body>
        <s:form action="RegisterUser">
            <s:textfield key="fName" label="First Name "/>
            <s:textfield key="lName" label="Last Name "/>
            <s:textfield key="email" label="Email "/>
            <s:password key="password" label="Password"/>
            <s:textfield key="phoneNumber" label="Phone Number"/>
            <s:textfield key="address" label="Address"/>
            
            <s:submit value="Register"/>
        </s:form>
    </body>
</html>