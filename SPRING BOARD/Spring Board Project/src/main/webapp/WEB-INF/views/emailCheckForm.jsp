<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>이메일 인증</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    
</head>
<body onload="pValue()">

<div class="container">   
<div class="row mt">
<div class="col-lg-9 main-chart">
    <b><font size="4" color="gray">아이디 중복체크</font></b>
    <hr size="1" width="95%">
    <br>
        <form:form class="form-horizontal" id="checkForm" role="form" commandName = "userDto" action="email_certify" method="post">
            <div class="form-group">
            <div class="col-sm-6 text-center">
            	<div class="input-group">          
            	<input type="text" class="form-control" id="bId" name="bId" value="${userDto.bId}" placeholder="아이디를 입력해주세요" readonly>
            	<span class="input-group-btn">
            		<button class="btn btn-success" type="submit">인증번호 전송</button>
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
            
            <form:form class="form-horizontal" id="number" name="number" role="form" action="email_certify_confirm" method="post">
        	<div class="form-group">
            <div class="col-sm-6 text-center">
            	<div class="input-group">          
            	<input type="text" class="form-control" id="certNumber" name="certNumber" placeholder="인증번호 입력">
            	</div>
            </div>
            </div> 
            <br>
			<div class="col-sm-12 text-center">
				<button class="btn btn-primary" type="submit" onclick="sendCheckValue()">사용하기</button>
            	<button class="btn btn-danger" type="reset" onclick="cancel()">취소</button>
			</div>
			<div class="col-sm-12 text-center">
	            <div style="color:red ; margin-top:2px" >
	            	<form:errors/>
	            </div>
	        </div>
    		</form:form>
    		
   </div>
   </div> 		
   </div>
   
   <script type="text/javascript">
        // 사용하기 클릭 시 부모창으로 값 전달 
       	function pValue(){
            document.getElementById("bId").value = opener.document.userInfo.bId.value;
        }
        
        function sendCheckValue(){

            if(!document.number.certNumber.value){
            	alert("인증번호를 입력해 주세요.");
            	return false;
        	}
            
            opener.document.userInfo.idCheck.value = "idCheck";
        }
        
        function cancel(){
            
            opener.document.userInfo.idCheck.value = "idUnCheck";
            window.close();
        }
   </script>
</body>
</html>