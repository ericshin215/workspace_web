<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.PersonVo" %> 
<%@ page import = "com.javaex.dao.PersonDao" %> 
<%@ page import="java.util.*"%>


<%
//파라미터의 값 꺼내오기
int personId = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	//vo 묶기
	PersonVo personVo = new PersonVo(personId, name, hp, company);
	//personVo.setName(name);
	//personVo.setHp(hp);
	//personVo.setCompany(company);
	//System.out.println(name +","+hp +","+company);
	
	
	System.out.println(personVo);
	//Dao를 통해서 데이터 저장
	PersonDao personDao = new PersonDao();
	int count = personDao.personUpdate(personVo);
	
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