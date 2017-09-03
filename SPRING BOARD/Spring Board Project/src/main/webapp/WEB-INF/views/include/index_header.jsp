<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
 <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>사이트 이름</title>
	<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
	<link href="assets/css/table-responsive.css" rel="stylesheet">
	<link href="assets/list_css/comboBox.css" rel="stylesheet">
	<link href="assets/list_css/search.css" rel="stylesheet">
	
	 <script src="assets/js/chart-master/Chart.js"></script>
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal.bNick" var="nick"/>
		<security:authentication property="principal" var="principal"/>
	

	<!-- 웹 소켓 사용해서 현재 몇개의 쪽지가 도착했는지 구해오기. --> 
	<!-- 웹 소켓 사용해서 현재 몇개의 미확인 댓글이 있는지 구해오기. --> 
    <script type="text/javascript">
    var wsUri = "ws://localhost:8181/ex/count";
    function send_message() {
        websocket = new WebSocket(wsUri);
        websocket.onopen = function(evt) {
            onOpen(evt);
        };
        websocket.onmessage = function(evt) {
            onMessage(evt);
        };
        websocket.onerror = function(evt) {
            onError(evt);
        };
    }
   
    function onOpen(evt) 
    {
    	websocket.send("${nick}");
    }
    function onMessage(evt) {
    	var jsonObj=JSON.parse(evt.data);
    	$('#count').append(jsonObj.noteCnt);
    	$('#notificationCnt').append(jsonObj.notificationCnt);
    	
    	var html="", id="", nick="", title="";
    	for(var i=0; i<jsonObj.notificationCnt; i++)
    	{
    		id=jsonObj.notificationArray[i].id;
    		nick=jsonObj.notificationArray[i].nick;
    		title=jsonObj.notificationArray[i].title;
    		html+=("<li><a href='content_view?bId="+id+"'>["+nick+"]님이 회원님의 ["+title+"]글에 댓글을 작성하였습니다.</a></li>");
    	}
    	document.getElementById("notificationDiv").innerHTML=html;
    }
    function onError(evt) {
    }
    
    $(document).ready(function(){
    	send_message();
    });
    		
    function popupOpen(){
  	  	var windowW = 400;  // 창의 가로 길이
        var windowH = 385;  // 창의 세로 길이
        var left = Math.ceil((window.screen.width - windowW)/2);
        var top = Math.ceil((window.screen.height - windowH)/2);
		window.open("write_view","pop_01"," top="+top+", left="+left+", height="+windowH+", width="+windowW);
    	}
        </script>
  </security:authorize>
  </head>
<body>
 <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="http://localhost:8181/ex/index" class="logo"><b>어우름</b></a>
            <!--logo end-->
            
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index#">
                            <i class="fa fa-tasks"></i>
                            <span id="notificationCnt" class="badge bg-theme"></span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green" style="text:bold;">알림</p>
                            </li>
                            <div id="notificationDiv">
	                            <li>	
	                                <a href='content_view?bId=1'>error in index_header.jsp file</a>
	                            </li>
                            </div>
                            
                            <li class="external">
                                <a href="/ex/cReadAllComments?bName=${principal.bNick }" style="color:black;">모든 댓글 읽음처리하기</a>
                            </li>
                            
                        </ul>
                    </li>
                    </security:authorize>
                    <security:authorize access="isAnonymous()">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme"></span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">알림</p>
                            </li>
                            <li>	
                                <a href="login_view">로그인 후 사용하실 수 있습니다.<br>클릭하시면 로그인 창으로 이동합니다 :)</a>
                            </li>
                        </ul>
                    </li>
                    </security:authorize>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                    <a href="http://localhost:8181/ex/note/receivelist">
                            <i class="fa fa-envelope-o"></i>
                            <span id="count" class="badge bg-theme"></span>
                        </a>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
              <security:authorize access="isAnonymous()"><li><a class="login_view" href="login_view">login</a></li></security:authorize>
              <security:authorize access="isAuthenticated()">
             	 <li>
	            	  <a class="login_view" href="<c:url value='logout'/>">logout</a>
	              </li>
	           </security:authorize>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              	  <p class="centered"><a href="profile"><img src="assets/userImage/${principal.bImage}.png" class="img-circle" width="60"></a></p>
              		<security:authorize access="isAuthenticated()">
              		 	<h5 class="centered"><security:authentication property="principal.bNick"/>님 환영합니다</h5>
              		 </security:authorize>
              	 	<security:authorize access="! isAuthenticated()">
              		 	<h5 class="centered">로그인을 해주세요</h5>
              		 </security:authorize>
              	  	
                  <li class="mt">
                      <a class="active" href="index">
                          <i class="fa fa-dashboard"></i>
                          <span>홈</span>
                      </a>
                  </li>
				  <li class="sub-menu">
                      <a  href="/ex/list">
                          <i class="fa fa-cogs"></i>
                          <span>전체글보기</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>스터디</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="/ex/list_Slanguage${bPage.makeQuery(1)}&bMeetingGroup=&bKeyword=&bSearchMType=스터디&bStudyGroup=어학
					&bSearchRType=&bCategory=">어학 스터디</a></li>
                          <li><a  href="/ex/list_Sjob${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bMeetingGroup=스터디&bStudyGroup=취업
					&bSearchRType=&bCategory=">취업 스터디</a></li>
                          <li><a  href="/ex/list_Smajor${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bMeetingGroup=스터디&bStudyGroup=전공
					&bSearchRType=&bCategory=">전공 스터디</a></li>
                          <li><a  href="/ex/list_Setc${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bMeetingGroup=스터디&bStudyGroup=기타
					&bSearchRType=&bCategory=">기타</a></li>
                      </ul>
                  </li>
				  <li class="sub-menu">
                      <a href="/ex/list_club${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bMeetingGroup=동아리&bStudyGroup=
					&bSearchRType=&bCategory=">
                          <i class="fa fa-cogs"></i>
                          <span>동아리</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="/ex/list_contest${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bMeetingGroup=공모전&bStudyGroup=
					&bSearchRType=&bCategory=">
                          <i class="fa fa-cogs"></i>
                          <span>공모전</span>
                      </a>
                  </li>
                 <%--  <li class="sub-menu">
                      <a href="/ex/list${bPage.makeQuery(1)}&bSearchType=&bKeyword=&bSearchMType=&bStudyGroup=
					&bSearchRType=&bCategory=공모전">
                          <i class="fa fa-cogs"></i>
                          <span>모임</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="calendar">동아리</a></li>
                          <li><a  href="gallery">기타1</a></li>
                          <li><a  href="todo_list">기타2</a></li>
                      </ul>
                  </li> --%>
                  <!--  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Extra Pages</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="blank">Blank Page</a></li>
                          <li><a  href="login">Login</a></li>
                          <li><a  href="lock_screen">Lock Screen</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>Forms</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component">Form Components</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Data Tables</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="basic_table">Basic Table</a></li>
                          <li><a  href="responsive_table">Responsive Table</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>Charts</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris">Morris</a></li>
                          <li><a  href="chartjs">Chartjs</a></li>
                      </ul>
                  </li>-->

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      