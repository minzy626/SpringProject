<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/index_header.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="쪽지함">
		<style>
			.content{
				position:relative;
				left:17%;
				top:60px;
			}	
		</style>
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
		<link href="assets/css/note.css" rel="stylesheet" />
		  <script src="assets/js/jquery.js"></script>
	    <script src="assets/js/jquery-1.8.3.min.js"></script>
	    <script src="assets/js/bootstrap.min.js"></script>
	    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	    <script src="assets/js/jquery.scrollTo.min.js"></script>
	    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	    <script src="assets/js/jquery.sparkline.js"></script>
		<script src="assets/js/note.js"></script>
	
	</head>

<body style="background-color:#FFFFFF">
<div class="container">
	<div class="row">

		<section class="content">
			
			<div class="col-md-8 col-md-offset-1">
				<div>
					<div class="panel-body" style=" padding-right: 30px; padding-left: 30px;">
					<h1>보낸 쪽지함</h1>
						<div class="pull-right">
							<div class="btn-group" style="margin-bottom:20px;">
								<button type="button" class="btn btn-success btn-filter" onclick="location.href='receivelist'">받은 쪽지함</button>
								<button type="button" class="btn btn-warning btn-filter" onclick="popupOpen()">쪽지 보내기</button>
								<button type="button" class="btn btn-danger btn-filter" onclick="location.href='send_delete_all'">전체 삭제</button>
								
							</div>
						</div>
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
									<c:forEach var="notedto" items="${list}">
										<tr data-status="pagado">
											
											<td style="width:30px;">
												<a href="javascript:;" class="star">
													<i class="glyphicon glyphicon-star"></i>
												</a>
											</td>
											<td>
												<div class="media">
													<a href="" class="pull-left">
														<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
													</a>
														<div class="media-body">
															<c:if test="${notedto.confirm==1}">
																<span class="media-meta pull-right">읽은 시간<br/>${notedto.checktime}</span>
															</c:if>
																<h4 class="title">				
																		${notedto.receiver}
																		<c:if test="${notedto.confirm == 0}">
																			<span class="pull-right pagado">(읽지않음)</span>
																		</c:if>
																		<c:if test="${notedto.confirm == 1}">
																			<span class="pull-right cancelado">(읽음)</span>
																		</c:if>
																	
																</h4>
																<a href="content_view2?Id=${notedto.id}"><p class="summary">${notedto.content}</p></a>
															
														</div>
													
												</div>
											</td>
										</tr>
										
									</c:forEach>
									
									
						
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="content-footer">
					<p>
					</p>
				</div>
			</div>
		</section>
		
	</div>
</div>
</body>
</html>