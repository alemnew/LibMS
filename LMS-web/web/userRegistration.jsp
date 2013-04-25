<%-- 
    Document   : userRegistation
    Created on : Mar 30, 2013, 5:07:05 PM
    Author     : alemnew
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="userRegistration.jsp"/>
    <jsp:param name="title" value="MK RC | User Registration" />
</jsp:include>
<s:form action="RegisterUser" cssClass="form">
     <s:if test="hasActionErrors()">
        <div class="errorMsg">
            <s:actionerror/>
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div id="successMsg">
            <s:actionmessage/>
        </div>
    </s:if>
    <s:textfield key="label.firstname" name="firstName" required="true"/>
    <s:textfield key="label.lastname" name="lastName" required="true"/>
    <s:textfield key="label.email" name="email" required="true"/>
    <s:password key="label.password" name="password" required="true"/>
    <s:textfield key="label.phonenumber" name="phoneNumber" required="true"/>
    <s:textfield key="label.address" name="address" required="true"/>
    <s:submit value="Register" cssClass="submit"/>
</s:form>

<%@include file="footer.jsp" %>