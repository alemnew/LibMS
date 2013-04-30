<%-- 
    Document   : searchPub
    Created on : Apr 3, 2013, 8:44:43 PM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="favoriteList.jsp"/>
    <jsp:param name="title" value="MK RC | Favorite List" />
</jsp:include>
<sj:head jqueryui="true"/>
<s:if test="hasActionMessages">
    <s:actionmessage/>
</s:if>
<s:if test="hasActionErrors">
    <s:actionerror/>
</s:if>
<s:if test="favList.size()>0">
    <table class="listTable" id="listPub">
        <s:url id="removeAllURL" action="removeAllFavorite"/>
        <s:url id="reserveAllURL" action="submitToReservation">
            <s:param name="userId">%{#session.user}</s:param>
        </s:url>
        <caption>
            <s:a href="%{removeAllURL}">Remove All </s:a> |
            <s:a href="%{reserveAllURL}">Submit Reservation </s:a>
        </caption>
        <tr>
            <th > Pub Id </th>
            <th>Title</th>
            <th>Author</th>
            <th>Pub Date</th>
            <th>Type</th>
            <th>Actions</th>
        </tr>
        <s:iterator value="favList" var="fav">
            <tr>
                <td > <s:property value="pubId"/> </td>
                <td> <s:property value="title" /> </td>
                <td> <s:property value="author" /> </td>
                <td> <s:property value="pubDate" /> </td>
                <td> <s:property value="type" /> </td>
                <td> 
                    <sj:dialog
                        id="delete%{pubId}"  buttons="{ 'Confirm':function() {     
                        $('#main').load('deleteAction.action?pubId='+aux);
                        $(this).dialog('close');
                        },
                        'No':function() {  $(this).dialog('close'); },
                        'Update' :function() {  $(this).dialog('close');
                        }
                        }"
                        resizable="false"
                        autoOpen="false"
                        modal="true"
                        title="Delte?"
                        >
                        Are you sure you want to remove ${title}?
                    </sj:dialog>
                    <s:url id="removeURL" action="removeFavorite">
                        <s:param name="pubId">${pubId}</s:param>
                    </s:url>
                        <a href="#" onclick="remove_fav(${pubId})">remove</a> 

                </td>
            </tr>

        </s:iterator>

    </table>
</s:if>
<s:else>
    <div class="errorMsg">
        <h2>Oops, Your Favorite  list is empty. You can add a publication to your favorite.  </h2>
    </div>
</s:else>
<%@include file="footer.jsp" %>