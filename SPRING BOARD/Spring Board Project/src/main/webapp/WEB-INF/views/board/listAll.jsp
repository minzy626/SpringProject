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
               	<c:forEach items="${list}" var="boardVO">
        			<tr class="listToChange">
        				<td class="scrolling" data-bno="${boardVO.bno}">
        					${boardVO.bno}
        				</td>
        				<td>
        					<a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a>
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

<script>

	

</script>

</body>
</html>
<%@include file="../include/footer.jsp" %>
