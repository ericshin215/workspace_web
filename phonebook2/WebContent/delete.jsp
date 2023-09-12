<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.dao.PersonDao" %>    
    
<%

		
	String id = request.getParameter("id");
	int personId = Integer.parseInt(id);
	

	
	PersonDao personDao = new PersonDao();
	int count = personDao.personDelete(personId);
	System.out.println(count);
	
	
	//리스트 보여주기 -->리스트로 리다이렉트
	response.sendRedirect("./list.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>