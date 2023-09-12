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
	System.out.println(personList);
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h1>등록금</h1>
	
	<p>정보를 등록하는 폼입니다. 정보를 등록하고 등록 버튼을 누르세요</p>
	
	<form>
	이름(name): <input type="text"><br>
	핸드폰(hp): <input type="text"><br>
	회사(company): <input type="text"><br>
	
	<button type="submit">등록</button>
	</form>
	
	<br>
	<br>
	
	<a href="http://localhost:8000/phonebook2/list.jsp">리스트로 바로가기</a>
	
</body>
</html>