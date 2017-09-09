<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@page import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%@include file="include/index_header.jsp" %> 
    <script language = "javascript"> 
    
    function modifyCheck() { 
    	var form = document.writeform; 
    	if( !form.bTitle.value ) { 
    		alert( "제목을 입력해주세요" ); 
    		form.bTitle.focus(); 
    		return false;
    	} 
    	if( !form.bContent.value ) {
    		alert( "내용을 입력해주세요" ); 
    		form.bContent.focus(); 
    		return false;
    	}
    	alert( "게시물의 내용이 성공적으로 수정되었습니다!" ); 
    	form.submit();
    }
    function submitContents() {
        // 에디터의 내용이 textarea에 적용된다.
        oEditors.getById["bContent"].exec("UPDATE_CONTENTS_FIELD", []);
     	alert("javascript:submitContents()");
        // 에디터의 내용에 대한 값 검증은 이곳에서
        // document.getElementById("ir1").value를 이용해서 처리한다.
    }
    </script>
    
    

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
      <!-- invalid link....필요없는듯? <link rel="stylesheet" href="assets/css/write.css"/>  -->
		<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
		<div class="container">	
		
		<form role="form" name="pageInfo" method="post">
            	<input type="hidden" name="bPage" value="${spdto.bPage}">
            	<input type="hidden" name="bPerPageNum" value="${spdto.bPerPageNum}">
            	<input type="hidden" name="bSearchType" value="${spdto.bSearchType}">
            	<input type="hidden" name="bKeyword" value="${spdto.bKeyword}">
            	<input type="hidden" name="bId" value="${BDto.bId}">
        </form>
	
				
		<form class="form-horizontal" name="writeform" action="update" role="form" id="writeform" method="post">
		  <div class="form-group">
		  <div class="col-md-8">
			<h1>' </h1>
		  </div>	
		  </div>
			
			<legend>게시글 수정하기</legend>
			
			<input type=hidden name="bId" value="${BDto.bId }">
			<input type="hidden" name="bHit" id="bHit" value="${BDto.bHit }">
		  	
	 
	 	  <div class="form-group">
		    <label for="bTitle" class="col-md-1 control-label">제 목</label>
		    <div class="col-md-9">
		      <input type="text" class="form-control" name="bTitle" id="bTitle" value="${BDto.bTitle}">
		    </div>
		  </div>
		 
 		  

		  
		  <div class="form-group">
		  <label for="bContent" class="col-md-1 control-label">내 용</label>
		  	<div class="col-md-9">
		  	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
				<textarea class="form-control textarea" name="bContent" id="bContent" rows="15" cols="100">
		${BDto.bContent}
					</textarea>
				</div>
				
				<script type="text/javascript">
					var oEditors = [];
					nhn.husky.EZCreator.createInIFrame({
				    oAppRef: oEditors,
				    elPlaceHolder: "bContent",
				    sSkinURI: "se2/SmartEditor2Skin.html",
				    fCreator: "createSEditor2"
					});
				</script>
		  </div>
		  
		  <div class="form-group">
          <div class="col-sm-12 text-center">
          	<button type="submit" id="specificBtn" class="btn btn-info"  OnClick="javascript:submitContents(); javascript:modifyCheck(); return false;"><span class="glyphicon glyphicon-ok-sign"></span> 수정 완료</button>
          	<button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span>취소</button>
          </div>
          </div>
		</form>
	</div>
	
      </section><!-- /MAIN CONTENT -->
		
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
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
    $(function(){
		
		var formObj = $('form[name="pageInfo"]');
		var submitFormObj= $('form[name="writeform"]');
		$(".btn-warning").on("click", function(event){
			if(confirm("작성을 취소하고 목록으로 돌아갑니다.")){
				formObj.attr("action", "/ex/list");
				formObj.attr("method", "get");
				formObj.submit(); 
				return false;
			}
		});
		
	});
    </script>
  	

  </body>
</html>