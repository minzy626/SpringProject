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

<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">READ BOARD</h3>
            </div>
            <!-- /.box-header -->
            
            <!-- 조회화면에서 수정 또는 삭제 버튼을 클릭하면 현재 해당하는 bno값을 필요로 하기 때문에 조회페이지에서 hidden속성으로 가지고 있어야한다. 
            	또한 수정/삭제 후 원래 보고있었던 페이지 번호에 해당하는 목록페이지로 가야하기 때문에 page, perPageNum을 같이 갖고 있어야한다.-->
            <form role="form" method="post">
            	<input type="hidden" name="page" value="${cri.page}">
            	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
            	<input type="hidden" name="bno" value="${boardVO.bno}">
            </form>
            <!-- 받아온 데이터 뿌려주는 부분 -->
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">TITLE</label>
                  <input name="title" type="title" class="form-control" 
                  	value="${boardVO.title}" readonly="readonly">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">CONTENT</label>
                  <textarea name="content" class="form-control"
                  	rows="3" readonly="readonly">
                  	${boardVO.content}
                  </textarea>
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1 ">WRITER</label>
                  <input name="writer" type="text" class="form-control" 
                  	value="${boardVO.writer}" readonly="readonly"">
                </div>   
              </div>
              <!-- /.box-body -->

			  <!-- 수정, 삭제, 리스트 버튼 
			  		이 버튼의 type이 sumbit이니까 form이 전송된다. 즉, hidden 속성으로 갖고 있던 bno값을 넘겨주게 된다.
			  -->
              <div class="box-footer">
                <button type="submit" class="btn btn-warning">UPDATE</button>
                <button type="submit" class="btn btn-danger">DELETE</button>
                <button type="submit" class="btn btn-primary">LIST ALL</button>
              </div>
          </div>
<script>
	// 버튼 클릭 이벤트로 폼 태그에 action 속성을 달아주면 된다. 원하는 곳에..
	$(function(){
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		// 수정
		// 버튼 클릭됐을때 formObj에 action 속성을 /board/modify로 주고,
		// submit()를 사용해서 셀렉터의 submit이벤트를 발생시켜서 form데이터가 전송되도록 해준다.
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/board/update");
			formObj.attr("method", "get");
			formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		});
		
		// 삭제
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/board/delete");
			formObj.attr("method", "post");
			formObj.submit(); // submit()은 submit이벤트를 발생시켜주는 것으로 <form>에만 사용가능하다.
		});
		
		// 리스트 페이지
		$(".btn-primary").on("click", function(){
			// 폼을 선택해서 action을 listPage가 하게 한다.
			formObj.attr("action", "/board/listPage");
			
			// 그리고 method는 조회하는 거니까 get방식으로 한다.
			formObj.attr("method", "get");
			formObj.submit();
			
		});

	});//$(function(){})
</script>
</body>
</html>
<%@include file="../include/footer.jsp" %>