<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
 
 <script type="text/javascript">
   $(document).ready(function() {
      let name = ${result}.response.name;
      let email = ${result}.response.email;
      $('#name').html('환영합니다람쥐~~~~~~~~~~~~~~~~~~~~~~' + name + '님아');
      $('#email').html(email);
   });
</script>
 
</head>
<body>

<div style="text-align: center;">
   <h1>록으인 성공!!!!!!!!!!</h1>
</div><br/>

<h1 id="name" style="text-align: center;"></h1>
<h2 id="email" style="text-align: center;"></h2>
세션값: ${sessionId}

<h3>
   <a href="logout">록으아웃</a>
</h3>


</body>
</html>