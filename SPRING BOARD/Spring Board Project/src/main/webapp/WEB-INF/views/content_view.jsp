<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>       
<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%@include file="include/index_header.jsp" %>
<script type="text/javascript">
function popupopen(string){
	 var encode = encodeURI(encodeURIComponent(string));
	 var winWidth = 350;
	 var winHeight = 405;
	 var winName = "회원 정보 보기";
	 var winURL = "/ex/memberinfo?nickname="+encode;
	 var winPosLeft = (screen.width - winWidth) / 2;
	 var winPosTop = (screen.height - winHeight) / 2;
	 var winOpt = "width="+winWidth+",height="+winHeight+",top="+winPosTop+",left="+winPosLeft;
	 window.open(winURL, winName, winOpt + ",menubar=no,status=no,scrollbars=no,resizable=no");
}
</script>
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
      <!-- <link rel="stylesheet" href="assets/css/write.css"/>  -->
		<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
		<div class="container">	
			
			<article class="form-horizontal">
			  <div class="form-group">
			  <div class="col-md-8">
				<h1>글 작성하기 </h1>
			  </div>	
			  </div>
			  
				
			  
				
			  <form id="pageInfo" role="form">
            	<input type="hidden" name="bPage" value="${spdto.bPage}">
            	<input type="hidden" name="bPerPageNum" value="${spdto.bPerPageNum}">
            	<input type="hidden" name="bSearchType" value="${spdto.bSearchType}">
            	<input type="hidden" name="bKeyword" value="${spdto.bKeyword}">
			    <input type="hidden" id="bId" name="bId" value="${BDto.bId}">
              </form>
				
			  <div>
			    <div class="col-md-12">
			   	 <h2 style="color:#2F4F4F">${BDto.bTitle}</h2>
			    </div>
			  
			  
			  
			  <div class="col-md-12 ">
			    <p>
				    <a href="#"><span class="label label-info">${BDto.bMeetingGroup}</span></a> <!-- 클릭 시 공모전 게시판 해당 변수+페이지링크 필요 -->
					<a href="#"><span class="label label-info">${BDto.bCategory}</span></a> <!-- 클릭 시 공모전-질문답변 글 필터링해서 보여줘(굳이..?) -->
					<a href="#"><span class="label label-info">${BDto.bRegionGroup}</span></a>
					| <i class="glyphicon glyphicon-user"></i> <a href="" onclick="popupopen('${BDto.bName}');"> ${BDto.bName }</a> <!-- 클릭 시 멤버정보 팝업창 -->
					| <i class="glyphicon glyphicon-calendar">${BDto.bDate}</i>  
				   	| <i class="glyphicon glyphicon-eye-open">${BDto.bHit}회</i>
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
	            		<c:when test="${equal == 'true'}">
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
			<div class="row">
			<div class="comments-container">
			<ul id="comments-list" class="comments-list">
			<c:forEach items="${commentList }" var="dto">
			  <li>
				<div class="comment-main-level">
					<!-- 프로필 이미지 -->
					<div class="comment-avatar"><a href="profile"><img src="assets/userImage/${dto.cImage}.png" class="img-circle" width="60"></a></div>
					<!-- 댓글 내용 -->
					<div class="comment-box">
						<div class="comment-head">
							<c:set var="commentWriter">${dto.cNick }</c:set>
							<h6 class="comment-name by-author"><a href="" onClick="popupopen();">${dto.cNick}</a></h6>
							<span>${dto.cDate}</span>
							<c:if test="${connectedUser== commentWriter}">
								<a href="/ex/cDelete?cId=${dto.cId }&cBoardNum=${BDto.bId}"><i class="glyphicon glyphicon-trash"></i></a>
								<a onclick="modifyComment('${dto.cId}','${dto.cContent }'); return false;"><i class="glyphicon glyphicon-pencil"></i></a>
							</c:if>
							
						</div>
						<div class="comment-content">
							${dto.cContent }
						</div>
					</div>
				</div>
			  </li>
			</c:forEach>
			</ul>
			</div>
			</div>
			<!-- 
			<c:forEach items="${commentList }" var="dto">
	            <c:set var="commentWriter">${dto.cNick }</c:set>
				<div class="col-md-12" style="padding-left:50px; padding-right:50px; padding-bottom:15px;">
			  	<div>
			  	  <p>
			  	  	<i class="glyphicon glyphicon-user"></i> <a href="/ex/memberinfo"> ${dto.cNick}</a>  클릭 시 멤버정보 팝업창 
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
			</c:forEach> -->
			
			<!-- 댓글 작성 부분(로그인여부에 따라 활/비활성화) -->
			<!-- ****************************************************************************************************************************** -->
			<!-- ****************************************************************************************************************************** -->
			<!-- ****************************************************************************************************************************** -->
			
			<div class="col-md-12" style="padding-left:50px; padding-right:50px; padding-bottom:15px; padding-top:30px; ">
			  	<div style="border:1px solid; background-color:#F5FFFF; width:900px; height:280px;">
			  	  <div style="padding-top:10px;"><p id="cType" class="text-center"><strong style="font-size:20px;">댓글 작성</strong></p>
			  	  <security:authorize access="isAuthenticated()">
			  	  <form id="commentForm" name="commentForm" action="cWrite" role="form" method="post">
			  	  	<input type="hidden" name="cNick" value="<security:authentication property="principal.bNick"/>">
			  	  	<input type="hidden" name="cBoardNum" value="${BDto.bId }">
			  	  	<input type="hidden" name="cImage" value="<security:authentication property="principal.bImage"/>">
			  	  	<input type="hidden" id="cId" name="cId" value="0">
			  	  	<div id="modifyIdInput"></div>
			  	  	<div class="centered" style="padding-right:50px; padding-left:50px; padding-top:10px;">
			  			<textarea class="form-control" id="cContent" name="cContent" rows="3" style="width:800px; height:150px; overflow:auto;" placeholder="댓글 내용"></textarea>
			  	 	 </div>
			  	 	 <div class="centered" id="cButton" style="padding-top:15px; padding-right:50px; padding-left:50px;">
			  	 	   <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok">등록하기</span></button>
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
  	
  	
	// 버튼 클릭 이벤트로 폼 태그에 action 속성을 달아주면 된다. 원하는 곳에..
	$(function(){
		
		// 댓글 수정버튼
		//var cForm=document.forms['commentForm'];
		//var cForm = $("form[id='commentForm']");
		//$(".btn-primary").on("click", function(){
		//	cForm.elements["cContent"].value=document.getElementById('cContent').value;
		//	cForm.attr("action","/ex/cUpdate");
		//	cForm.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		//});
		var formObj = $("#pageInfo");
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
	
	//댓글의 수정버튼을 누르면 호출
	function modifyComment(id, comment)
  	{
  		document.getElementById('cId').value=id;
  		document.getElementById('cContent').value=comment;
  		document.getElementById('cType').innerHTML='<strong style="font-size:20px;">댓글 내용수정</strong>';
  		//document.getElementById('cButton').innerHTML='<button type="submit"  class="btn btn-success"><span class="glyphicon glyphicon-floppy-disk">수정하기</span></button>';
  		document.getElementById('cButton').innerHTML='<button class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk">수정하기</span></button>';
  		//document.getElementById('modifyIdInput').innerHTML='<input type="hidden" name="cId" value="'+id+'">';
  		document.getElementById('commentForm').action = '/ex/cUpdate';
  		window.scrollTo(0,document.body.scrollHeight);
  	}
</script>

  </body>
</html>