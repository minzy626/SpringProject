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
					<i class="fa fa-angle-right"></i> 취업 스터디 게시판
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
						<div class="content-panel">
							<h4>
								<!-- 							<i class="fa fa-angle-right"></i> Responsive Table -->
							</h4>
							<select class="type02" name="bCategory" id="selM">
								<!--  	<option selected>분류</option>-->
								<option value="null"
									<c:out value="${bPage.sdto.bCategory == null? 'selected': ''}"/>>분류</option>
								<option value="모집"
									<c:out value="${bPage.sdto.bCategory == '모집'? 'selected': ''}"/>>모집</option>
								<option value="참여"
									<c:out value="${bPage.sdto.bCategory == '참여'? 'selected': ''}"/>>참여</option>
								<option value="질문"
									<c:out value="${bPage.sdto.bCategory == '질문'? 'selected': ''}"/>>질문</option>
								
							</select> <select class="type02" name="bSearchRType" id="selR">
								<option value="null"
									<c:out value="${bPage.sdto.bSearchRType == null? 'selected': ''}"/>>지역</option>
								<option value="서울특별시"
									<c:out value="${bPage.sdto.bSearchRType == '서울특별시'? 'selected': ''}"/>>서울특별시</option>
								<option value="부산광역시"
									<c:out value="${bPage.sdto.bSearchRType == '부산광역시'? 'selected': ''}"/>>부산광역시</option>
								<option value="대구광역시"
									<c:out value="${bPage.sdto.bSearchRType == '대구광역시'? 'selected': ''}"/>>대구광역시</option>
								<option value="인천광역시"
									<c:out value="${bPage.sdto.bSearchRType == '인천광역시'? 'selected': ''}"/>>인천광역시</option>
								<option value="광주광역시"
									<c:out value="${bPage.sdto.bSearchRType == '광주광역시'? 'selected': ''}"/>>광주광역시</option>	
								<option value="대전광역시"
									<c:out value="${bPage.sdto.bSearchRType == '대전광역시'? 'selected': ''}"/>>대전광역시</option>	
								<option value="울산광역시"
									<c:out value="${bPage.sdto.bSearchRType == '울산광역시'? 'selected': ''}"/>>울산광역시</option>	
								<option value="세종특별자치시"
									<c:out value="${bPage.sdto.bSearchRType == '세종특별자치시'? 'selected': ''}"/>>세종특별자치시</option>
								<option value="경기도"
									<c:out value="${bPage.sdto.bSearchRType == '경기도'? 'selected': ''}"/>>경기도</option>
								<option value="강원도"
									<c:out value="${bPage.sdto.bSearchRType == '강원도'? 'selected': ''}"/>>강원도</option>
								<option value="충청북도"
									<c:out value="${bPage.sdto.bSearchRType == '충청북도'? 'selected': ''}"/>>충청북도</option>
								<option value="충청남도"
									<c:out value="${bPage.sdto.bSearchRType == '충청남도'? 'selected': ''}"/>>충청남도</option>
								<option value="전라북도"
									<c:out value="${bPage.sdto.bSearchRType == '전라북도'? 'selected': ''}"/>>전라북도</option>		
								<option value="전라남도"
									<c:out value="${bPage.sdto.bSearchRType == '전라남도'? 'selected': ''}"/>>전라남도</option>	
								<option value="경상북도"
									<c:out value="${bPage.sdto.bSearchRType == '경상북도'? 'selected': ''}"/>>경상북도</option>	
								<option value="경상남도"
									<c:out value="${bPage.sdto.bSearchRType == '경상남도'? 'selected': ''}"/>>경상남도</option>	
								<option value="제주특별자치도"
									<c:out value="${bPage.sdto.bSearchRType == '제주특별자치도'? 'selected': ''}"/>>제주특별자치도</option>	
									
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
										<c:forEach items="${list_Sjob}" var="dto">
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

								<div >
										<select name="bSearchType" class=" input-sm">
												<option value="n"
													<c:out value="${bPage.sdto.bSearchType == null? 'selected' : ''}" />>---</option>
												<option value="t"
													<c:out value="${bPage.sdto.bSearchType == 't'? 'selected' : ''}" />>제목</option>
												<option value="c"
													<c:out value="${bPage.sdto.bSearchType == 'c'? 'selected' : ''}" />>내용</option>
												<option value="w"
													<c:out value="${bPage.sdto.bSearchType == 'w'? 'selected' : ''}" />>작성자</option>
										</select>
									
										<input type="text" name="bKeyword" class="noh"
										 value="${bPage.sdto.bKeyword}"
											placeholder="검색 키워드를 입력하세요!">
										<span class="input-btn">
												<button class="btn btn-secondary" id="searchBtn"
													type="submit">찾기</button>
										</span>
									
										<a href="/ex/write_view${bPage.makeSearch(bPage.sdto.bPage)}" class="btn btn-default pull-right">글작성</a>
								
								 </div>
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
			+ "스터디" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
			+ "&bStudyGroup=" + "취업";

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
			+ "스터디" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
			+ "&bStudyGroup=" + "취업";

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
									+ "스터디" + "&bSearchRType=" + bSearchRType + "&bCategory=" + bCategory
									+ "&bStudyGroup=" + "취업";

							});
		});
	</script>
</body>
</html>
