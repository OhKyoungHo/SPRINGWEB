<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param.jsp</title>
</head>
<body>

<!-- 기본값이 param 인 것을 불러오는 것 -->
<h3>param</h3>
이름 		${param.name} 		<br/>
아이디 	${param.id}			<br/>
나이 		${param.age}		<br/>

<!-- test 메소드의 넣은 인자인 MemberVO인 것을 불러오는 것 -->
<h3>MemberVO</h3>
이름 		${memberVO.name}	<br/>
아이디 	${memberVO.id}		<br/>
나이 		${memberVO.age}		<br/>



</body>
</html>