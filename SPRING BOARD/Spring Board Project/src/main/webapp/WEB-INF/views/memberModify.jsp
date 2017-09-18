<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@include file="include/index_header.jsp" %>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
       	<security:authentication var="principal" property="principal"/>
		<section id="main-content">
		<section class="wrapper">
			<div class="row">
			<div class="col-lg-9 main-chart">
			
			<div class="col-md-12">
			<div class="page-header">
			<h1>회원정보 수정</h1>
			</div>
			<form:form class="form-horizontal" action="user_modify_confirm" method="POST" name="userInfo" commandName = "userDto" >
					
			<!-- 아이디 입력 -->
			
			<div class="form-group">
			<label class="col-sm-3 control-label">아이디</label>
			<div class="row">
			<div class="col-sm-6">
				<input type="text" class="form-control" name="bId" id="bId" value="${principal.bId}" readonly/>
			</div>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-sm-3 control-label">현재 비밀번호</label>
			<div class="row">
			<div class="col-sm-6">
				<input class="form-control" name="bCurrentPass" type="password" placeholder="비밀번호">
				<p class="help-block">현재 비밀번호를 입력하세요</p>
			</div>
			</div>
			</div>
					
			<!-- 새 비밀번호 입력 -->
			<div class="form-group">
			<label class="col-sm-3 control-label">새 비밀번호</label>
			<div class="row">
			<div class="col-sm-6">
				<input class="form-control" name="bPass" type="password" placeholder="비밀번호">
				<p class="help-block">비밀번호를 변경하시려면 입력하세요(숫자, 영어 포함 8자 이상)</p>
			</div>
			</div>
			</div>
					
			<!-- 새 비밀번호 입력 확인-->
			<div class="form-group">
			<label class="col-sm-3 control-label">새 비밀번호 확인</label>
			<div class="row">
			<div class="col-sm-6">
				<input class="form-control" name="bPassCheck" type="password" placeholder="비밀번호 확인">
				<p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
			</div>
			</div>
			</div>     
			 
			<!-- 닉네임 입력-->    
			<div class="form-group">
            <label class="col-sm-3 control-label">닉네임</label>
			<div class="row">
			<div class="col-sm-6">
				<input class="form-control" name="bNick" type="text" value="${principal.bNick}" disabled>
			</div>
			</div>
			</div>
			
			<!-- 지역 입력--> 
			<div class="form-group">
			<label class="col-sm-3 control-label">지역</label>
			<div class="row">
			<div class="col-sm-6">
				<select class="form-control" name="bRegion" id="bRegion">
    				<option value="">시/도 선택</option>
    				<option value="서울특별시">서울특별시</option>
   					<option value="부산광역시">부산광역시</option>
    				<option value="대구광역시">대구광역시</option>
    				<option value="인천광역시">인천광역시</option>
    				<option value="광주광역시">광주광역시</option>
   					<option value="대전광역시">대전광역시</option>
    				<option value="울산광역시">울산광역시</option>
    				<option value="세종특별자치시">세종특별자치시</option>
    				<option value="경기도">경기도</option>
   					<option value="강원도">강원도</option>
    				<option value="충청북도">충청북도</option>
    				<option value="충청남도">충청남도</option>
    				<option value="전라북도">전라북도</option>
   					<option value="전라남도">전라남도</option>
    				<option value="경상북도">경상북도</option>
    				<option value="경상남도">경상남도</option>
    				<option value="제주특별자치도">제주특별자치도</option>
				</select>
			</div>
			</div>
			</div>
			
			<!-- 성별 입력 -->
			<div class="form-group">
			<label class="col-sm-3 control-label">성별</label>
			<div class="row">
			<div class="col-sm-2">
				<select class="form-control" name="bGender" id="bGender" disabled>
					<option value="">성별 선택</option>
    				<option value="남">남</option>
   					<option value="여">여</option>
				</select>
			</div>
			</div>
			</div>
			
			<!-- 학교 입력--> 
			<div class="form-group">
            <label class="col-sm-3 control-label">학교</label>
            <div class="row">
				<div class="col-sm-3">
             	<input class="form-control" name="bSchool" type="text" value="${principal.bSchool}" placeholder="학교 이름">
          		</div>
				<div class="col-sm-2">
   				<select class="form-control" name="bGrade" id="bGrade">
					<option value="">학년 선택</option>
    				<option value="1">1학년</option>
   					<option value="2">2학년</option>
    				<option value="3">3학년</option>
    				<option value="4">4학년</option>
    				<option value="5">5학년이상</option>
				</select>
          		</div>
          	</div>
			</div>
			
			<!-- 전공 입력-->    
			<div class="form-group">
            <label class="col-sm-3 control-label">전공</label>
			<div class="row">
			<div class="col-sm-6">
				<input class="form-control" name="bMajor" type="text" placeholder="전공" value="${principal.bMajor}">
			</div>
			</div>
			</div>
        	
			<!-- 이미지 선택 --> 
			<div class="form-group">
			<label class="col-sm-3 control-label">프로필 이미지</label>
			<div class="row">
			<div class="col-sm-3">
				<select class="form-control" name="bImage" id="bImage">
					<option value="">프로필 이미지 선택</option>
    				<option value="bulldog" data-image="assets/userImage/bulldog.png">개</option>
					<option value="cat" data-image="assets/userImage/cat.png">고양이</option>
					<option value="chicken" data-image="assets/userImage/chicken.png">닭</option>
					<option value="clown-fish" data-image="assets/userImage/clown-fish.png">물고기</option>
					<option value="duck" data-image="assets/userImage/duck.png">오리</option>
					<option value="elephant" data-image="assets/userImage/elephant.png">코끼리</option>
					<option value="fox" data-image="assets/userImage/fox.png">여우</option>
					<option value="frog" data-image="assets/userImage/frog.png">개구리</option>
					<option value="lion" data-image="assets/userImage/lion.png">사자</option>
					<option value="monkey" data-image="assets/userImage/monkey.png">원숭이</option>
					<option value="mouse" data-image="assets/userImage/mouse.png">쥐</option>
					<option value="panda" data-image="assets/userImage/panda.png">판다</option>
					<option value="penguin" data-image="assets/userImage/penguin.png">펭귄</option>
					<option value="pig" data-image="assets/userImage/pig.png">돼지</option>
					<option value="rabbit" data-image="assets/userImage/rabbit.png">토끼</option>
					<option value="racoon" data-image="assets/userImage/racoon.png">라쿤</option>
					<option value="sheep" data-image="assets/userImage/sheep.png">양</option>
					<option value="siberian-husky" data-image="assets/userImage/siberian-husky.png">허스키</option>
					<option value="squirrel" data-image="assets/userImage/squirrel.png">다람쥐</option>
					<option value="tiger" data-image="assets/userImage/tiger.png">호랑이</option>					
					<option value="bat" data-image="assets/userImage/bat.png">박쥐</option>
					<option value="beaver" data-image="assets/userImage/beaver.png">비버</option>
					<option value="bee" data-image="assets/userImage/bee.png">벌</option>
					<option value="beetle" data-image="assets/userImage/beetle.png">딱정벌레</option>
					<option value="camel" data-image="assets/userImage/camel.png">낙타</option>
					<option value="canary" data-image="assets/userImage/canary.png">카나리아</option>
					<option value="chameleon" data-image="assets/userImage/chameleon.png">카멜레온</option>
					<option value="cobra" data-image="assets/userImage/cobra.png">코브라</option>
					<option value="cow" data-image="assets/userImage/cow.png">소</option>
					<option value="crab" data-image="assets/userImage/crab.png">게</option>
					<option value="crocodile" data-image="assets/userImage/crocodile.png">악어</option>
					<option value="giraffe" data-image="assets/userImage/giraffe.png">기린</option>
					<option value="hippopotamus" data-image="assets/userImage/hippopotamus.png">하마</option>
					<option value="hummingbird" data-image="assets/userImage/hummingbird.png">벌새</option>
					<option value="kangaroo" data-image="assets/userImage/kangaroo.png">캥거루</option>
					<option value="llama" data-image="assets/userImage/llama.png">라마</option>
					<option value="macaw" data-image="assets/userImage/macaw.png">마코 앵무새</option>
					<option value="moose" data-image="assets/userImage/moose.png">무스</option>
					<option value="octopus" data-image="assets/userImage/octopus.png">문어</option>
					<option value="ostrich" data-image="assets/userImage/ostrich.png">타조</option>
					<option value="owl" data-image="assets/userImage/owl.png">올빼미</option>
					<option value="pelican" data-image="assets/userImage/pelican.png">펠리컨</option>
					<option value="rhinoceros" data-image="assets/userImage/rhinoceros.png">코뿔소</option>
					<option value="shark" data-image="assets/userImage/shark.png">상어</option>
					<option value="sloth" data-image="assets/userImage/sloth.png">나무늘보</option>
					<option value="snake" data-image="assets/userImage/snake.png">뱀</option>
					<option value="swan" data-image="assets/userImage/swan.png">백조</option>
					<option value="toucan" data-image="assets/userImage/toucan.png">투우칸</option>
					<option value="turtle" data-image="assets/userImage/turtle.png">거북이</option>
					<option value="whale" data-image="assets/userImage/whale.png">고래</option>
				</select>
			</div>
			</div>
			</div>        	
        	
			<div class="col-sm-12 text-center">
	        <div style="color:red ; margin-top:2px" >
	            <form:errors/>
	        </div>
	        </div>
          
			<div class="form-group">
			<div class="col-sm-12 text-center">
				<button class="btn btn-primary" type="submit" onclick="return checkValue()">회원수정<i class="fa fa-check spaceLeft"></i></button>
				<button class="btn btn-warning" type="button" onclick="MemberWithdraw()">회원탈퇴<i class="fa fa-times spaceLeft"></i></button>
            	<button class="btn btn-danger" type="reset" onclick="location.href='index'">취소</button>
			</div>
			</div>
			</form:form>
			<hr>
			</div>
      
			</div>
      <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->                  
                 <div class="col-lg-3 ds">
                  <!--COMPLETED ACTIONS DONUTS CHART-->
                          <thead>
										<tr>
											<th scope="col" class="text-center"><h3>공지사항</h3></th>
										</tr>
						</thead>              
                      <!-- First Action -->
                      <div class="desc">
                  
                      	
                    		  <tbody>
									<c:forEach items="${listNotice}" var="dto">
									<div class="thumb">
					                   	<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
					                      	</div>
											<tr class="details">
												<th scope="row" class="text-center">${dto.bNotice}</th>
												<td><a
													href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
											</tr>
									</c:forEach>
									</tbody>
                      		 
                             </div>
                                           	
                      </div>
     
                  </div>
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end--> 
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="assets/js/msdropdown/jquery.dd.min.js" type="text/javascript"></script> 
  	<link rel="stylesheet" type="text/css" href="assets/css/msdropdown/dd.css" />
  	
    <!--script for this page-->

    <script type="text/javascript">
    $(document).ready(function() {
        $("#bRegion").val("${principal.bRegion}");
        $("#bGender").val("${principal.bGender}");
        $("#bGrade").val("${principal.bGrade}");
        $("#bImage").val("${principal.bImage}");
		try {
			$("#bImage").msDropDown();
			} catch(e) {
			alert(e.message);
			}
        // you need to specify id of combo to set right combo, if more than one combo
    });    
        function checkValue()
        {
            var form = document.userInfo;
            
            if(!form.bCurrentPass.value){
                alert("현재비밀번호를 입력해 주세요.");
                return false;
            }
            
            if(form.bPass.value.length < 8 && form.bPass.value.length > 0){
                alert("새 비밀번호를 8자 이상으로 입력해 주세요.");
                return false;
            }
            
            if(form.bPass.value != form.bPassCheck.value ){
                alert("새 비밀번호를 동일하게 입력해 주세요.");
                return false;
            }    
           
            if(form.bRegion.value == ""){
                alert("지역을 선택해 주세요.");
                return false;
            }

            
            if(!form.bSchool.value){
                alert("학교를 입력해 주세요.");
                return false;
            }
            
            if(form.bGrade.value == ""){
                alert("학년을 선택해 주세요");
                return false;
            }
            
            if(form.bImage.value == ""){
                alert("프로필 이미지를 선택해 주세요");
                return false;
            }
            
            if(!form.bMajor.value){
                alert("전공을 입력해 주세요.");
                return false;
            }
            
        }
        function MemberWithdraw(){
        	
        	window.name = "parentForm";
            window.open("withdrawForm",
                    "chkForm", "width=500, height=300, resizable = no, scrollbars = no");    
        }
  </script>
  

  </body>

</html>