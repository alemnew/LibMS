<%-- 
    Document   : searchPub
    Created on : Apr 3, 2013, 8:44:43 PM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="pubList.jsp"/>
    <jsp:param name="title" value="MK RC | Reservation List" />
</jsp:include>
<sj:head jqueryui="true"/>
<s:if test="reservationDummy.size()>0">
    <table class="listTable" id="listRes">
        <caption ><h3>Your Reservations</h3></caption>
        <tr>
            <th>Res. No. </th>
            <th>Title</th>
            <th>Author</th>
            <th>Pub Date</th>
            <th>Type</th>
            <th>Expected Date</th>
            <th>Actions</th>
        </tr>
        <s:iterator value="reservationDummy" var="res">
            <tr>
                <td><s:property value="id"/></td>
                <td> <s:property value="title" /> </td>
                <td> <s:property value="author" /> </td>
                <td> <s:property value="pubDate" /> </td>
                <td> <s:property value="type" /> </td>
                <td> <s:property value="expRetDate" /> </td>
                <td> 
                    <a href="#" onclick="cancel_reservation(${id})">Cancel</a>
                    <s:url id="removeReservationURL" action="cancelReservation">
                        <s:param name="id">${id}</s:param>
                    </s:url>
                </td>
                </tr>
        </s:iterator>
    </table>
</s:if>
<s:else>
    <div class="errorMsg"><h2>No Reservation found</h2></div>
</s:else>
<%@include file="footer.jsp" %>