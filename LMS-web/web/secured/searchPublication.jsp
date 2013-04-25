<%-- 
    Document   : serachPublication
    Created on : Mar 31, 2013, 7:16:03 PM
    Author     : alemnew
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="searchPublication.jsp"/>
    <jsp:param name="title" value="MK RC | Search Publication" />
</jsp:include>
<sx:head/>
<s:form action="SearchPublication" cssClass="form">
    <s:textfield key="title" label="Enter Title"/>
    </s:form>
    <table class="listTable" id="listPub">
        <caption> <s:property value="numOfPub"/></caption>
        <!--tr>
            <th > Pub Id </th>

            <th>Title</th>
            <th>Author</th>
            <th>Pub Date</th>
            <th>Type</th>
            <th>Call Number</th>
            <th>Status</th>
            <th>Operation</th>
        </tr-->
        <s:iterator value="PubList" var="publication">
            <tr>
                <td> <s:property value="pubId"/> </td>
                <td> <s:property value="title" /> </td>
                <td> <s:property value="author" /> </td>
                <td> <s:property value="pubDate" /> </td>
                <td> <s:property value="type" /> </td>
                <td> <s:property value="callnumber" /> </td>
                <td> <s:property value="status" /> </td>
                <td> 
                    <a href="editPublication.jsp">Edit</a> | <a href="deletePublicaiton.jsp">Delete</a>
                </td>
            </tr>
        </s:iterator>
    </table>


<%@include file="footer.jsp" %>