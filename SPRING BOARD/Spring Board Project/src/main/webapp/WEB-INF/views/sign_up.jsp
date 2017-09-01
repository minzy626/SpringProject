<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/index_header.jsp" %>
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
     <!--main content start-->
      <section id="main-content">
      <section class="wrapper">
			
      	<div class="row">
      	<div class="col-lg-9 main-chart">
                  
        	<div class="col-md-12">
			<div class="page-header">
			<h1>이용약관</h1>
			</div>
	
			
			<div class="mbskin">
    
    <form name="agreement" action="sign_up2" method="POST">
   

	<div class="register-form-wrap text-center">
	<div class="row">
		<div class="col-sm-6">
			<h2>회원가입약관</h2>
			<textarea readonly rows="10" style="resize:none;font-size:20px;width:100%;">어우름은 대학생을 대상으로 각종모임(스터디모임, 공모전모임, 동아리모음)을 위하여 운영되는 사이트입니다. 
			</textarea>
		</div>

		<div class="col-sm-6">
			<h2>개인정보처리방침안내</h2>
			<textarea readonly rows="10" style="resize:none;font-size:20px;width:100%;">다음 개인정보취급방침에 동의하셔야 어우름 사이트 이용이 가능합니다.

1.개인정보의 수집목적 및 이용
 어우름이 회원님 개인의 정보를 수집하는 목적은 어우름사이트를 이용하시는 회원님들이 모임에 가입 혹은 모집할 때 필요한 기본적인 정보들을 제공하기 위한 것입니다. 어우름은 사이트 내의 모든 컨텐츠를 모든 회원들에게 무료로 제공하고 있습니다. 이러한 개인정보를 통한 구분은 콘텐츠, 통계처리 등에 유용한 정보를 선택적으로 제공하는 것이 가능하게 합니다.

2.수집하는 개인정보 항목 및 수집방법
 어우름은 최초 회원가입을 하실 때 정상적인 모임 활동을 위해 가장 필수적이고 최소한의 개인정보를 받고 있습니다. 회원가입 시에 받는 정보는 이메일, 비밀번호, 닉네임, 사는 지역, 재학중인학교, 학년, 전공 등입니다. 이 이외에 특정 상황을 제외하고는 추가적인 정보제공을 요청하고 있지 않습니다. 

3.개인정보의 보유기간 및 폐기
 이용자가 어우름의 회원으로서 어우름이 제공하는 서비스를 받는 동안 회원님의 개인정보는 어우름에서 계속 보유하며 서비스 제공을 위해 이용하게 됩니다. 다만 어우름의 회원이  ID를 삭제하거나 가입해지를 요청한 경우와 회원님께 사전에 알려드린 개인정보를 제공받은 목적이 달성된 경우에 수집된 개인의 정보는 재생할 수 없는 방법에 의하여 하드디스크에서 완전히 삭제되며 어떠한 용도로도 열람 또는 이용할 수 없도록 처리됩니다. 단, 무질서 행위, 불법 행위, 타인에게 피해를 주는 행위 등에 대해서는 재발 방지 및 재가입 방지를 위해 이메일 및 닉네임을 암호화하여 보관하게 됩니다. 이 암호화된 식별값은 복호화가 불가능하며 개인을 특정할 수 없는 값으로 개인정보에 해당하지 않습니다.
			</textarea>
		</div>
	</div>
	</div>
	<br>
	
	<div class="register-form-wrap text-center">
	<div class="row">
	       	<div class="col-sm-6" data-toggle="buttons">
	       		이용수칙에 동의 합니다.
            	<label class="btn btn-warning">
                <input name="agree1" type="checkbox">
                	<span class="fa fa-check"></span>
              	</label>
  			</div>
	       	<div class="col-sm-6" data-toggle="buttons">
	       		개인정보처리방침안내의 내용에 동의합니다.
            	<label class="btn btn-warning">
                <input name="agree2" type="checkbox">
                	<span class="fa fa-check"></span>
              	</label>
  			</div>  			
	</div>
	</div>
	
	<br><br><br>
	
			<div class="form-group">
			<div class="col-sm-12 text-center">
				<button class="btn btn-primary" type="submit" onclick="return checkValue()">다음단계<i class="fa fa-check spaceLeft"></i></button>
            	<button class="btn btn-danger" type="reset" onclick="location.href='index'">가입취소<i class="fa fa-times spaceLeft"></i></button>
			</div>
			</div>	
    </form>

    <script>

    </script>

	</div>				
	</div>
	</div>       
      <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->                  
                 <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
 						<h3>실시간 인기글</h3>
                                        
                      <!-- First Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>2분전</muted><br/>
                      		   <a href="#">노동길</a> 내용<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Second Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>3시간전</muted><br/>
                      		   <a href="#">박채범</a> 내용<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Third Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>11시간전</muted><br/>
                      		   <a href="#">김민지</a> 내용<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fourth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18시간전</muted><br/>
                      		   <a href="#">정태훈</a> 내용<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fifth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18 시간전</muted><br/>
                      		   <a href="#">심재철</a> 완성하는 날까지 화이팅.<br/>
                      		</p>
                      	</div>
                      </div>
                      
                  </div><!-- /col-lg-3 -->
              </div><! --/row -->
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
    
    <!--script for this page-->
    <!-- 미입력 찾기 함수 -->
    <script type="text/javascript">
        function checkValue()
        {
            var form = document.agreement;
        
            if (!form.agree1.checked) {
            	alert("회원가입약관의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
            	form.agree1.focus();
            	return false;
         	}

        	if (!form.agree2.checked) {
            	alert("개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
            	form.agree2.focus();
            	return false;
       		}

        	return true;   
        }
 

  </script>
  

  </body>

</html>