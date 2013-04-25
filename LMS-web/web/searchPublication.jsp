<%-- 
    Document   : serachPublication
    Created on : Mar 31, 2013, 7:16:03 PM
    Author     : alemnew
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="searchPublication.jsp"/>
    <jsp:param name="title" value="MK RC | Search Publication" />
</jsp:include>
<sj:head jqueryui="true"/>
<s:form action="SearchPublication" cssClass="form">
    <s:if test="hasActionMessages()">
        <div class="successMsg">
            <s:actionmessage/>
        </div>
    </s:if>
    <s:if test="hasActionErrors()">
        <div class="errorMsg">
            <s:actionerror/>
        </div>
    </s:if>
    <s:textfield key="title" label="Enter Title"/>

    <s:if test="PubList.size()>0">
        <table class="listTable" id="listPub">
            <caption> <s:property value="numOfPub"/></caption>
            <tr>
                <th > Pub Id </th>

                <th>Title</th>
                <th>Author</th>
                <th>Pub Date</th>
                <th>Type</th>
                <!--th>Call Number</th-->
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <s:iterator value="PubList" var="publication">
                <tr>


                    <td > <s:property value="pubId"/> </td>
                    <td> <s:property value="title" /> </td>
                    <td> <s:property value="author" /> </td>
                    <td> <s:property value="pubDate" /> </td>
                    <td> <s:property value="type" /> </td>
                    <td> <s:property value="status" /> </td>
                    <td> 
                        <sj:dialog id="%{pubId}" autoOpen="false" modal="true" title="Edit Publication" showEffect="slide" hideEffect="slide">
                            <form id="%{pubId}" action="EditPublication" method="POST">
                                <input type="hidden" name="pubId" value="${pubId}"/>

                                <label><b>${title}</label></b>( ${author})

                                <input type="text" name="pubId" autocomplete="off" value="${pubId}" disabled="true" />
                                <input type="text" name="title" autocomplete="off" value="${title}" />
                                <input type="text" name="author" autocomplete="off" value="${author}" />
                                <input type="text" name="pubDate" autocomplete="off" value="${pubDate}" />
                                <input type="text" name="type" autocomplete="off" value="${type}"/>
                                <input type="text" name="callnumber" autocomplete="off" value="${callnumber}" />
                                <input type="text" name="status" autocomplete="off" value="${status}" />
                                <input type="submit" name="Update" value="Update" class="submit"/><br/>
                            </form>
                        </sj:dialog>

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
                        <s:url id="removeURL" action="deletePublication">
                            <s:param name="pubId">${pubId}</s:param>
                        </s:url>
                        <s:url id="reserveURL" action="ReservePublication">
                            <s:param name="pubId">${pubId}</s:param>
                            <s:param name="userId">%{#session.user}</s:param>
                        </s:url>
                        <sj:a openDialog="%{pubId}" href="#">edit</sj:a>|
                        <s:a href="%{removeURL}">remove</s:a> |
                        <s:a href="%{reserveURL}">Reserve </s:a>
                        </td>
                    </tr>
            </s:iterator>
        </table>
    </s:if>
</s:form>

<%@include file="footer.jsp" %>