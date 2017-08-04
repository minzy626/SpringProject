<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">

        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">LIST ALL PAGE</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                <tr class="scrollLocation">
                  <th>BNO</th>
                  <th>TITLE</th>
                  <th>WRITER</th>
                  <th>REGDATE</th>
                  <th>VIEWCNT</th>
                </tr>
               
               	<!-- bno, 제목, 작가, 등록일, 조회수 -->
               	<c:forEach items="${listPage}" var="boardVO">
        			<tr class="listToChange">
        				<td class="scrolling" data-bno="${boardVO.bno}">
        					${boardVO.bno}
        				</td>
        				<td>	<!-- /board/readPage?page=4&perPageNum=10&bno=693  -->
        					<a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title}</a>
        				</td>
        				<td>${boardVO.writer}</td>
        				<td>
        					<fmt:formatDate value="${boardVO.regdate}" pattern="yyyy-MM-dd"/>
        				</td>
            			<td>
            				<span class="label label-success">${boardVO.viewcnt}</span>
						</td>
 			
        			</tr> 
				</c:forEach>

               
              </tbody></table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>



<!-- pagination -->

	<div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
		<ul class="pagination">
			<!-- 이전 -->
			<!-- ${pageMaker.prev} == true 이면 class 그대로, false이면 disabled 추가 -->
			<c:choose>
				<c:when test="${pageMaker.prev}">
					<li class="paginate_button previous" id="example1_previous">
						<a href="/board/listPage${pageMaker.makeQuery(pageMaker.startPage-1) }">
							Previous
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="paginate_button previous disabled" id="example1_previous">		
						<a href="/board/listPage${pageMaker.makeQuery(pageMaker.startPage-1) }">
							Previous
						</a>
					</li>
				
				</c:otherwise>
			</c:choose>

			<!-- 페이지 번호 -->
			<!-- forEach써서 ${pageMaker.startPage} 부터 ${pageMaker.endPage} 까지  li태그로 출력-->
			<c:forEach  var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="paginate_button">
					<a href="/board/listPage${pageMaker.makeQuery(idx)}" >
						${idx}
					</a>
				</li>
			</c:forEach>

			<!-- 이후 -->
			<c:choose>
				<c:when test="${pageMaker.next}">
					<li class="paginate_button next" id="example1_next">
						<a href="/board/listPage${pageMaker.makeQuery(pageMaker.endPage+1) }">
							Next
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="paginate_button next disabled" id="example1_next">
						<a href="/board/listPage${pageMaker.makeQuery(pageMaker.endPage+1) }">						
							Next
						</a>	
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>


<script>

$(function(){
	
	/* <a> 태그에 class로 disalbed를 추가한다고해서 클릭 이벤트가 막히진 않았다. 그냥 불가라는 아이콘 표시만 될뿐,
		따라서 이렇게 따로 event.preventDefault()하여 click이벤트를 막아주어야 했다. */
	$('.disabled').on('click', function(event){
		console.log("여기 들어옴");
		console.log(event);
		event.preventDefault();
	});
	

	var msg = '${msg}';

	if (msg == 'SUCCESS'){
		console.log("여기 들어옴!!!");
		alert("삭제 성공");
		
	}// if()
});//$(function(){})
	
	
	

</script>

</body>
</html>
<%@include file="../include/footer.jsp" %>
