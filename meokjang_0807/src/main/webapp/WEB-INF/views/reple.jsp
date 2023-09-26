<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         <!-- jstl c -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      <!-- jstl fmt -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   <!-- jstl fn -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티글 보기</title>

<!-- common -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>			<!-- device-width -->
<link rel="icon" href="images/favicon.png">										<!--  favicon -->
<script type="text/javascript" src="common/jquery-3.7.0.js"></script>			<!-- jQury -->
<link rel="stylesheet" href="common/bootstrap/bootstrap.min.css">				<!-- bootstrap -->
<script src="common/bootstrap/bootstrap.min.js"></script>						<!-- bootstrap -->
<script src="common/bootstrap/popper.min.js"></script>							<!-- bootstrap -->
<script type="text/javascript" src="common/custom.js" defer="defer"></script>	<!-- template -->
<link rel="stylesheet" href="common/style.css"/>								<!-- template -->

<link rel="stylesheet" href="common/slick-carousel/slick-theme.css">			<!-- slick -->
<link rel="stylesheet" href="common/slick-carousel/slick.css">					<!-- slick -->
<script src="common/slick-carousel/slick.min.js"></script>						<!-- slick -->

<!-- private -->
<script type="text/javascript" src="js/repleView.js" defer="defer"></script>
</head>
<body>
<%-- 
   ${vo}<br/>
   ${mo}<br/>
   ${repleList}<br/> 
--%>

<fmt:requestEncoding value="UTF-8"/>

<!-- 메인 상단 바 -->
<header class="header-top bg-grey justify-content-center" style="margin-bottom: 50px;">
   <nav class="navbar navbar-expand-lg navigation row" style="margin: 0 80px;">
      <!-- 왼쪽 메인 로고 -->
      <div class="col-lg-2 col-md-12 d-none d-lg-block">
         <a class="navbar-brand " href="list.jsp">
            <img src="images/logo.png" alt="메인 로고 이미지" class="img-fluid">
         </a>
      </div>
      <!-- 여백 -->
      <div class="col-lg-1 col-md-6">
      </div>
      <!-- nav  바 -->
      <div class="col-lg-6 col-md-12">
         <nav class="navbar navbar-expand-lg navigation-2 navigation">
              <div class="collapse navbar-collapse" id="navbar-collapse">
                  <ul id="menu" class="menu navbar-nav mx-auto">
                      <li class="nav-item"><a href="partyInsert.jsp" class="nav-link">파티생성</a></li>
                       <li class="nav-item"><a href="list.jsp" class="nav-link">파티목록</a></li>
                       <li class="nav-item"><a href="mylist.jsp" class="nav-link">파티관리</a></li>
                       <!-- <li class="nav-item"></li> -->
                   </ul>
              </div>
         </nav>
      </div>
      <!-- 여백 -->
      <div class="col-lg-1 col-md-6">
      </div>
      <!-- 로그인 로그아웃 -->
      <div class="col-lg-2 col-md-6">
         <div class="header-socials-2 text-right d-none d-lg-block">
         <c:if test="${mo != null}">
            <div class="row">
               <div class="list-inline-item">
                  <div class="row">
                     <span class="text-center mr-3" style="font-size: 10pt;"><a id="myProfile" href="login-register/myProfileChK.jsp"> ${mo.ID}</a></span>
                     <a id="logout-nav" href="login-register/logoutOK.jsp"><i>로그아웃</i></a>
                  </div>
               </div>
            </div>
         </c:if>
         
         <c:if test="${mo == null }">
            <div style="display: inline-flex;">
               <div class="list-inline-item follow-socials"><a href="login-register/login.jsp"style=" width: 100px;"><i>로그인</i></a></div>
               <div class="list-inline-item follow-socials"><a href="login-register/member.jsp"style=" width: 100px;"><i>회원가입</i></a></div>
            </div>
         </c:if>
         <!-- 로그인 로그아웃 끝 -->            
         </div>
      </div>
   </nav>
</header>


<!--  -->

<section class="single-block-wrapper section-padding">
<div class="container">
<div class="row">

   <div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
      <div class="single-post">
          <div class="post-header mb-5 text-center">
              <h2 class="post-title mt-2">
                <c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"/>
                <c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
               ${subject}
              </h2>
            <!-- 음식 카테고리 -->
            <h4 class="post-title mt-4">${vo.category}</h4>
              <div class="post-featured-image mt-5">
                 <img src="upload/${vo.photo}" class="img-fluid w-100" style="height: 300px;"/>
              </div>
          </div>
           <div class="post-body">
            <!--  -->
            <div class="container bg-grey comment-form">
               <div class="row">
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                     <div class="col-lg-12">
                        <div class="row">
                           <!-- 장소 -->
                           <div class="col-lg-12">
                              <h5 class="m-3 text-center">장소</h5>
                              <input type="text" id="place" class="form-control-plaintext text-center mt-3 mb-3" readonly="readonly"
                              value="${vo.place}"/>
                           </div>
                           
                           <!-- 다음 API -->
                           <div class="col-lg-12">
                              <div id="map" style="width:100%;height:350px;"></div>                           
                           </div>
                           
                           <!-- 음주 -->
                           <div class="col-lg-3 col-md-6">
                              <h5 class="mb-3 text-center">술 여부</h5>
                              <input type="text" class="form-control-plaintext text-center mb-3" readonly="readonly"
                                 value="${vo.acholchk}"/>
                           </div>
                           <!-- 인원 -->
                           <div class="col-lg-3 col-md-6">
                              <h5 class="mb-3 text-center">인원 제한</h5>
                              <input type="text" class="form-control-plaintext text-center mb-3" readonly="readonly"
                                 value="${vo.limitNum}명"/>
                           </div>
                           <!-- 나이 -->
                           <div class="col-lg-3 col-md-6">
                              <h5 class="mb-3 text-center">나이 제한</h5>
                              <input type="text" class="form-control-plaintext text-center mb-3" readonly="readonly"
                              value="${vo.minLimitAge}살 ~ ${vo.maxLimitAge}살"/>
                           </div>
                           <!-- 성별 -->
                           <div class="col-lg-3 col-md-6">
                              <h5 class="mb-3 text-center">성별</h5>
                              <input type="text" class="form-control-plaintext text-center mb-3" readonly="readonly"
                                 value="${vo.partyGender}"/>
                           </div>
                           
                           <!-- 모임 시간 -->
                           <div class="col-md-6">
                              <h5 class="mb-3 text-center">식사 시간</h5>
                              <input type="text" class="form-control-plaintext text-center mb-5" readonly="readonly"
                                 value="<fmt:formatDate value="${vo.mealDate}" pattern="MM월 dd일 HH:mm"/>"/>
                           </div>
                           
                           <!-- 글 내용 -->
                           <div class="col-lg-12">
                              <div class="ml-2 mb-3"><b>파티 내용</b></div>
                              <c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"/>
                              <c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
                              <c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
                              <textarea class="form-control mb-3" rows="15" cols="30" style="resize: none;" readonly="readonly">${content}</textarea>
                           </div>
                        </div>
                        <div class="row">   
                           <div class="col-lg-12 text-center" style="margin-bottom: 15px;">
                              <div class="btn-group">
                              <c:if test="${view.size() != 0}">
                              </c:if>
                              	<c:if test="${vo.ID == mo.ID}">
                                 <input class="btn btn-primary" type="button" value="수정하기"
                                    onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=partyUpdate'"/>
                                 <input class="btn btn-primary" type="button" value="삭제하기"
                                    onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=partyDelete'"/>
                                 </c:if>   
                                 <input class="btn btn-primary" type="button" value="돌아가기"
                                    onclick="history.back()"/>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
                        <!-- 참여 하기 -->
            <div class="form-control mb-3 bg-grey">
           		<c:if test="${vo.ID != mo.ID}">
                   <!-- 신고 -->
                   <form action="repleReport.jsp">
                      <input type="submit" class="btn btn-primary" value="신고" style="float: right;"/>
                      <input type="hidden" name="idx" value="${vo.idx}"/>
                      <input type="hidden" name="deleteReport" value="${vo.deleteReport}"/>
                     <input type="hidden" name="currentPage" value="${currentPage}"/>
                   </form>
                </c:if>
               <form action="repleInsertOK.jsp" method="post">
               	<c:if test="${vo.ID != mo.ID}">
                  <h4 class="text-center widget-title" style="margin-top: 8px; margin-left: 70px;">참여하기</h4>
                  <textarea class="form-control mb-3 bg-white"  name="reple" rows="3" placeholder="파티장에게 메세지를 보내세요." style="resize: none;"></textarea>
                  
                     <input type="submit" class="btn btn-primary " value="참여 신청"/>
                  </c:if>
                  <div><!-- hidden -->
                     <input type="hidden" name="repleIp" value="${pageContext.request.remoteAddr}"/>      
                     <input type="hidden" name="repleID" value="${mo.ID}"/>   
                     <input type="hidden" name="masterID" value="${vo.ID}"/>   
                     <input type="hidden" name="repleNickName" value="${mo.nickName}"/>   
                     <input type="hidden" name="repleGender" value="${mo.gender}"/>   
                     <input type="hidden" name="repleAge" value="${mo.age}"/>   
                     <input type="hidden" name="repleLimitNum" value="${vo.limitNum}"/>   
                     <input type="hidden" name="originIdx" value="${vo.idx}"/>   
                     <input type="hidden" name="currentPage" value="${currentPage}"/>   
                  </div>
               </form>
               
            </div>
           </div>
      </div>
   </div>
   
   <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
      <div class="sidebar sidebar-right">
         <div class="sidebar-wrap mt-5 mt-lg-0">
            
            <div class="sidebar-widget about mb-5 text-center p-3">
               <div class="about-author">
                  <img src="images/gogildong.jpg" class="img-fluid">
               </div>
               <h4 class="mb-0 mt-4">먹방 짱</h4>
               <p>${vo.nickName}</p>
            </div>
            
            <!-- fix 개수 -->
            <c:set var="count" value="${1}"/>
            <c:set var="view" value="${repleList.list}"/>
            <c:forEach var="ro" items="${view}">
               <c:if test="${ro.fix == 'Y'}">
                  <c:set var="count" value="${count + 1}"/>
               </c:if>
            </c:forEach>
            <%-- ${count} --%>
            
            <div class="sidebar-widget mb-5 ">
               <h4 class="text-center widget-title">신청 목록</h4>
                
                 <!-- 신청목록 반복 실행 시작 -->
                <c:set var="view" value="${repleList.list}"/>
                 <c:forEach var="ro" items="${view}">
                 <!-- 인원제한까지만 보이게하기 -->
                 <c:if test="${vo.limitNum > count}">
                 <!-- 신청목록 -->
                 <c:if test="${ro.repleID == mo.ID || ro.masterID == mo.ID}">
	                 <c:if test="${ro.fix == 'N'}">
	                    <div class="media border-bottom py-3 sidebar-post-item">
	                        <a href="#"><img class="mr-4" src="images/dooly.jpg"></a>
	                        <div class="media-body">
	                           <h5 class="widget">${ro.repleID}</h5>
	                           <span class="text-muted font-sm">
	                           <fmt:formatDate value="${ro.writeDate}" pattern="MM월 dd일 HH:mm" />
	                           </span><br/>
	                        <span>
	                           ${ro.repleGender}
	                        </span>
	                        <span>
	                           ${ro.repleAge}
	                        </span>
	                        <span class="font-sm letter-spacing-1">
	                        <c:set var="reple" value="${fn:replace(ro.reple, '<', '&lt;')}"/>
                              <c:set var="reple" value="${fn:replace(reple, '>', '&gt;')}"/>
                              <c:set var="reple" value="${fn:replace(reple, enter, '<br/>')}"/>
	                           ${reple}
	                        </span>
	                        </div>
	                    </div>
	                 </c:if>
                 </c:if>
                 <!-- 방장만 보는 승인 거절 버튼 -->
                 <c:if test="${ro.masterID == mo.ID && ro.fix == 'N'}">
                    <input class="btn btn-primary" type="button" value="승인"
                     onclick="location.href='joinRecognition.jsp?idx=${vo.idx}&currentPage=${currentPage}&repleIdx=${ro.repleIdx}'"/>
                  <input class="btn btn-primary" type="button" value="거절"
                     onclick="location.href='joinRejection.jsp?idx=${vo.idx}&currentPage=${currentPage}&repleIdx=${ro.repleIdx}'"/>
                 </c:if>
                
                </c:if>
                 </c:forEach>
                 
                 <!-- 신청목록 반복 실행 끝 -->
                 
                 <!-- 참여목록 반복 실행 시작 -->
                 <h4 class="text-center widget-title mt-4">참여 목록</h4>
                 <c:forEach var="ro" items="${view}">
                    <c:if test="${ro.fix == 'Y'}">
                       <div class="media border-bottom py-3 sidebar-post-item">
                        <a href="#"><img class="mr-4" src="upload/dooly.jpg"></a>
                        <div class="media-body">
                           <h5 class="widget">${ro.repleID}</h5>
                           <span class="text-muted font-sm">
                           <fmt:formatDate value="${ro.writeDate}" pattern="MM월 dd일 HH:mm" />
                           </span><br/>
                        <span>
                           ${ro.repleGender}
                        </span>
                        <span>
                           ${ro.repleAge}
                        </span>
                        <span class="font-sm letter-spacing-1">
                           ${ro.reple}
                        </span>
                        </div>
                    </div>
                    </c:if>
                 </c:forEach>
            </div>
            
         </div>
      </div>
   </div>

</div>
</div>
</section>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0b6bf51f6f463894d9e2e6e36957148d&libraries=services"></script>
</body>
</html>