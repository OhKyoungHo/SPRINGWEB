<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_review.jsp</title>
</head>
<body>
<h2> 뷰페이지 지정 방식</h2>
<!--절대경로  -->
<a href='/fSpringMVC/review/modelandview.do'>1... ModelAndView</a><br/>
<!--상대경로  -->
<a href='review/string.do'>2. 문자열 리턴</a><br/>
<a href='review/void.do'>3. void 리턴(요청명과 동일한 뷰페이지명 )</a><br/>

</body>
</html>