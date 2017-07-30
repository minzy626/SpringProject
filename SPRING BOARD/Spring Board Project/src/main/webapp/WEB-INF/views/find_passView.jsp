<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="passwordreset" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">비밀번호 찾기</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#">아이디 찾기</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form:form id="signupform" class="form-horizontal" role="form" commandName = "userDto" action="find_pass" method="post">
                          		  <div class="form-group">
                                    <label for="email" class="col-md-2 control-label">아이디</label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" name="bId" value="${userDto.bId}"placeholder="아이디를 입력해주세요">
                                    </div>
                                   	    <div class="col-md-offset-2 col-md-10">
	                                    	<div style="color:red ; margin-top:2px" >
	                                     		<form:errors path="bId"/>
	                                    	</div>
	                                    </div>
                                	</div>
                                <div class="form-group">
                                    <label for="email" class="col-md-2 control-label">이메일</label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" name="bEmail" value="${userDto.bEmail}"placeholder="이메일을 작성해주세요">
                                    </div>
                                    
	                                    <div class="col-md-offset-2 col-md-10">
	                                    	<div style="color:red ; margin-top:2px" >
	                                     		<form:errors path="bEmail"/>
	                                    	</div>
	                                    </div>                 
                                    
                                </div>
                                    
                                <div class="form-group" style="margin-right:1%">
                                    <!-- Button -->
                                                  
                                    <div class="col-md-offset-10 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-warning">확인</button>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            	가입하신 이메일로 아이디와 비밀번호를 전송해드리겠습니다.
                                        </div>
                                    </div>
                                </div>    
                                
                            </form:form>
                         </div>
                    </div>
         </div> 
    </div>

</body>
</html>