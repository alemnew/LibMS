<%-- 
    Document   : searchUser
    Created on : Apr 1, 2013, 12:53:47 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="searchuser.jsp"/>
    <jsp:param name="title" value="MK RC | Search Users" />
</jsp:include>
<s:form action="SearchUser" cssClass="form">
            <s:textfield key="firstName" label="First Name "/>
            <s:textfield key="lastName" label="Last Name "/>
            <s:textfield key="email" label="Email "/>
           
            <s:submit value="Search " cssClass="submit"/>
        </s:form>
<%@include file="footer.jsp" %>