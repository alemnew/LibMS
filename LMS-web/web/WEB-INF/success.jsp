<%-- 
    Document   : success
    Created on : Mar 29, 2013, 1:49:19 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="../header.jsp" flush="ture">
    <jsp:param name="id" value="register_staff.jsp"/>
    <jsp:param name="title" value="MK RC | Success" />
</jsp:include>
<s:if test="hasActionMessages()">
    <div class="successMsg">
        <s:actionmessage/>
    </div>  
</s:if>

<%@include  file="../footer.jsp" %>
