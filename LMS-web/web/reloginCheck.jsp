<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#session.loggedin == 'true'}">
<jsp:forward page="/LoginSuccess.jsp" />
</s:if>
