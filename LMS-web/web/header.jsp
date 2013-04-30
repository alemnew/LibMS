<%-- 
    Document   : header
    Created on : Apr 2, 2013, 8:13:46 PM
    Author     : asrese
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <sj:head jqueryui="true"/>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>${param.title} </title>

        <meta name="keywords" content="" />

        <meta name="description" content="" />
        <link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />
        <!-- for contact us-->
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/contactus_validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />

        <link rel="stylesheet" href="css/contactus_template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine.js" type="text/javascript"></script>
        <script src="js/mkrc.js" type="text/javascript"></script>
        <!-- contct us end-->
        <SCRIPT>
            $(document).ready(function() {
 
                var div = $('#mainmenu');
                var start = $(div).offset().top;
 
                $.event.add(window, "scroll", function() {
                    var p = $(window).scrollTop();
                    $(div).css('position',((p)>start) ? 'fixed' : 'static');
                    $(div).css('top',((p)>start) ? '0px' : '');
                    $(div).css('left',((p)>start) ? '0px' : ''); 
                });
 
            });
           
          
        </SCRIPT>
        
        <!-- Hide list table -->
        <!-- Fixed header end-->

        <script type="text/javascript" >
            $(document).ready(function()
            {
                $(".account").click(function()
                {
                    var X=$(this).attr('id');

                    if(X==1)
                    {
                        $(".accsubmenu").hide();
                        $(this).attr('id', '0');	
                    }
                    else
                    {

                        $(".accsubmenu").show();
                        $(this).attr('id', '1');
                    }
	
                });

                //Mouseup textarea false
                $(".accsubmenu").mouseup(function()
                {
                    return false
                });
                $(".account").mouseup(function()
                {
                    return false
                });


                //Textarea without editing.
                $(document).mouseup(function()
                {
                    $(".accsubmenu").hide();
                    $(".account").attr('id', '');
                });
	
            });
	
        </script>
        <!-- adv search -->
        <script>
		$(document).ready(function() {
		  $('.advSearchLink').click(function(){
			//get collapse content selector
			var collapse_content_selector = $(this).attr('href');					
 
			//make the collapse content to be shown or hide
			var toggle_switch = $(this);
			$(collapse_content_selector).toggle(function(){
			  if($('advSearchForm').css('display')=='none'){
                                //change the button label to be 'Show'
				toggle_switch.html('Show');
			  }else{
                                //change the button label to be 'Hide'
				toggle_switch.html('Hide');
			  }
			});
		  });
 
		});	
		</script>
        <!--account-->
        <script type="text/javascript">
            $(document).ready(function(){ 
                $("#searchtxt").val("Search...").addClass("empty");
                $("#searchtxt").focus(function(){
                    if($(this).val() == "Search...") {
                        $(this).val("").removeClass("empty");;
                    }
                });
                $("#searchtxt").blur(function(){
                    if($(this).val() == "") {
                        $(this).val("Search...").addClass("empty");	
                    }
                });
            });
          
        </script>
        


    </head>
    <body>
        <!-- start header -->
        <div id="header">
            <div class="login">
                <s:if test="%{#session.loggedin != 'true'}">
                    <a  href="login.jsp">Login</a>
                </s:if>
                <s:else>
                    <div class="dropdown">
                        <a class="account" >
                            <span>My Account</span>
                        </a>
                        <div class="accsubmenu" style="display: none; ">

                            <ul class="root">
                                <li >
                                    <s:url id="myProfile" action="displayProfile">
                                        <s:param name="userId">%{#session.user}</s:param>
                                    </s:url>
                                    <s:a href="%{myProfile}" >Profile</s:a>
                                    </li>
                                    <li >
                                    <s:url id="myReservationURL" action="listReservation">
                                        <s:param name="userId">%{#session.user}</s:param>
                                    </s:url>
                                    <s:a href="%{myReservationURL}">My Reservations </s:a>
                                    </li>
                                    <li >
                                        <a href="getFavListContent">Favorites </a>
                                    </li>
                                    <li>
                                        <a href="logouts">Log Out</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--s:property value="%{#session.user}"/--> 
                </s:else>
            </div>
        </div>
        <!-- end header -->
        <!-- star menu -->
        <div id="mainmenu">
            <ul id="menu">
                <li class="current"><a href="index.jsp">Home</a></li> 
                <li>
                    <a href="#">Publications</a>
                    <ul class="submenu">
                        <li><a href="searchPublication.jsp">Search Publication</a>
                            <ul>
                                <li><a href="">Search by Title</a></li>
                                <li><a href="">Search by Author</a></li>

                            </ul>
                        </li>
                        <li><a href="">Add Publication</a>
                            <ul>
                                <li><a href="editPublication.jsp">Update Existing</a></li>
                                <li><a href="insertPublication.jsp">Add New Publication</a></li>
                            </ul>
                        </li>
                        <li><a href="">Manage Publication</a>
                            <ul>
                                <li><a href="editPublication.jsp">Update Existing</a></li>
                                <li><a href="deletePublication.jsp">Delete Publication</a></li>
                            </ul>
                        </li>
                        <li><a href="">New Arrivals</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">Staffs</a>
                    <ul class="submenu">
                        <li><a href="searchStaff.jsp">Search Staff</a>
                            <ul>
                                <li><a href="">Search by Name</a></li>
                                <li><a href="">Search by Email</a></li>

                            </ul>
                        </li>
                        <li><a href="">Register Staff</a>
                            <ul>
                                <li><a href="">Update Existing</a></li>
                                <li><a href="staffRegistration.jsp">Add New Staff</a></li>
                            </ul>
                        </li>
                        <li><a href="">Manage Staffs</a></li>
                        <li><a href="">New Staffs</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">Users</a>
                    <ul class="submenu">
                        <li><a href="searchUser.jsp">Search User</a>
                            <ul>
                                <li><a href="">Search by Name</a></li>
                                <li><a href="">Search by Email</a></li>

                            </ul>
                        </li>
                        <li><a href="">Register user</a>
                            <ul>
                                <li><a href="">Update Existing</a></li>
                                <li><a href="userRegistration.jsp">Add New User</a></li>
                            </ul>
                        </li>
                        <li><a href="">Manage Users</a></li>
                        <li><a href="">New users</a></li>
                    </ul>
                </li>
                <li><a href="aboutUs.jsp">About us</a></li>
                <li><a href="contactUs.jsp">Contact us</a></li>
                <li id="searchfrm">
                    <form id="searchform2" method="get" action="">
                        <input type="text" size="40" id="searchtxt" class="empty"/>
                    </form>
                </li>
            </ul>
        </div>
        <!-- end menu -->
        <!-- start page -->
        <div id="page">
            <!-- start content -->
            <div id="content">
                <div class="post">
                    <div class="actualcontent">

