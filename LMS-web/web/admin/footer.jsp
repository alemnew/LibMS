</div>
</div>
</div>
<!-- end content -->
<!-- start sidebar -->
<div id="sidebar">


    <!--div id="search">
        <form id="searchform" method="get" action="">
            <fieldset>
                <input name="s" type="text" size="40" id="searchtxt"  class="empty" />
                <input type="submit" id="x" value="Search"  class="searchbtn"/>
            </fieldset>
        </form>
    </div-->
    <br/>
    <ul>
        <li id="qucik_link">
            <h2>Quick Link</h2>
            <ul>
                <s:if test="%{#session.loggedin == 'true'}">
                    <li >
                    <s:url id="myProfile" action="displayProfile">
                        <s:param name="userId">%{#session.user}</s:param>
                    </s:url>
                    <s:a href="%{myProfile}" >Profile</s:a>
                    </li>
                    <li>
                    <s:url id="myReservationURL" action="listReservation">
                        <s:param name="userId">%{#session.user}</s:param>
                    </s:url>
                    <s:a href="%{myReservationURL}">My Reservations </s:a>
                    </li>
                    <li >
                        <a href="getFavListContent">Favorites </a>
                    </li>
                </s:if>
                <s:else>
                    <a  href="login.jsp">Login</a>
                </s:else>
                <li><a href="#">Users</a>  </li>
                <li><a href="#">New Arrivals</a> </li>
            </ul>
        </li>
        <li id="calendar"> <br/></li>

        <li id="links">
            <h2>Links</h2>
            <ul>
                <li><a href="#">Mahibere Kidusan</a></li>
                <li><a href="#">Mahibere Kidusan Multimedia </a></li>
                <li><a href="#">Mahibere Kidusan TV</a></li>
                <li><a href="#">Mahibere Kidusan Radio</a></li>
                <li><a href="#">EOTC </a></li>
                <li><a href="#">Others</a></li>
            </ul>
        </li>
    </ul>
</div>
<!-- end sidebar -->
<div id="extra" style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<!-- start footer -->
<div id="footer">
    <p class="legal"> &copy;2013 Mahibere Kidusan. All Rights Reserved.
        <br/>
        Developed by:  <a href="#">Alemnew Sheferaw Asrese</a> </p>

</div>
<!-- end footer -->
</body>
</html>