<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
    <head>
   		 <link href="assets/css/bootstrap.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/memberinfo.css" type="text/css">
		<script type = "text/javascript" src="${pageContext.request.contextPath}/assets/js/memberinfo.js"></script>
		<script type="text/javascript">
			function popupopen(string){
				 var encode = encodeURI(encodeURIComponent(string));
				 var winWidth = 450;
				 var winHeight = 405;
				 var winName = "쪽지 보내기";
				 var winURL = "/ex/note/write_view?nickname="+encode;
				 var winPosLeft = (screen.width - winWidth) / 2;
				 var winPosTop = (screen.height - winHeight) / 2;
				 var winOpt = "width="+winWidth+",height="+winHeight+",top="+winPosTop+",left="+winPosLeft;
				 window.open(winURL, winName, winOpt + ",menubar=no,status=no,scrollbars=no,resizable=no");
			}
		</script>
    </head>
    <body>
    <div class="container">
      <div class="row">
      
        <div >
   
   
          <div class="panel panel-info" style="margin:0px 0px; height:402px;">
            <div class="panel-heading">
              <h3 class="panel-title">${dto.bNick}님의 프로필 정보</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img src="assets/userImage/${dto.bImage}.png" class="img-circle img-responsive" style="width:80px; height:80px"> </div>
                
                <!--<div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <br>
                  <dl>
                    <dt>DEPARTMENT:</dt>
                    <dd>Administrator</dd>
                    <dt>HIRE DATE</dt>
                    <dd>11/12/2013</dd>
                    <dt>DATE OF BIRTH</dt>
                       <dd>11/12/2013</dd>
                    <dt>GENDER</dt>
                    <dd>Male</dd>
                  </dl>
                </div>-->
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>이메일:</td>
                        <td>${dto.bId}</td>
                      </tr>                 
                      <tr>
                        <td>학교:</td>
                        <td>${dto.bSchool}</td>
                      </tr>
                   
                         <tr>
                             <tr>
                      </tr>
                        <tr>
                        <td>학년:</td>
                        <td>${dto.bGrade}</td>
                      </tr>
                      <tr>
                        <td>전공:</td>
                        <td>${dto.bMajor}</td>
                           
                      </tr>
                      <tr>
                        <td>성별:</td>
                        <td>${dto.bGender}</a></td>
                      </tr>
                      
                     
                    </tbody>
                  </table>
                  
                 <!--   <a href="#" class="btn btn-primary">My Sales Performance</a>
                  <a href="#" class="btn btn-primary">Team Sales Performance</a>-->
                  
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                 <span class="pull-right">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary" 
                        	onclick="self.close(); popupopen('${dto.bNick}');"><i class="glyphicon glyphicon-envelope"></i></a>
                           <a data-original-title="Remove this user" data-toggle="tooltip"  type="button" class="btn btn-sm btn-danger" onClick="self.close();"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>
    </body>    
</html>