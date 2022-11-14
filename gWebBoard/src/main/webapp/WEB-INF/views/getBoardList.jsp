<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% String pjName ="/gWebBoard"; %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 목록</title>
<!-- <link href='resources/css/test.css' rel='stylesheet' > -->
<link href='<%=pjName %>/resources/css/test.css' rel='stylesheet' >
</head>
<body>
		<h1>게시글 목록</h1>
		<form action='getBoardList.do'>
		<select name='searchCondition'>
			<option value='title'>제목</option>
			<option value='writer'>작성자</option>
			<option value='content'>내용</option>
		</select>
		<input type='text' name='searchKeyword'>
		<input type='submit' value='search'>
		</form>
		
		
		
	<table border="1">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<!--  글 제목을 클릭했을 때 게시글을 확인하기 위해서는 getBoard.do 요청이 수행되어야 하며 파라미터로 글 번호를 가져간다.  -->
					<td align="left"><a href="getBoard.do?seq=${board.seq }">
							${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.do">글쓰기</a>
</body>
</html>