<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<% String context = request.getContextPath(); %>
	<form action="<%=context%>/studentView" method = "post">
		Name : <input type = "text" name = "name"> <br/>
		age : <input type = "age" name = "age"> <br/>
		class : <input type = "classNum" name = "classNum"> <br/>
		grade : <input type = "gradeNum" name = "gradeNum"> <br/>
		<input type = "submit" value = "전송">
	</form>
</body>
</html>