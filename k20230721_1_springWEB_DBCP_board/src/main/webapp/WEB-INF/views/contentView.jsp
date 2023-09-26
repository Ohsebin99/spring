<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="stylesheet" href="./css/MvcBoard.css">
<title>게시글 보기</title>
</head>
<body>
<form action="update" method="post">
<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr style="background-color: #8d49ee;">
		<th colspan="4">게시판 보기</th>
	</tr>
	<tr style="background-color: #b386f3;">
			<th style="width: 80px;">글번호</td>
			<th style="width: 80px;">이름</td>
			<th style="width: 150px;">작성일</td>
			<th style="width: 80px;">조회수</td>
		</tr>
		<tr style="background-color: #d9a8f9;">
			<td align="center">${vo.idx}</td>
			<c:if test="${vo.lev > 0}">
					<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					Re.
				</c:if>
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
		<tr style="background-color:#f0e2fd; ">
			<th>제목</th>
			<td colspan="3">
				<input type="text" name="subject" value="${vo.subject}" style="width: 98%"/>
			</td>
		</tr>
		<tr style="background-color:#f3ebfd;">
			<th>내용</th>
			<td colspan="3">
				<textarea rows="10" name="content" style="width: 98%; resize: none;">${vo.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="hidden" name="idx" value="${vo.idx}">
			
				<input class="btn" type="submit" value="수정"/>
				<input class="btn" type="button" value="삭제" 
						onclick="location.href='delete?idx=${vo.idx}&currentPage=${currentPage}'"/>
				<input class="btn" type="button" value="답변"
						onclick="location.href='reply?idx=${vo.idx}&currentPage=${currentPage}'"/>
				<input class="btn" type="button" value="이전 페이지" 
						onclick="location.href='list?currentPage=${currentPage}'"/>
			</td>
		</tr>
		
</table>
	<input type="hidden" name="idx" value="${vo.idx}">
	<input type="hidden" name="currentPage" value="${currentPage}">

</form>

</body>



















</html>