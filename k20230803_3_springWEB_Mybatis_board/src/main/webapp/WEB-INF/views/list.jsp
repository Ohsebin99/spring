<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- bootstrap icon -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="./css/MvcBoard.css">
<style type="text/css">
@font-face {
    font-family: 'TheJamsil5Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

* {
	font-family: TheJamsil5Bold;
}

a{
	text-decoration: blink;
}

a:hover {
	text-decoration: underline;
}

.button {
	padding: 8px;
	font-size: 18px;
	cursor: pointer;
}

.button:hover {
	text-decoration: underline;
}

.table2 {
	background-color: #6b80a8;
}
.btn{
	background-color: #6b80a8;
	border-radius: 5px;
}
.btn:hover {
	color: white;
	cursor: pointer;
}
</style>
<title>게시판 보기</title>
</head>
<body>

<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr class="table2">
		<th colspan="5">게시판 보기</th>
	</tr>
	<tr class="Page">
			<td colspan="5" align="right">
				글 개수: ${boardList.totalCount} / 현재 페이지: ${boardList.currentPage} / 전체 페이지: ${boardList.totalPage})
			</td>
		</tr>
		<tr>
			<th style="width: 70px;">글번호</td>
			<th style="width: 610px;">제목</td>
			<th style="width: 100px;">이름</td>
			<th style="width: 150px;">작성일</td>
			<th style="width: 70px;">조회수</td>
		</tr>	
		
		<c:set var="list" value="${boardList.list}"/>
		
		<c:if test="${list.size() == 0}">
		<tr>
			<td colspan="5">
				<marquee>테이블에 저장된 글이 없습니다.</marquee>
			</td>
		</tr>
		</c:if>
		
		<c:if test="${list.size() != 0}">
		<c:forEach var="vo" items="${list}">
			<tr style="background-color: #fbecb6;">
				<td align="center">
					${vo.idx}
				</td>
				<td align="left">
				<!-- 카테고리 레벨(lev)에 따른 들여쓰기를 한다. -->
				<c:if test="${vo.lev > 0}">
					<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					Re.
				</c:if>
					<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"></c:set>
					<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"></c:set>
					<a href="increment.nhn?idx=${vo.idx}&currentPage=${boardList.currentPage}" style=" color: black">
					${subject}</a>
					
				<c:if test="${vo.hit >= 10}">
					<img src="hot.gif"/>
				</c:if>
					
				</td>
				<td align="center">
					<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"></c:set>
					<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"></c:set>
					${name}
				</td >
				<td align="center">
					<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E) "/>
				</td>
				<td align="center">${vo.hit}</td>
			</tr>
		</c:forEach>
		</c:if>
</table>
<table  style="width: 1000px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="5" align="center">
			<!-- 처음으로 -->
			<c:if test="${boardList.currentPage > 1}">
				<span 
					class='button button1' 
					type="button" 
					title="첫 페이지로 이동합니다." 
					onclick="location.href='?currentPage=1'"
				><i class="bi bi-rewind-fill"></i></span>
			</c:if>
		
			
			<!-- 10페이지 앞으로 -->
			<c:if test="${boardList.startPage > 1}">
				<span 
					class='button button1' 
					type="button" 
					title="이전 10페이지로 이동합니다." 
					onclick="location.href='?currentPage=${boardList.startPage - 1}'"
				><i class="bi bi-caret-left-fill"></i></span>
			</c:if>
			
			
			<!-- 페이지 이동 버튼 -->
			<c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}" step="1">
				<c:if test="${boardList.currentPage == i}">
					<span class='button button2' style="color: red;" type='button' disabled='disabled'>${i}</span>
				</c:if>
				<c:if test="${boardList.currentPage != i}">
					<span 
						class='button button1' 
						type='button' 
						title="${i}페이지로 이동합니다."
						onclick="location.href='?currentPage=${i}'"
					>${i}</span>
				</c:if>
			</c:forEach>
			
			<!-- 10페이지 뒤로 -->
			<c:if test="${boardList.endPage < boardList.totalPage}">
				<span 
					class='button button1' 
					type="button" 
					title="다음 10페이지로 이동합니다." 
					onclick="location.href='?currentPage=${boardList.endPage + 1}'"
				><i class="bi bi-caret-right-fill"></i></span>
			</c:if>
			
			
			<!-- 마지막으로 -->
			<c:if test="${boardList.currentPage < boardList.totalPage}">
			<span
				class='button btn-sm'  
				type="button" 
				title="마지막 페이지로 이동합니다." 
				onclick="location.href='?currentPage=${boardList.totalPage}'"
			><i class="bi bi-fast-forward-fill"></i></span>
			</c:if>
			
			
			
			
		<!-- 글쓰기 버튼 -->
			<span  style="float: right; height: 28px;" >
		<label for="write"><i class="bi bi-pencil-fill align low" ></i></label>
				<input class="btn" 
					   id="write"
					   type="button"
					   value="글쓰기"
					   style="font-size: 15px; line-height: 20px;"
					   onclick="location.href='insert.jsp'">
					   	</span>
			</td>
		</tr>
	</table>

</body>
</html>