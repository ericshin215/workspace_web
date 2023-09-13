<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.javaex.dao.GuestbookDao" %>
<%@ page import="com.javaex.vo.GuestbookVo" %>


<%
	GuestbookDao guestbookDao = new GuestbookDao();
	List<GuestbookVo> guestbookList = guestbookDao.guestbookSelect();
	System.out.println(guestbookList.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="/guestbook3/gbc" method="get">
		<table border="1" width="540px">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="72" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
		</table>
		
		<input type="text" name="action" value="add">
	</form>
	<br/>

	<% 
		for(int i=0; i<guestbookList.size(); i++){
	%>
			<table border="1" width="540px">
				<tr>
					<td>[<%=guestbookList.get(i).getNo() %>]</td>
					<td><%=guestbookList.get(i).getName() %></td>
					<td><%=guestbookList.get(i).getRegDate() %></td>
					<td><a href="/guestbook3/gbc?action=deleteForm&no=<%=guestbookList.get(i).getNo() %>">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4><%=guestbookList.get(i).getContent() %></td>
				</tr>
			</table>
		   	<br>
	<% 
		}
	%>
</body>
</html>