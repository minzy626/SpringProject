<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>이메일 인증</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - FREE Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>

    <script type="text/javascript">
        // 사용하기 클릭 시 부모창으로 값 전달 
       	function pValue(){
            document.getElementById("bId").value = opener.document.userInfo.bId.value;
            document.getElementById("userId").value = opener.document.userInfo.bId.value;
            document.getElementById("dropId").value = opener.document.userInfo.bId.value;
        }
        
        function sendCheckValue(){

            if(!document.number.certNumber.value){
            	alert("인증번호를 입력해 주세요.");
            	return false;
        	}
        	          
        }
   </script>
    
</head>
<body onload="pValue()">

<div class="container">   
    <br>
    <b><font size="4" color="gray">회원탈퇴 본인확인</font></b>
    <hr size="1" width="460">
    <br>
        <form:form  id="checkForm" role="form" commandName = "userDto" action="withdraw_certify" method="post">
            <div class="form-group">
            <div class="col-sm-6 text-center">
            	<div class="input-group">          
            	<input type="text" class="form-control" id="userId" value="${userDto.bId}" placeholder="아이디를 입력해주세요" disabled>
            	<input type="hidden" name="bId" id="bId" value="${userDto.bId}">
            	<span class="input-group-btn">
            		<button class="btn btn-success" type="submit">인증번호 전송</button><!-- onclick="sendCheckValue()" -->
            	</span>
            	</div>
            </div>
            </div> 
            <div class="col-sm-12 text-center">
	            <div style="color:red ; margin-top:2px" >
	            	<form:errors/>
	            </div>
	        </div>
            </form:form>
            <br>
            
            <form:form id="number" role="form" action="withdraw_certify_confirm" method="post">
        	<div class="form-group">
            <div class="col-sm-6 text-center">
            	<div class="input-group">          
            	<input type="text" class="form-control" id="certNumber" name="certNumber" placeholder="인증번호를 입력해주세요">
            	<input type="hidden" name="dropId" id="dropId" value="${userDto.bId}">
            	</div>
            </div>
            </div> 
			<div class="col-sm-12 text-center">
				<button class="btn btn-primary" type="submit" onclick="sendCheckValue()">사용하기</button>
            	<button class="btn btn-danger" type="reset" onclick="window.close()">취소</button>
			</div>
			<div class="col-sm-12 text-center">
	            <div style="color:red ; margin-top:2px" >
	            	<form:errors/>
	            </div>
	        </div>
    		</form:form>
   </div>
</body>
</html>