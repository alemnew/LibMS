<%-- 
    Document   : searchPub
    Created on : Apr 3, 2013, 8:44:43 PM
    Author     : asrese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="pubList.jsp"/>
    <jsp:param name="title" value="MK RC | Publication List" />
</jsp:include>

        <h2>Publications</h2>
        <s:property value="numOfPub"/>
        <table class="listTable">
            <tr>
                <th>Pub Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Pub Date</th>
                <th>Type</th>
                <th>Call Number</th>
                <th>Status</th>
            </tr>
            <s:iterator value="PubList" var="publication">
                <tr>
                    <td> <s:property value="pubId" /> </td>
                    <td> <s:property value="title" /> </td>
                    <td> <s:property value="author" /> </td>
                    <td> <s:property value="pubDate" /> </td>
                    <td> <s:property value="type" /> </td>
                    <td> <s:property value="callNumber" /> </td>
                    <td> <s:property value="status" /> </td>
                </tr>
            </s:iterator>
        </table>
        <%@include file="footer.jsp" %>