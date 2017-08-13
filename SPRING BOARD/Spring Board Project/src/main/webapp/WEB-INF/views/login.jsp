<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <title>로그인</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
<script type="text/javascript">
function popupOpen(){

	var popUrl = "find_passView";	//팝업창에 출력될 페이지 URL

	var popOption = "width=460, height=325, resizable=no, scrollbars=no, status=no,menubar=no,resizable=no;";    //팝업창 옵션(optoin)

		window.open(popUrl,"",popOption);

	}
</script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form:form class="form-login" action="login" method="post">
		        <h2 class="form-login-heading">로그인</h2>
		        <div class="login-wrap">
		            <input type="text" name="bId" value="${param.bId}" class="form-control" placeholder="이메일 아이디" >
		            <br>
		            <input type="password" name="bPass" value="${param.bPass}" class="form-control" placeholder="비밀번호">
		            <div style="color:red; margin-top:5px ;margin-left:5px">
		            <c:if test="${param.error == 'true'}">아이디와 비밀번호가 일치하지 않습니다.</c:if>
		            </div>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a href="javascript:popupOpen();"> 비밀번호를 잊어버리셨습니까?</a>
		
		                </span>
		            </label>
		               <script type="text/javascript">
				        function checkValue()
				        {
				            var form = document.userInfo;
				        
				            if(!form.bId.value){
				                alert("아이디를 입력해 주세요.");
				                return false;
				            }
				            
				            if(!form.bPass.value){
				                alert("비밀번호를 입력해 주세요.");
				                return false;
				            }
				         }  

				    </script>

		            <button class="btn btn-theme btn-block" href="index.html" onclick="return checkValue()" type="submit"><i class="fa fa-lock"></i> 로그인</button>
		            <hr>
		            <div class="login-social-link centered">
		            <p>SNS로 로그인 하기</p>
		            		<a id="kakao-login-btn"></a><a href="http://developers.kakao.com/logout"></a>
					<script type='text/javascript'>
					  //<![CDATA[
					    // 사용할 앱의 JavaScript 키를 설정해 주세요.
					    Kakao.init('66eaa05d85d122328c5e0ddf88073992');
					    // 카카오 로그인 버튼을 생성합니다.
					    Kakao.Auth.createLoginButton({
					      container: '#kakao-login-btn',
					      success: function(authObj) {
					        alert(JSON.stringify(authObj));
					      },
					      fail: function(err) {
					         alert(JSON.stringify(err));
					      }
					    });
					  //]]>
					</script>
		            <br/> <br/>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> 페이스북</button>
		            </div>
		            <div class="registration">
		            		               아직 계정이 없으십니까?<br/>
		                <a class="" href="sign_up.html">
		                    	회원가입
		                </a>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          
		                          <h4 class="modal-title">비밀번호를 잊어버리셨습니까 ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>비밀번호를 찾기 위해 아이디와 이메일을 적어주세요.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">취소</button>
		                          <button class="btn btn-theme" type="button">확인</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form:form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
    </script>


  </body>
</html>
