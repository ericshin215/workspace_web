<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    
    
<%@ page import = "com.javaex.vo.GuestBookVo" %> 
<%@ page import = "com.javaex.dao.GuestBookDao" %> 
<%@ page import="java.util.*"%>

<%
GuestBookDao guestbookDao = new GuestBookDao();
List<GuestBookVo> guestbookList = guestbookDao.guestbookSelect();
System.out.println(guestbookList);

List<GuestBookVo> personList = (List<GuestBookVo>)request.getAttribute("gbList");

//System.out.println(personList);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/guestbook3-1/gbc" method="get">
		<table border="1" width="540px">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="72" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
			
		</table>
		<input type="hidden" name="action" value="insert"><br>
	</form>
	<br>
	
	<%
	for (int i = 0; i < guestbookList.size(); i++) {
	%>
	<table border="1">
		<tr>
			
			<td><%=guestbookList.get(i).getNo() %></td>
			<td><%=guestbookList.get(i).getName() %></td>
			
			<td><%=guestbookList.get(i).getDate() %></td>
			<td><a href="./deleteForm.jsp?id=<%=guestbookList.get(i).getNo()%>&password=<%=guestbookList.get(i).getPassword()%>">삭제</a></td>
		</tr>

		<tr>
			
			<td colspan="4"><%=guestbookList.get(i).getContent() %></td>
		</tr>

		
	</table>
	<br>

	<%
	}
	%>


</body>
</html>