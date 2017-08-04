<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form role="form" method="post">
	
		<input type="hidden" name="page" value = "${cri.page}">
		<input type="hidden" name="perPageNum" value = "${cri.perPageNum}">
	
		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">UPDATE BOARD</h3>
            </div>
            <!-- /.box-header -->
            <input type="hidden" name="bno" value="${boardVO.bno}">
            <!-- 받아온 데이터 뿌려주는 부분 -->
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">TITLE</label>
                  <input name="title" type="title" class="form-control" value="${boardVO.title}" >
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">CONTENT</label>
                  <textarea name="content" class="form-control" rows="3" >
                  	${boardVO.content}
                  </textarea>
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1 ">WRITER</label>
                  <input name="writer" type="text" class="form-control" value="${boardVO.writer}">
                </div>
        	</div>
        </div>     	
	</form>

			  <!-- 수정, 삭제, 리스트 버튼 
			  		이 버튼의 type이 sumbit이니까 form이 전송된다. 즉, hidden 속성으로 갖고 있던 bno값을 넘겨주게 된다.
			  -->
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">SAVE</button>
                <button type="submit" class="btn btn-danger">CANCLE</button>
              </div>
            
          </div>

<script>

$(function(){
	var formObj = $("form[role='form']");
	
	// 저장
	$(".btn-primary").on("click", function(){
		// <form>에 action을 따로 지정하지 않으면 현재 경로의 uri에서 처리하게된다. 
		// 즉, method로는 post로 해놨으니까 /board/update에 POST방식에 매핑되는 컨트롤러가 처리하게된다.
		formObj.submit();
		
	}); // btn-primary click
	
	// 취소
	$(".btn-danger").on("click", function(event){
		event.preventDefault();
		// 업데이트에서 취소버튼을 누르면 아무런 처리 없이 그냥 원래 보고 있던 목록페이지로 이동하면 되니까 self.location으로 uri만 변경해준다.		
		self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
	});// btn-danger click

}); // $(function(){})



</script>



</body>
</html>
<%@include file="../include/footer.jsp" %>