<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>			<!-- jstl c -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>		<!-- jstl fmt -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	<!-- jstl fn -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같이먹장</title>

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
<script type="text/javascript" src="js/loginCheck.js" defer="defer"></script>


</head>
<body>
<!-- 메인 상단 바 -->
<header class="header-top bg-grey justify-content-center" style="margin-bottom: 50px;">
	<nav class="navbar navbar-expand-lg navigation row" style="margin: 0 80px;">
		<!-- 왼쪽 메인 로고 -->
		<div class="col-lg-2 col-md-12 d-none d-lg-block">
			<a class="navbar-brand " href="list">
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
	            	<input type="hidden" id="loginCheck" value="${mo.ID}"/>
	            	<ul id="menu" class="menu navbar-nav mx-auto">
	                	<li class="nav-item"><a href="#" onclick="loginCheck('partyInsert')" class="nav-link">파티생성</a></li>
	                    <li class="nav-item"><a href="list" class="nav-link">파티목록</a></li>
	                    <li class="nav-item"><a href="#" onclick="loginCheck('mylist')" class="nav-link">파티관리</a></li>
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
							<span class="text-center mr-3" style="font-size: 10pt;"><a id="myProfile" href="myProfile"> ${mo.ID}</a></span>
							<a id="logout-nav" href="logout"><i>로그아웃</i></a>
						</div>
					</div>
				</div>
			</c:if>
			
			<c:if test="${mo == null}">
				<div style="display: inline-flex;">
					<div class="list-inline-item follow-socials"><a href="login"style=" width: 100px;"><i>로그인</i></a></div>
					<div class="list-inline-item follow-socials"><a href="member"style=" width: 100px;"><i>회원가입</i></a></div>
				</div>
			</c:if>
			<!-- 로그인 로그아웃 끝 -->				
			</div>
		</div>
	</nav>
</header>
</body>
</html>