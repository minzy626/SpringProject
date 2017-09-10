<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page session="true" %>
<%@include file="include/index_header.jsp" %>
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
 <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
			
              <div class="row">
                  <div class="col-lg-9 main-chart">                 
                  	
					<div class="row mt">
                      <!--CUSTOM CHART START -->
                    <!--   <div class="border-head">
                          <h3>게시판</h3>
                          <a href="memberinfo">회원정보보기</a>
                          <a href="sign_up">회원가입하기</a>
                          <a href="find_passView">비밀번호 찾기</a>
                          <a href="memberModify">회원정보 수정</a>
                      </div>-->
                      <div class="row content">
                      <div class="col-lg-3" style="margin-left:50px;">
                      <table class="table table-bordered table-striped table-condensed">
									<thead style="background-color:#68dff0;color:ffffff;">
										<tr>
									<th  scope="col" class="text-center"><i class="fa fa-chevron-right"></i><a href="list_club">동아리</a></th>
										</tr>
									</thead>
									
									<tbody>
									<c:forEach items="${list_club}" var="dto">
											<tr class="listToChange info">
											<td><a
													href="/ex/list_club${bPage.makeQuery(1)}&bSearchType=${bPage.sdto.bSearchType}
													&bKeyword=${bPage.sdto.bKeyword}&bMeetingGroup=${bPage.sdto.bMeetingGroup}
													&bSearchRType=${dto.bRegionGroup}&bCategory=${dto.bCategory}&bStudyGroup="
													style="font-size: 12px; color: gray;">
														${dto.bCategory}/${dto.bRegionGroup}</a>
													&nbsp;&nbsp;|&nbsp; &nbsp; <a
													href="/ex/content_view${bPage.makeSearch(bPage.sdto.bPage)}&bId=${dto.bId}" OnClick="">${dto.bTitle}</a></td>
											</tr>
									</c:forEach>
									</tbody>
								</table> 
                      </div>
                      <div class="col-lg-3" style="margin-left:20px;">
                      <table class="table table-bordered table-striped table-condensed">
									<thead style="background-color:#68dff0 ;color:ffffff;">
										<tr>
											<th scope="col" class="text-center"><i class="fa fa-chevron-right"></i><a href="list_contest">공모전</a></th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${list_contest}" var="dto">
											<tr class="listToChange info">
											<td><a
													href="/ex/list_club${bPage.makeQuery(1)}&bSearchType=${bPage.sdto.bSearchType}
													&bKeyword=${bPage.sdto.bKeyword}&bMeetingGroup=${bPage.sdto.bMeetingGroup}
													&bSearchRType=${dto.bRegionGroup}&bCategory=${dto.bCategory}&bStudyGroup="
													style="font-size: 12px; color: gray;">
														${dto.bCategory}/${dto.bRegionGroup}</a>
													&nbsp;&nbsp;|&nbsp; &nbsp; <a
													href="/ex/content_view${bPage.makeSearch(bPage.sdto.bPage)}&bId=${dto.bId}" OnClick="">${dto.bTitle}</a></td>
											</tr>
									</c:forEach>
									</tbody>
								</table> 	
                      </div>
                      <div class="col-lg-3" style="margin-left:20px;">
                      <table class="table table-bordered table-striped table-condensed">
									<thead style="background-color:#68dff0;color:ffffff;">
										<tr>
									<th  scope="col" class="text-center"><i class="fa fa-chevron-right"></i><a href="list_Slanguage">스터디</a></th>
										</tr> 
									</thead>
									<tbody>
									<c:forEach items="${list_Slanguage}" var="dto">
											<tr class="listToChange info">
																								<td><a
													href="/ex/list_club${bPage.makeQuery(1)}&bSearchType=${bPage.sdto.bSearchType}
													&bKeyword=${bPage.sdto.bKeyword}&bMeetingGroup=${bPage.sdto.bMeetingGroup}
													&bSearchRType=${dto.bRegionGroup}&bCategory=${dto.bCategory}&bStudyGroup="
													style="font-size: 12px; color: gray;">
														${dto.bCategory}/${dto.bRegionGroup}</a>
													&nbsp;&nbsp;|&nbsp; &nbsp; <a
													href="/ex/content_view${bPage.makeSearch(bPage.sdto.bPage)}&bId=${dto.bId}" OnClick="">${dto.bTitle}</a></td>
											</tr>
									</c:forEach>
									</tbody>
								</table> 
                      </div>
                      </div>
                     <!--  <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>10.000</span></li>
                              <li><span>8.000</span></li>
                              <li><span>6.000</span></li>
                              <li><span>4.000</span></li>
                              <li><span>2.000</span></li>
                              <li><span>0</span></li>
                          </ul>
                          <div class="bar">
                              <div class="title">JAN</div>
                              <div class="value tooltips" data-original-title="8.500" data-toggle="tooltip" data-placement="top">85%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">FEB</div>
                              <div class="value tooltips" data-original-title="5.000" data-toggle="tooltip" data-placement="top">50%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">MAR</div>
                              <div class="value tooltips" data-original-title="6.000" data-toggle="tooltip" data-placement="top">60%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">APR</div>
                              <div class="value tooltips" data-original-title="4.500" data-toggle="tooltip" data-placement="top">45%</div>
                          </div>
                          <div class="bar">
                              <div class="title">MAY</div>
                              <div class="value tooltips" data-original-title="3.200" data-toggle="tooltip" data-placement="top">32%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">JUN</div>
                              <div class="value tooltips" data-original-title="6.200" data-toggle="tooltip" data-placement="top">62%</div>
                          </div>
                          <div class="bar">
                              <div class="title">JUL</div>
                              <div class="value tooltips" data-original-title="7.500" data-toggle="tooltip" data-placement="top">75%</div>
                          </div>
                      </div> -->
                      <!--custom chart end-->
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
                  
                    
                  		<!-- <div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_news"></span>
					  			<h3>+10</h3>
                  			</div>
					  			<p>More than 10 news were added in your reader.</p>
                  		</div>
                  		<div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_data"></span>
					  			<h3>OK!</h3>
                  			</div>
					  			<p>Your server is working perfectly. Relax & enjoy.</p>
                  		</div> -->
                  		
                  	</div><!-- /row mt -->	
              </div>
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer"  style="margin-bottom:0px;">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="index#" class="go-top">
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
    
    <!--  우측 상단 알림창
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script> -->

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	<script type="text/javascript">
        $(document).ready(function () {
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Welcome to Dashgum!',
            // (string | mandatory) the text inside the notification
            text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
            // (string | optional) the image to display on the left
            image: 'assets/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false;
        });
	</script>
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
</body>
</html>
