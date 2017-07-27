<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
   		 <link href="assets/css/bootstrap.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/memberinfo.css" type="text/css">
		<script type = "text/javascript" src="${pageContext.request.contextPath}/assets/js/memberinfo.js"></script>
    </head>
    <body>
    <div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
       <br>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">심재님의 프로필 정보</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Picture" src="${pageContext.request.contextPath}/assets/rion.png" class="img-circle img-responsive"> </div>
                
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
                        <td>닉네임:</td>
                        <td>심재</td>
                      </tr>
                      <tr>
                        <td>가입일:</td>
                        <td>06/23/2013</td>
                      </tr>
                      <tr>
                        <td>학교:</td>
                        <td>홍익대학교</td>
                      </tr>
                   
                         <tr>
                             <tr>
                      </tr>
                        <tr>
                        <td>학년:</td>
                        <td>3</td>
                      </tr>
                      <tr>
                        <td>전공:</td>
                        <td>컴퓨터공학</td>
                           
                      </tr>
                      <tr>
                        <td>이메일 주소:</td>
                        <td><a href="mailto:info@support.com">simsimjae@naver.com</a></td>
                      </tr>
                      
                     
                    </tbody>
                  </table>
                  
                 <!--   <a href="#" class="btn btn-primary">My Sales Performance</a>
                  <a href="#" class="btn btn-primary">Team Sales Performance</a>-->
                  
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>
    </body>    
</html>