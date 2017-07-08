<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String conPath = request.getContextPath();
%>
<form action="<%=conPath%>/student/create"> <!-- contextpath를 설정 안해주면 2번이상 제출시 앞에 /student/가 계속 추가 되서 오류남.  -->
	이름 : <input type="text" name="name" value="${student.name}" ><br/>
	아이디 : <input type="text" name="id" value="${student.id}" ><br/>
	<input type="submit" name="전송" >
</form>
</body>
</html>