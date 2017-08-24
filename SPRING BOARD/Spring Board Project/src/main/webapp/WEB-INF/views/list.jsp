<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@include file="include/index_header.jsp" %>

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> 전체 게시판
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
						<div class="content-panel">
							<h4>
								<!-- <i class="fa fa-angle-right"></i> Responsive Table -->
							</h4>
							<select class="type02" name="bCategory" id="selM">
								<!--  	<option selected>분류</option>-->
								<option value="null"
									<c:out value="${bPage.sdto.bCategory == null? 'selected': ''}"/>>분류</option>
								<option value="모집"
									<c:out value="${bPage.sdto.bCategory == '모집'? 'selected': ''}"/>>모집</option>
								<option value="참여"
									<c:out value="${bPage.sdto.bCategory == '참여'? 'selected': ''}"/>>참여</option>
									
							</select> <select class="type02" name="bSearchRType" id="selR">
								<option value="null"
									<c:out value="${bPage.sdto.bSearchRType == null? 'selected': ''}"/>>지역</option>
								<option value="서울"
									<c:out value="${bPage.sdto.bSearchRType == '서울'? 'selected': ''}"/>>서울</option>
								<option value="인천"
									<c:out value="${bPage.sdto.bSearchRType == '인천'? 'selected': ''}"/>>인천</option>
								<option value="안산"
									<c:out value="${bPage.sdto.bSearchRType == '안산'? 'selected': ''}"/>>안산</option>
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
										<c:forEach items="${list}" var="dto">
											<tr class="listToChange">
												<th scope="row" class="text-center">${dto.bId}</th>
												<td><a
													href="/ex/list${bPage.makeQuery(1)}&bSearchType=${bPage.sdto.bSearchType}
													&bKeyword=${bPage.sdto.bKeyword}&bMeetingGroup=${bPage.sdto.bMeetingGroup}
													&bSearchRType=${dto.bRegionGroup}&bCategory=${dto.bCategory}&bStudyGroup="
													style="font-size: 12px; color: gray;">
														${dto.bCategory}/${dto.bRegionGroup}</a>
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
									<nav aria-label="Page navigation">
									<ul class="pagination highlight">
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
										<li class="page-item">
										<a class="page-link" href="/ex/list${bPage.makeSearch(bPage.sdto.bPage-1)}" aria-label="before">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">before</span>
										</a>
										</li>		
										<c:forEach var="idx" begin="${bPage.bStartPage}"
											end="${bPage.endPage}">
											<c:choose>
											<c:when test="${idx == bPage.sdto.bPage}">
											<li class="paginate_button active"><a class="page-link"
												href="/ex/list${bPage.makeSearch(idx)}"> ${idx} </a></li>
											</c:when>
											<c:otherwise>
											<li class="paginate_button page-item"><a class="page-link"
												href="/ex/list${bPage.makeSearch(idx)}"> ${idx} </a></li>
											</c:otherwise>
											</c:choose>
										</c:forEach>
										<li class="page-item">
										<a class="page-link" href="/ex/list${bPage.makeSearch(bPage.sdto.bPage+1)}" aria-label="after">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">after</span>
										</a>
										</li>
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
									</nav>
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
			var bCategory = $("select[name=bCategory]").val();
			var bSearchRType = $("select[name=bSearchRType]").val();
			var bSearchType = $("select[name=bSearchType]").val();
			var bKeyword = $("input[name=bKeyword]").val();

	// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
	// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.

	self.location = "/ex/list${bPage.makeQuery(1)}&bSearchType="
			+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
			+ "" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
			+ "&bStudyGroup=" + "";

});
$('#selR').change(function() {
			var bCategory = $("select[name=bCategory]").val();
			var bSearchRType = $("select[name=bSearchRType]").val();
			var bSearchType = $("select[name=bSearchType]").val();
			var bKeyword = $("input[name=bKeyword]").val();

	// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
	// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.

	self.location = "/ex/list${bPage.makeQuery(1)}&bSearchType="
			+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
			+ "" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
			+ "&bStudyGroup=" + "";

});
	});
		$(function() {

			$('.disabled').on('click', function(event) {
				console.log(event);
				event.preventDefault();
			});
			$('#searchBtn').on("click", function(event) {
								// 검색옵션 값 가져오고
								var bCategory = $("select[name=bCategory]").val();
								var bSearchRType = $("select[name=bSearchRType]").val();
								var bSearchType = $("select[name=bSearchType]").val();
								var bKeyword = $("input[name=bKeyword]").val();
								// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
								// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.
								self.location = "/ex/list${bPage.makeQuery(1)}&bSearchType="
									+ bSearchType + "&bKeyword=" + bKeyword + "&bMeetingGroup="
									+ "" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
									+ "&bStudyGroup=" + "";

							});
		});
	</script>
</body>
</html>
