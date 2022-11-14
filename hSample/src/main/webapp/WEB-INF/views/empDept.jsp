<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDept.jsp</title>
</head>
<body>

추후에 화면 출력<hr/>

<h2>화면에 정보 출력</h2>

<table border='2'>
<!--*****hashmap 값을 가져올때는 컬럼명을 대문자로 가지고 와야 한다.
console화면에 나와있는 키값과 그에 해당하는 밸류값을 출력해줘야 하기 때문에 대문자로 맞춰준다-->
<!-- HASHMAP에서는 값을 뽑아올때는 get을 사용 -->
<!--var 변수명은 자유  -->
	<c:forEach  var='vo' items='${result}'>
	<tr>
		<td>${vo.EMPNO}</td>
		<td>${vo.ENAME}</td>
		<td>${vo.get("DNAME")}</td>
	</tr>
	</c:forEach>


</table>



</body>
</html>