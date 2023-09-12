package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;


@WebServlet("/gbc")
public class gbc extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
   
	//생성자 디폴트 생성자 사용 - 삭제
	
	//메소드 gs 필요없음
	
	//메소드 일반
   //get방식으로 요청이 들어왔을때 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PhonebookController");
		//파라미터 action의 값을 꺼내온다
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("addlist".equals(action)) {
			
			System.out.println("action=addlist");
		
		//리스트
		//1.dao를 통해서  전체 리스트데이터 가져오기
		GuestBookDao gbDao = new GuestBookDao();
		List<GuestBookVo> gbList = gbDao.guestbookSelect();
		
		//System.out.println(personList);
		
		//리스트 화면(html) +data 응답을 해야된다
		
		//request data를 넣어둔다
		request.setAttribute("gbList", gbList);

		
		//list.jsp 에게 시킨다 (포워드)
		
		//forword 하는 방법
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addlist.jsp");
		rd.forward(request, response);

		}
//		else if("wform".equals(action)) {
//			System.out.println("action=wform");
//			
//			//writeForm.jsp 에게 시킨다 (포워드)
//			
//			//forword 하는 방법
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
//			rd.forward(request, response);
//			
		//}
	else if("insert".equals(action)) {
			System.out.println("action=insert");
			
			
			String name= request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			GuestBookVo gbVo = new GuestBookVo();
			gbVo.setName(name);
			gbVo.setPassword(password);
			gbVo.setContent(content);
			
			//System.out.println(personVo);
			//dao를 이용해서 데이타 저장하기
			
			GuestBookDao gbDao = new GuestBookDao();
			int count = gbDao.guestbookInsert(gbVo);
			System.out.println(count);
			
			//리스트로 출력
			response.sendRedirect("/guestbook3-1/gbc?action=addlist");
			
			//writeForm.jsp 에게 시킨다 (포워드)
			
			//forword 하는 방법
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			//rd.forward(request, response);
			
		}
		//else if("delete".equals(action)) {
//			System.out.println("action=delete");
//			String id = request.getParameter("id");
//			int personId = Integer.parseInt(id);
//			
//
//			
//			PersonDao personDao = new PersonDao();
//			int count = personDao.personDelete(personId);
//			
//			//리스트로 출력
//			response.sendRedirect("/phonebook3/PhonebookController?action=list");
//			
//			
//			
//		}else if("uform".equals(action)) {
//			System.out.println("action=uform");
//			
//			int personId = Integer.parseInt(request.getParameter("id"));
//			String name = request.getParameter("name");
//			String hp = request.getParameter("hp");
//			String company = request.getParameter("company");
//			
//			
//			//writeForm.jsp 에게 시킨다 (포워드)
//			
//			//forword 하는 방법
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
//			rd.forward(request, response);
//			
//		}else if("update".equals(action)) {
//			System.out.println("action=update");
//			String id = request.getParameter("id");
//			int personId = Integer.parseInt(id);
//			String name = request.getParameter("name");
//			String hp = request.getParameter("hp");
//			String company = request.getParameter("company");
//			
//			PersonVo personvo = new PersonVo(personId, name,hp,company);
//
//			
//			PersonDao personDao = new PersonDao();
//			int count = personDao.personUpdate(personvo);
//			
//			//리스트로 출력
//			response.sendRedirect("/phonebook3/PhonebookController?action=list");
//			
//		}
//			
//		
//		
		else {
			System.out.println("나머지");
		}
	}

	//post방식으로 요청이 들어왔을때 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

