<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.PersonVo" %> 
<%@ page import = "com.javaex.dao.PersonDao" %> 
<%@ page import="java.util.*"%>
<%
	//파라미터의 값 꺼내오기
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	//vo 묶기
	PersonVo personVo = new PersonVo();
	personVo.setName(name);
	personVo.setHp(hp);
	personVo.setCompany(company);
	System.out.println(name +","+hp +","+company);
	

	System.out.println(personVo);
	//Dao를 통해서 데이터 저장
	PersonDao personDao = new PersonDao();
	int count = personDao.personInsert(personVo);
	
	
	List<PersonVo> personList = personDao.personSelect("");
	//System.out.println(personList);
	
	//리스트뿌리기 리다이렉트
	//response.sendRedirect("./list.jsp");
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>전화번호부</h1>
	<h2>리스트</h2>

	<p>등록된 전화번호 리스트 입니다.</p>


	<!-- 반복문시작 -->
	<%
	for (int i = 0; i < personList.size(); i++) {
	%>
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td><%=personList.get(i).getName() %></td>
		</tr>

		<tr>
			<td>핸드폰(hp)</td>
			<td><%=personList.get(i).getHp() %></td>
		</tr>

		<tr>
			<td>회사(company)</td>
			<td><%=personList.get(i).getCompany() %></td>
		</tr>
	</table>
	<br>

	<%
	}
	%>

	<a href="">전화번호 등록폼</a>
</body>
</html>