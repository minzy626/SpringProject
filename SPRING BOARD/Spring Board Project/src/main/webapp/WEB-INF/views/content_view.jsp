<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>       
<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            <a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
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
              
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">Marcel Newman</h5>
              	  	
                  <li class="mt">
                      <a href="index.html">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>UI Elements</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="general.html">General</a></li>
                          <li><a  href="buttons.html">Buttons</a></li>
                          <li><a  href="panels.html">Panels</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Components</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="calendar.html">Calendar</a></li>
                          <li><a  href="gallery.html">Gallery</a></li>
                          <li><a  href="todo_list.html">Todo List</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Extra Pages</span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a  href="blank.html">Blank Page</a></li>
                          <li><a  href="login.html">Login</a></li>
                          <li><a  href="lock_screen.html">Lock Screen</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>Forms</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component.html">Form Components</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Data Tables</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>Charts</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
      <link rel="stylesheet" href="assets/css/write.css"/>
		<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
		<div class="container">	
			
			<article class="form-horizontal">
			  <div class="form-group">
			  <div class="col-md-8">
				<h1>글 작성하기 </h1>
			  </div>	
			  </div>
			  
				
			  <h2>신촌지역 스터디/공모전/미팅 게시판 - 글 보기 페이지</h2>
				
			  <form role="form" method="post">
            	<input type="hidden" name="bPage" value="${spdto.bPage}">
            	<input type="hidden" name="bPerPageNum" value="${spdto.bPerPageNum}">
            	<input type="hidden" name="bSearchType" value="${spdto.bSearchType}">
            	<input type="hidden" name="bKeyword" value="${spdto.bKeyword}">
            	<input type="hidden" name="bId" value="${BDto.bId}">
              </form>
				
			  <div>
			    <div class="col-md-12">
			   	 <h2 style="color:#2F4F4F">${BDto.bTitle}</h2>
			    </div>
			  
			  
			  
			  <div class="col-md-12 ">
			    <p>
				    <a href="#"><span class="label label-info">공모전</span></a> <!-- 클릭 시 공모전 게시판 해당 변수+페이지링크 필요 -->
					<a href="#"><span class="label label-info">질문/답변</span></a> <!-- 클릭 시 공모전-질문답변 글 필터링해서 보여줘(굳이..?) -->
					| <i class="glyphicon glyphicon-user"></i> <a href="/ex/memberinfo"> 홍길동</a> <!-- 클릭 시 멤버정보 팝업창 -->
					| <i class="glyphicon glyphicon-calendar">${BDto.bDate}</i>  
				 	| <i class="glyphicon glyphicon-comment"></i> <a href="#"> 댓글 0</a> <!-- 클릭 시 댓글 부분으로 스크롤 다운(필요시..) -->
				   	| <i class="glyphicon glyphicon-eye-open">${BDto.bHit }회</i>
				</p>
			  </div>
			  
			 <!-- 글 박스 크기 고정에 스크롤바 사용하려면div style-> height:350px, overflow:auto 로 설정 -->
			  <div class="col-md-12">
			  	<div style="border:2px solid; background-color:#F5FFFF; width:1000px; min-height:350px; height:auto;">
			  	  <div style="padding:10px;">
			  		${BDto.bContent}
			  	  </div>
			  	</div>
			  </div>
			  
	          <div class="col-sm-10 text-center" style="padding: 10px;">
	            <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-th-list"></span> 목록으로</button>	
	            <!-- bDto.bNick==security:authentication property="principal.bNick 이라면... -->
	            
	            <security:authorize access="isAuthenticated()">
	            	<c:set var="connectedUser"><security:authentication property="principal.bNick" /></c:set>
	            	<c:set var="contentWriter">${BDto.bName }</c:set>
	            	<c:choose>
	            		<c:when test="${connectedUser == contentWriter}">
		          			<button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span> 글 수정</button>
		          			<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> 글 삭제</button>
	          			</c:when>
	          			<c:otherwise>
		          			<button type="submit" class="btn btn-warning" disabled="disabled"><span class="glyphicon glyphicon-pencil"></span> 글 수정</button>
		          			<button type="submit" class="btn btn-danger" disabled="disabled"><span class="glyphicon glyphicon-trash"></span> 글 삭제</button>
	          			</c:otherwise>
	          		</c:choose>
	          	</security:authorize>
	          	<security:authorize access="!isAuthenticated()">
	            	<button type="submit" class="btn btn-warning" disabled="disabled"><span class="glyphicon glyphicon-pencil"></span> 글 수정</button>
		          	<button type="submit" class="btn btn-danger" disabled="disabled"><span class="glyphicon glyphicon-trash"></span> 글 삭제</button>
	            </security:authorize>
	          </div>
	          </div>
			</article>
		</div>
		<!-- 댓글 part -->
		<!-- *****************************댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글************************* -->
		<div class="container">
			<div class="col-md-12" style="padding-bottom:35px; padding-top:70px;">
			  	<div style="border-bottom: 1px solid #c9aa5f; background-color:#ffd777; width:1000px; height:40px;">
			  	  <div style="padding:10px;">
			  		댓글 목록
			  	  </div>
			  	</div>
			</div>
			
			<c:forEach items="${commentList }" var="dto">
	            <c:set var="commentWriter">${dto.cNick }</c:set>
				<div class="col-md-12" style="padding-left:50px; padding-right:50px; padding-bottom:15px;">
			  	<div>
			  	  <p>
			  	  	<i class="glyphicon glyphicon-user"></i> <a href="/ex/memberinfo"> ${dto.cNick}</a> <!-- 클릭 시 멤버정보 팝업창 -->
					| <i class="glyphicon glyphicon-calendar">${dto.cDate}</i>
					<c:if test="${connectedUser== commentWriter}">
					| <a onclick="modifyComment('${dto.cId}','${dto.cContent }'); return false;">수정</a>
					| <a href="/ex/cDelete?cId=${dto.cId }&cBoardNum=${BDto.bId}">삭제</a>
					</c:if>
			  	  </p>
			  	</div>
			  	<div style="border:1px solid; background-color:#F5FFFF; width:900px; min-height:80px; height:auto;">
			  	  <div style="padding:10px;">
			  		${dto.cContent}
			  	  </div>
			  	</div>
				</div>
			</c:forEach>
			
			<!-- 댓글 작성 부분(로그인여부에 따라 활/비활성화) -->
			<!-- ****************************************************************************************************************************** -->
			<!-- ****************************************************************************************************************************** -->
			<!-- ****************************************************************************************************************************** -->
			
			<div class="col-md-12" style="padding-left:50px; padding-right:50px; padding-bottom:15px; padding-top:30px; ">
			  	<div style="border:1px solid; background-color:#F5FFFF; width:900px; height:280px;">
			  	  <div style="padding-top:10px;"><p id="cType" class="text-center"><strong style="font-size:20px;">댓글 작성</strong></p>
			  	  <security:authorize access="isAuthenticated()">
			  	  <form name="commentForm" action="cWrite" role="form" method="post">
			  	  	<input type="hidden" name="cNick" value="<security:authentication property="principal.bNick"/>">
			  	  	<input type="hidden" name="cBoardNum" value="${BDto.bId }">
			  	  	<div id="modifyIdInput"></div>
			  	  	<div class="centered" style="padding-right:50px; padding-left:50px; padding-top:10px;">
			  			<textarea class="form-control" id="cContent" name="cContent" rows="3" style="width:800px; height:150px; overflow:auto;" placeholder="댓글 내용"></textarea>
			  	 	 </div>
			  	 	 <div class="centered" id="cButton" style="padding-top:15px; padding-right:50px; padding-left:50px;">
			  	 	 <button type="submit"  class="btn btn-success"><span class="glyphicon glyphicon-ok">등록하기</span></button>
			  	  	</div>
				  </form>
			  	  </security:authorize>
			  	  <security:authorize access="!isAuthenticated()">
              	  	  <div class="centered" style="padding-right:50px; padding-left:50px; padding-top:10px;">
				  		<textarea class="form-control" rows="3" style="width:800px; height:150px; overflow:auto;" readonly>댓글은 로그인 후 작성하실 수 있습니다.</textarea>
				  	  </div>
				  	  <div class="centered" style="padding-top:15px; padding-right:50px; padding-left:50px;">
				  	  <button type="submit" class="btn btn-success" disabled="disabled"><span class="glyphicon glyphicon-ok">등록하기</span></button>
				  	  </div>
            	  </security:authorize>
			  	</div>
			</div>
		</div>
		
		<!-- 댓글 작성 부분 div 끝!!!! -->
		<!-- ****************************************************************************************************************************** -->
		<!-- ****************************************************************************************************************************** -->
		<!-- ****************************************************************************************************************************** -->
		
		</div>
      </section><!-- /MAIN CONTENT -->
		
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer" style="margin-top:50px;">
          <div class="text-center">
              2017 - Spring Board Project
              <a href="/ex/index" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
   
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
  	<script>
  	function modifyComment(id, comment)
  	{
  		document.getElementById('cContent').value=comment;
  		document.getElementById('cType').innerHTML='<strong style="font-size:20px;">댓글 내용수정</strong>';
  		//document.getElementById('cButton').innerHTML='<button type="submit"  class="btn btn-success"><span class="glyphicon glyphicon-floppy-disk">수정하기</span></button>';
  		document.getElementById('cButton').innerHTML='<a href="/ex/cUpdate?cContent=${dto.cContent}" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk">수정하기</span></a>';
  		//document.getElementById('modifyIdInput').innerHTML='<input type="hidden" name="cId" value="'+id+'">';
  		
  	}
  	
	// 버튼 클릭 이벤트로 폼 태그에 action 속성을 달아주면 된다. 원하는 곳에..
	$(function(){
		
		
		
		// 댓글 수정버튼
		
		// 댓글 삭제버튼
		
		var formObj = $("form[role='form']");
		// 리스트 페이지
		$(".btn-info").on("click", function(){
			formObj.attr("action", "/ex/list");
			formObj.attr("method", "get");
			formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		});
		
		// 수정
		// 버튼 클릭됐을때 formObj에 action 속성을 /board/update로 주고,
		// submit()를 사용해서 셀렉터의 submit이벤트를 발생시켜서 form데이터가 전송되도록 해준다.
		$(".btn-warning").on("click", function(){
			if(confirm("게시물을 수정하시겠습니까?")){
				// 폼을 선택해서 action을 list가 하게 한다.
				formObj.attr("action", "/ex/modify_view");
				// 그리고 method는 조회하는 거니까 get방식으로 한다.
				formObj.attr("method", "get");
				formObj.submit();	
			}
		});
		// 삭제
		$(".btn-danger").on("click", function(){
			if(confirm("게시물을 삭제하시겠습니까?\n취소 할 수 없습니다!!")){
				formObj.attr("action", "/ex/delete");
				formObj.attr("method", "post");
				formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
			}
		});

	});//$(function(){})
</script>

  </body>
</html>