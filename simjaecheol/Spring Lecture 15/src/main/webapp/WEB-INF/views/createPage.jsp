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
<form action="<%=conPath%>/student/create"> <!-- contextpath�� ���� �����ָ� 2���̻� ����� �տ� /student/�� ��� �߰� �Ǽ� ������.  -->
	�̸� : <input type="text" name="name" value="${student.name}" ><br/>
	���̵� : <input type="text" name="id" value="${student.id}" ><br/>
	<input type="submit" name="����" >
</form>
</body>
</html>