<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
<style type="text/css">
@font-face {
    font-family: 'SUITE-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
    font-style: normal;
}
* {
   font-family: SUITE-Bold;
   font-weight: 700;
   font-size: 12pt;
}
.button2 {
   color: white;
   background: blueviolet;
   transition-duration: 0.3s;
   border: 0px;
   border-radius: 5px;
   padding: 5px;
   font-size: 12pt;
   font-weight: 500;
}
.button2:hover {
   color: blueviolet;
   background: white;
}
</style>
</head>
<body>
<form action="replyInsert" method="post">
   <input type="hidden" name="idx" value="${vo.idx}"/>
   <input type="hidden" name="gup" value="${vo.gup}"/>
   <input type="hidden" name="lev" value="${vo.lev}"/>
   <input type="hidden" name="seq" value="${vo.seq}"/>
   <input type="hidden" name="currentPage" value="${currentPage}"/>
   <table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
      <tr style="background: lightyellow">
         <th style="font-size: 20pt;" colspan="5">질문글</th>
      </tr>
      <tr style="background: aliceblue;" align="center">
            <th style="width: 80px;">No</th>
            <th style="width: 290px;">이름</th>
            <th style="width: 150px;">작성일</th>
            <th style="width: 80px;">조회수</th>
      </tr>
      <tr>
         <td align="center">
            ${vo.idx}
         </td>
         <td align="center">
             <c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
             <c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>         
             ${name}
         </td>
         <td align="center">
               <fmt:formatDate value="${vo.writeDate}" pattern="a yyyy:MM:dd(E)"/>
         </td>
         <td align="center">
                ${vo.hit}
         </td>         
        </tr>
        <tr>
           <th>제목</th>
           <td colspan="3">
              <c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"/>
              <c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>         
             ${subject}
           </td>
        </tr>
        <tr>
           <th>내용</th>
           <td colspan="3">
              <c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"/>
              <c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>    
              <c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>    
             ${content}
           </td>
        </tr>
   </table><br/>

   <table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
      <tr style="background: lightyellow">
         <th style="font-size: 20pt;" colspan="2">답글 쓰기</th>
      </tr>
      <tr>       
          <th width="100">이름</th>
          <td width="500">
             <input type="text" name="name" style="border: 0px;"/>
          </td>
       </tr>
        <tr>
           <th>제목</th>
           <td>
              <input type="text" name="subject" style="width: 99%; border: 0px;"/>
           </td>
        </tr>
        <tr>
           <th>내용</th>
           <td >
              <textarea rows="10" name="content" style="width: 99%; resize: none; border: 0px;"></textarea>
           </td>
        </tr>
        <tr style="background: lavender;">
            <td colspan="2" align="center">
               <input class="button2" type="submit" value="저장하기"/>
               <input class="button2" type="reset" value="다시쓰기"/>
               <input class="button2" type="button" value="돌아가기" onclick="history.back()"/>
               <input class="button2" type="button" value="목록보기" onclick="location.href='list?currentPage=${currentPage}'"/>
            </td>
         </tr>
   </table>
</form>
</body>
</html>