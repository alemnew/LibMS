<%-- 
    Document   : contactUs
    Created on : Apr 6, 2013, 11:56:12 AM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="contactUs.jsp"/>
    <jsp:param name="title" value="MK RC | Contact Us" />
</jsp:include>
<h1>Please write us!</h1>
Mahibere Kidusan Research Center<br/>
P.O.Box. 8070<br/>
Addis Ababa,<br/>
ETHIOPIA <br/>
<!--div id="wrapper">
    <div id="form-div">
        <form class="form" id="form1">
            <p class="name">
                <input name="name" type="text" class="validate[required,custom[onlyLetter],length[0,100]] text-input" id="name" value="My Name" />
                <label for="name">Name</label>
            </p>
            <p class="email">
                <input name="email" type="text" class="validate[required,custom[email]] text-input" id="email" value="email@email.com" />
                <label for="email">E-mail</label>
            </p>
            <p class="web">
                <input type="text" name="web" id="web" />
                <label for="web">Website</label>
            </p>
            <p class="text">
                <textarea name="text" class="validate[required,length[6,300]] text-input" id="comment">Hello world</textarea>
            </p>
            <p class="submit">
                <input type="submit" value="Send" />
            </p>
        </form>

    </div-->
    <%@include file="footer.jsp" %>