<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	System.out.println(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/gbc" method="get">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
				<td><input type="submit" value="삭제"></td>
			</tr>
		</table>
		<br><br>
		<a href="/guestbook3/gbc?action=addList">메인으로 돌아가기</a>
		<br>
		<input type='text' name="no" value="<%=no%>">
		<input type='text' name="action" value="delete">
	</form>
</body>
</html>