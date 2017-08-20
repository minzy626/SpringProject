<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>DASHGUM - Bootstrap Admin Template</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link href="assets/css/table-responsive.css" rel="stylesheet">
<link href="assets/list_css/comboBox.css" rel="stylesheet">
<link href="assets/list_css/search.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="index.html#"> <i
							class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
					</a>
						<ul class="dropdown-menu extended tasks-bar">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 4 pending tasks</p>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">DashGum Admin Panel</div>
										<div class="percent">40%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Database Update</div>
										<div class="percent">60%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Product Development</div>
										<div class="percent">80%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
											style="width: 80%">
											<span class="sr-only">80% Complete</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Payments Sent</div>
										<div class="percent">70%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="70" aria-valuemin="0"
											aria-valuemax="100" style="width: 70%">
											<span class="sr-only">70% Complete (Important)</span>
										</div>
									</div>
							</a></li>
							<li class="external"><a href="#">See All Tasks</a></li>
						</ul></li>
					<!-- settings end -->
					<!-- inbox dropdown start-->
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 5 new messages</p>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-zac.jpg"></span> <span
									class="subject"> <span class="from">Zac Snider</span> <span
										class="time">Just now</span>
								</span> <span class="message"> Hi mate, how is everything? </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-divya.jpg"></span> <span
									class="subject"> <span class="from">Divya Manian</span>
										<span class="time">40 mins.</span>
								</span> <span class="message"> Hi, I need your help with this. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-danro.jpg"></span> <span
									class="subject"> <span class="from">Dan Rogers</span> <span
										class="time">2 hrs.</span>
								</span> <span class="message"> Love your new Dashboard. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-sherman.jpg"></span> <span
									class="subject"> <span class="from">Dj Sherman</span> <span
										class="time">4 hrs.</span>
								</span> <span class="message"> Please, answer asap. </span>
							</a></li>
							<li><a href="index.html#">See all messages</a></li>
						</ul></li>
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
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">
						<a href="profile.html"><img src="assets/img/ui-sam.jpg"
							class="img-circle" width="60"></a>
					</p>
					<h5 class="centered">Marcel Newman</h5>

					<li class="mt"><a href="index.html"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>UI Elements</span>
					</a>
						<ul class="sub">
							<li><a href="general.html">General</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="panels.html">Panels</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Components</span>
					</a>
						<ul class="sub">
							<li><a href="calendar.html">Calendar</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="todo_list.html">Todo List</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Extra Pages</span>
					</a>
						<ul class="sub">
							<li><a href="blank.html">Blank Page</a></li>
							<li><a href="login.html">Login</a></li>
							<li><a href="lock_screen.html">Lock Screen</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>Forms</span>
					</a>
						<ul class="sub">
							<li><a href="form_component.html">Form Components</a></li>
						</ul></li>
					<li class="sub-menu"><a class="active" href="javascript:;">
							<i class="fa fa-th"></i> <span>Data Tables</span>
					</a>
						<ul class="sub">
							<li><a href="basic_table.html">Basic Table</a></li>
							<li class="active"><a href="responsive_table.html">Responsive
									Table</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-bar-chart-o"></i> <span>Charts</span>
					</a>
						<ul class="sub">
							<li><a href="morris.html">Morris</a></li>
							<li><a href="chartjs.html">Chartjs</a></li>
						</ul></li>

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
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> 공모전 게시판
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
						<div class="content-panel">
							<h4>
								<!-- 							<i class="fa fa-angle-right"></i> Responsive Table -->
							</h4>
							<select class="type02" name="bSearchMType" id="selM">
								<!--  	<option selected>분류</option>-->
								<option value="null"
									<c:out value="${bPage.sdto.bCategory == null? 'selected': ''}"/>>분류</option>
								<option value="club" id="searchMClub"
									<c:out value="${bPage.sdto.bCategory == 'club'? 'selected': ''}"/>>동아리</option>
								<option value="study"
									<c:out value="${bPage.sdto.bCategory == 'study'? 'selected': ''}"/>>스터디</option>
								<option value="meeting"
									<c:out value="${bPage.sdto.bCategory == 'meeting'? 'selected': ''}"/>>미팅</option>
							</select> <select class="type02" name="bSearchRType" id="selR">
								<option value="null"
									<c:out value="${bPage.sdto.bSearchRType == null? 'selected': ''}"/>>지역</option>
								<option value="seoul"
									<c:out value="${bPage.sdto.bSearchRType == 'seoul'? 'selected': ''}"/>>서울</option>
								<option value="incheon"
									<c:out value="${bPage.sdto.bSearchRType == 'incheon'? 'selected': ''}"/>>인천</option>
								<option value="ansan"
									<c:out value="${bPage.sdto.bSearchRType == 'ansan'? 'selected': ''}"/>>안산</option>
							</select>
							<section id="unseen">
								<table
									class="table table-bordered table-striped table-condensed">
									<thead>
										<tr>
											<th scope="col" class="text-center">번호</th>
											<th scope="col" class="text-center">제목</th>
											<th scope="col" class="text-center">작성자</th>
											<th scope="col" class="text-center">날짜</th>
											<th scope="col" class="text-center">조회수</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${listNotice}" var="dto">
											<tr class="listToChange info">
												<th scope="row" class="text-center">${dto.bNotice}</th>
												<td><a
													href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
												<td align="center">${dto.bName}</td>
												<td align="center"><fmt:formatDate value="${dto.bDate}"
														pattern="yyyy-MM-dd" /></td>
												<td align="center">${dto.bHit}</td>
											</tr>
									</c:forEach>
										<c:forEach items="${list_contest}" var="dto">
											<tr class="listToChange">
												<th scope="row" class="text-center">${dto.bId}</th>
												<td><a
													href="list?bMeetingGroup=${dto.bMeetingGroup}&bRegionGroup=${dto.bRegionGroup}"
													style="font-size: 12px; color: gray;">
														${dto.bMeetingGroup}/${dto.bRegionGroup}</a>
													&nbsp;&nbsp;|&nbsp; &nbsp; <a
													href="/ex/content_view${bPage.makeSearch(bPage.sdto.bPage)}&bId=${dto.bId}" OnClick="">${dto.bTitle}</a></td>
												<td align="center">${dto.bName}</td>
												<td align="center"><fmt:formatDate value="${dto.bDate}"
														pattern="yyyy-MM-dd" /></td>
												<td align="center">${dto.bHit}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<hr />
								<h4></h4>

								<!-- <div id="wrapper">
									<div id="sel"> -->
								<!-- 	<div class="row"> -->
								<table class="type01">
									<!-- 	<div > -->
									<tr>
										<td><select name="bSearchType"
											class="form-control input-sm">
												<option value="n"
													<c:out value="${bPage.sdto.bSearchType == null? 'selected' : ''}" />>---</option>
												<option value="t"
													<c:out value="${bPage.sdto.bSearchType == 't'? 'selected' : ''}" />>제목</option>
												<option value="c"
													<c:out value="${bPage.sdto.bSearchType == 'c'? 'selected' : ''}" />>내용</option>
												<option value="w"
													<c:out value="${bPage.sdto.bSearchType == 'w'? 'selected' : ''}" />>작성자</option>
										</select></td>
										<!-- 									</div>
 -->
										<!-- <div class="col-xs-6"> -->
										<td width="250px"><input type="text" name="bKeyword"
											class="form-control" value="${bPage.sdto.bKeyword}"
											placeholder="검색 키워드를 입력하세요!"></td>
										<!-- 									</div>
 -->
										<!-- 	<div> -->
										<td><span class="input-group-btn">
												<button class="btn btn-secondary" id="searchBtn"
													type="submit">찾기</button>
										</span></td>
										<!-- </div> -->
										<td class="right">
										<a href="/ex/write_view${bPage.makeSearch(bPage.sdto.bPage)}" class="btn btn-default">글작성</a>
										</td>
									</tr>
								</table>
								<!-- </div> -->
								<%-- <a href="/ex/write_view${bPage.makeSearch(bPage.sdto.bPage)}" class="btn btn-default pull-right">글작성</a> --%>

								<div class="dataTables_paginate paging_simple_numbers text-center"
									id="example1_paginate">
									<ul class="pagination">
										<!-- 이전 -->
										<!-- ${pageMaker.prev} == true 이면 class 그대로, false이면 disabled 추가 -->
										<c:choose>
											<c:when test="${bPage.prev}">
												<li class="paginate_button previous" id="example1_previous">
													<a href="/ex/list${bPage.makeSearch(bPage.bStartPage-1)}">
														Previous </a>
												</li>
											</c:when>
											<c:otherwise>
												<li class="paginate_button previous disabled"
													id="example1_previous"><a
													href="/ex/list${bPage.makeSearch(bPage.bStartPage-1) }">
														Previous </a></li>

											</c:otherwise>
										</c:choose>

										<!-- 페이지 번호 -->
										<!-- forEach써서 ${pageMaker.startPage} 부터 ${pageMaker.endPage} 까지  li태그로 출력-->
										<c:forEach var="idx" begin="${bPage.bStartPage}"
											end="${bPage.endPage}">
											<li class="paginate_button"><a
												href="/ex/list${bPage.makeSearch(idx)}"> ${idx} </a></li>
										</c:forEach>

										<!-- 이후 -->
										<c:choose>
											<c:when test="${bPage.next}">
												<li class="paginate_button next" id="example1_next"><a
													href="/ex/list${bPage.makeSearch(bPage.endPage+1)}">
														Next </a></li>
											</c:when>
											<c:otherwise>
												<li class="paginate_button next disabled" id="example1_next">
													<a href="/ex/list${bPage.makeSearch(bPage.endPage+1)}">
														Next </a>
												</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</section>
						</div>
						<!-- /content-panel -->
					</div>
					<!-- /col-lg-4 -->
				</div>
				<!-- /row -->

			</section>
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				2014 - Alvarez.is <a href="responsive_table.html#" class="go-top">
					<i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>

	<!--script for this page-->
		<script>
	$(document).ready(function() {
		$('#selM').change(function() {
			
			var bSearchRType = $("select[name=bSearchRType]").val();
			var bSearchType = $("select[name=bSearchType]").val();
			var bKeyword = $("input[name=bKeyword]").val();

	// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
	// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.

	self.location = "/ex/list_contest${bPage.makeQuery(1)}&bSearchType="
			+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
			+ "공모전" + "&bSearchRType=" + bSearchRType;

});
$('#selR').change(function() {
			
			var bSearchRType = $("select[name=bSearchRType]").val();
			var bSearchType = $("select[name=bSearchType]").val();
			var bKeyword = $("input[name=bKeyword]").val();

	// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
	// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.

	self.location = "/ex/list_contest${bPage.makeQuery(1)}&bSearchType="
			+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
			+ "공모전" + "&bSearchRType=" + bSearchRType;

});
	});
		$(function() {

			$('.disabled').on('click', function(event) {
				console.log(event);
				event.preventDefault();
			});
			
			
			
			$('#searchBtn').on("click", function(event) {

								// 검색옵션 값 가져오고
								var bSearchRType = $("select[name=bSearchRType]").val();
								var bSearchType = $("select[name=bSearchType]")
										.val();
								var bKeyword = $("input[name=bKeyword]").val();

								// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
								// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.
								self.location = "/ex/list_contest${bPage.makeQuery(1)}&bSearchType="
										+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
										+ "공모전" + "&bSearchRType=" + bSearchRType;

							});
		});
	</script>
</body>
</html>
