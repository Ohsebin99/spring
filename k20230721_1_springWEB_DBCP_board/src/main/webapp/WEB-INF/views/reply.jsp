<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
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
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr style="background-color: #8d49ee;">
		<th colspan="4">질문글 보기</th>
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
				<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"></c:set>
				<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"></c:set>
				${subject}
			</td>
		</tr>
		<tr style="background-color:#f3ebfd;">
			<th>내용</th>
			<td colspan="3">
				<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"></c:set>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"></c:set>
				<c:set var="content" value="${fn:replace(content, 'enter', '<br/>')}"></c:set>
				${content}
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

<!-- ------------------------------- 답글을 입력하는 테이블 -------------------------------------->

<form action="replyInsert" method="post">
	
	<input type="hidden" name="idx" value="${vo.idx}"/> <!-- 질문글의 글번호 -->
	<input type="hidden" name="gup" value="${vo.gup}"/> <!-- 글그룹 -->
	<input type="hidden" name="lev" value="${vo.lev}"/> <!-- 글레벨 -->
	<input type="hidden" name="seq" value="${vo.seq}"/> <!-- 같은 글 그룹에서 글 출력 순서 -->
	<input type="hidden" name="currentPage" value="${currentPage}"/> <!-- 답글 입력후 돌아갈 페이지 번호 -->
	
	
<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr style="background-color: #8d49ee;">
		<th colspan="4">답글 쓰기</th>
	</tr>
	<tr style="background-color: #d9a8f9;">
		<th width="100">이름</th>
		<td width="500">
			<input type="text" name="name"/>
		</td>
	</tr>
		<tr style="background-color:#e2cafb; ">
			<th>제목</th>
			<td>
				<input type="text" name="subject" style="width: 98%"/>
			</td>
		</tr>
		<tr style="background-color:#f3ebfd;">
			<th>내용</th>
			<td>
				<textarea rows="10" name="content" style="width: 98%; resize: none;">${vo.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input class="btn" type="submit" value="저장"/>
				<input class="btn" type="reset" value="다시쓰기"/>
				<input class="btn" type="button" value="돌아가기" onclick="history.back()"/>
				<input class="btn" type="button" value="목록보기" 
						onclick="location.href='list?currentPage=${currentPage}'"/>
			</td>
		</tr>
		
</table>
	<input type="hidden" name="idx" value="${vo.idx}">
	<input type="hidden" name="currentPage" value="${currentPage}">
</form>

</body>



















</html>