<%-- 
    Document   : success
    Created on : Mar 29, 2013, 1:49:19 AM
    Author     : alemnew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" flush="ture">
    <jsp:param name="id" value="profile.jsp"/>
    <jsp:param name="title" value="MK RC | Profile" />
</jsp:include>
<sj:head jqueryui="true"/>
<s:if test="user.size()>0">
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
    <table class="listTable" id="listUser">
        <s:iterator value="user" var="userList">
            <caption>
                <sj:dialog id="profile%{userId}" autoOpen="false" modal="true" title="Edit Profile" showEffect="slide" hideEffect="slide">
                    <table>
                        <caption>
                            <form id="%{userId}" action="editProfile" method="POST">
                                <input type="hidden" name="userId" value="${userId}"/>
                                <input type="hidden" name="password" value="${password}"/>
                        </caption>
                        <tr>
                            <td> <label for="userId">User Id:</label>  </td>
                            <td>  <label for="userId">${userId}</label> </td>
                        </tr>
                        <tr>
                            <td>  <label for="firstName">First name:</label> </td>
                            <td> <input type="text" name="firstName" autocomplete="off" value="${firstName}" />  </td>
                        </tr>
                        <tr>
                            <td>  <label for="lastName">Last name:</label> </td>
                            <td>  <input type="text" name="lastName" autocomplete="off" value="${lastName}" /> </td>
                        </tr>
                        <tr>
                            <td>  <label for="email">Email:</label> </td>
                            <td>  <input type="text" name="email" autocomplete="off" value="${email}" /> </td>
                        </tr>
                        
                        <tr>
                            <td>  <label for="phoneNumber">Phone number:</label> </td>
                            <td>  <input type="text" name="phoneNumber" autocomplete="off" value="${phoneNumber}"/> </td>
                        </tr>
                        <tr>
                            <td> <label for="address">Address:</label>  </td>
                            <td> <input type="text" name="address" autocomplete="off" value="${address}" />  </td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td> 
                                <input type="submit" name="Update" value="Update" class="submit"/>
                            </td>
                        </tr>
                        </form>
                    </table>
                </sj:dialog>
                <sj:dialog id="pswd%{userId}" autoOpen="false" modal="true" title="Edit Profile" showEffect="slide" hideEffect="slide" >
                    <table>
                        <caption>
                            <form id="%{userId}pswd" action="changePassword" method="POST">
                                <input type="hidden" name="userId" value="${userId}"/>
                        </caption>
                        <tr>
                            <td><label for="currentPswd" > Current Password: </label></td>
                            <td><input type="password" name="currentPswd" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td><label for="newPswd"> New  Password: </label></td>
                            <td><input type="password" name="newPswd" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td><label for="confirmPswd"> Confirm  Password: </label></td>
                            <td><input type="password" name="confirmPswd" autocomplete="off" /></td>
                        </tr>
                        <tr> 
                            <td></td>
                            <td><input type="submit" name="Change" value="Update" class="submit"/></td>
                        </tr>
                        </form> 
                    </table>
                </sj:dialog>
                <sj:a openDialog="profile%{userId}" href="#">edit</sj:a>|  <sj:a openDialog="pswd%{userId}" href="#">Change Password</sj:a>
            </caption>

            <tr>
                <td>First name</td>
                <td><s:property value="firstName"/></td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><s:property value="lastName"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><s:property value="email"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>***********</td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><s:property value="phoneNumber"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><s:property value="address"/></td>

            </tr>

        </s:iterator>

    </table> 
</s:if>

<%@include  file="footer.jsp" %>
