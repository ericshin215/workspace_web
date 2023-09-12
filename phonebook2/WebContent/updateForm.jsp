<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.PersonVo" %> 
<%@ page import = "com.javaex.dao.PersonDao" %> 
<%@ page import="java.util.*"%>



<%

int personID = Integer.parseInt(request.getParameter("id"));
PersonDao personDao = new PersonDao();
PersonVo personVo = personDao.personSelectOne(personID);
System.out.println(personVo);



//System.out.println(personList);
%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 전화번호 리스트 </h1>
	
	
	<p>수정 화면입니다. 아래 항목을 수정하고 "수정"버튼을 클릭하세요</p>
	
	<form action="./update.jsp" method="get">
	이름(name): <input type="text" name = "name" value="<%=personVo.getName()%>"><br>
	핸드폰(hp): <input type="text" name = "hp" value="<%=personVo.getHp()%>"><br>
	회사(company): <input type="text" name = "company" value="<%=personVo.getCompany()%>"><br>
	id(personId): <input type="text" name = "id" value="<%=personVo.getPerson_id()%>"><br>
	<button type="submit">수정</button>
	</form>
	
	<br>
	<br>
	
	
	
</body>
</html>