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
	
	
	//List<PersonVo> personList = personDao.personSelect("");
	//System.out.println(personList);
	
	//리스트뿌리기 리다이렉트
	response.sendRedirect("./list.jsp");
	
%> 
