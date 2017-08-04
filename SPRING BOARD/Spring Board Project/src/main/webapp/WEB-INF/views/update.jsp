<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- action="update"로 지정해주지 않은채로 form을 submit()하면 현재 경로의 컨트롤러가 알아서 처리하는 것으로 알고 있었다.
		그래서 딱히 action 속성을 주지 않고 method만 post로 지정한 다음 submit하여 /sboard/update의 post방식 메소드가 처리하도록 했다.
		물론 이 메소드로 요청이 가는건 확인했는데 이상하게 form데이터가 두번 날아가는건지 searchType, keyword만 두번 겹쳐서 파라미터가 수집됐다.
		 page, perPageNum은 문제 없었다. 아무튼 이상황에서 action속성을 주고 update로 명시 한결과 문제는 해결됐다. 왜그런진 모르겠다... 
		 결론은 default로 처리되는것을 믿지말고 명시적으로 처리해주는 습관이 좋을 것 같다.-->
	<form role="form" method="post">
	
		<input type="hidden" name="bPage" value = "${spdto.bPage}">
		<input type="hidden" name="bPerPageNum" value = "${spdto.bPerPageNum}">
		<input type="hidden" name="bSearchType" value = "${spdto.bSearchType}">
		<input type="hidden" name="bKeyword" value = "${spdto.bKeyword}">
		
		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">UPDATE BOARD</h3>
            </div>
            <!-- /.box-header -->
            <input type="hidden" name="bId" value="${BDto.bId}">
            <!-- 받아온 데이터 뿌려주는 부분 -->
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">TITLE</label>
                  <input name="bTitle" type="title" class="form-control" value="${BDto.bTitle}" >
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">CONTENT</label>
                  <textarea name="bContent" class="form-control" rows="3" >
                  	${BDto.bContent}
                  </textarea>
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1 ">WRITER</label>
                  <input name="bName" type="text" class="form-control" value="${BDto.bName}">
                </div>
        	</div>
        </div> <!-- class="box box-primary -->    	
	</form> <!-- role="form" -->

	<!-- 이 버튼의 type이 sumbit이니까 form이 전송된다. 즉, hidden 속성으로 갖고 있던 bno값을 넘겨주게 된다. -->
    <div class="box-footer">
    	<!-- 저장 -->
    	<button class="btn btn-primary">SAVE</button>
        <!-- 취소 -->
        <button class="btn btn-danger">CANCLE</button>
    </div>

<script>

$(function(){
	var formObj = $("form[role='form']");
	
	// 저장 ... 여기서 저장버튼을 누르면 왜 값이 두개 가는거야?
	$(".btn-primary").on("click", function(event){

		// <form>에 action을 따로 지정하지 않으면 현재 경로의 uri에서 처리하게된다. 
		// 즉, method로는 post로 해놨으니까 /sboard/update에 POST방식에 매핑되는 컨트롤러가 처리하게된다.
		
		var page = '${cri.page}';
		var perPageNum = '${cri.perPageNum}';
		var searchType = '${cri.searchType}';
		var keyword = '${cri.keyword}';
		
		console.log("page : " + page);
		console.log("perPageNum : " + perPageNum);
		console.log("searchType : " + searchType);
		console.log("keyword : " + keyword);
		
		alert("pause");
		
		formObj.attr("action", "update");
		formObj.submit();
		
	}); // btn-primary click
	
	// 취소
	$(".btn-danger").on("click", function(event){
		event.preventDefault();
		// 업데이트에서 취소버튼을 누르면 아무런 처리 없이 그냥 원래 보고 있던 목록페이지로 이동하면 되니까 self.location으로 uri만 변경해준다.		
		self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
				+"&searchType=${cri.searchType}&keyword=${cri.keyword}";
	});// btn-danger click

}); // $(function(){})



</script>



</body>
</html>
<%@include file="include/footer.jsp" %>