<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>memoInsert.jsp</h1>

${vo}<br/>
이름: ${vo.name}<br/>
아이디: ${vo.id}<br/>
비밀번호: ${vo.password}<br/>
이메일: ${vo.email}
<hr/>
이름: ${memberVO.name}<br/>
아이디: ${memberVO.id}<br/>
비밀번호: ${memberVO.password}<br/>
이메일: ${memberVO.email}

</body>
</html>