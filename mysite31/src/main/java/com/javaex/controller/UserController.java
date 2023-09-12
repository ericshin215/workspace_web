package com.javaex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//업무구분용 파라미터 체크
		String action = request.getParameter("action");
		if("joinForm".equals(action)) {
			
			System.out.println("action=joinForm");
			//포워드
			/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinForm.jsp");
			rd.forward(request, response);
			*/
			
			//포워드를 util 사용
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");
			
			
			/*
			 * 메모
			WebUtil webutil = new WebUtil();
			webutil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");
			 
			WebUtil webutil = new WebUtil();
			webutil.redirect(request, response, "/phonebook3/PhonebookController?action=list"); 
			 
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");
			WebUtil.redirect(request, response, "/phonebook3/PhonebookController?action=list")
			*/
					
		}else if ("join".equals(action)) {
			//회원가입
			//System.out.println("action=join");
			
			//파라미터 꺼내기
			String id = request.getParameter("id");
			String name= request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			System.out.println(name);
			
			//1개로 묶기
			UserVo userVo = new UserVo(id, name, password, gender);
			
			//System.out.println(userVo);
			UserDao userDao = new UserDao();
			int count = userDao.userInsert(userVo);
			System.out.println(count);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinOk.jsp");
			rd.forward(request, response);
		}else if ("loginForm".equals(action)) {
			
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");
		}
		
		else if ("login".equals(action)) {
			//로그인
			System.out.println("action=login");
			
			//파라미터꺼내기
			String id = request.getParameter("id");
			String password = request.getParameter("pw");
			
			
			//vo로 묶기
			UserVo userVo = new UserVo();
			userVo.setId(id);
			userVo.setPassword(password);
			
			System.out.println(userVo);
			
			
			//Dao를 통해 로그인한 사용자가 있는지 확인한다
			UserDao userDao = new UserDao();
			UserVo authUser = userDao.userSelect(userVo);
			
			System.out.println(authUser);
			//authUser null 이면 로그인실패
			//authUser null이 아니면 로그인 성공
			
			if(authUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("authUser", authUser);
				
				
				WebUtil.redirect(request, response, "/mysite3/main"); 
				
				
			}
			else {
				WebUtil.redirect(request, response, "/mysite3/user?action=loginForm&result=fail");
				
			}
			

			
			//세션에 값넣기
			
			
			
			//WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");
		}else if("logout".equals(action)) {
			System.out.println("action=logout");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			WebUtil.redirect(request, response, "/mysite3/main"); 
		}else if ("modifyForm".equals(action)) {
			
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/modifyForm.jsp");
		}else if ("modify".equals(action)) {
			
			
			
			int no = Integer.parseInt(request.getParameter("no"));
			String id= request.getParameter("id");
			String name= request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserVo userVo = new UserVo(no,id,name,password,gender);
			//System.out.println(userVo);
			UserDao userDao = new UserDao();
			userDao.userUpdate(userVo);
			//System.out.println(userVo);
			
			
			
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			UserVo authUser = userDao.userSelect(userVo);
			session = request.getSession();
			session.setAttribute("authUser", authUser);
			
			System.out.println(authUser);
			
			WebUtil.redirect(request, response, "/mysite3/main"); 
			
//			userVo.setNo(no);
//			userVo.setName(name);
//			userVo.setPassword(password);
//			userVo.setGender(gender);
			
			
			
		}
		
		
		
		//회원가입폼(action=joinForm)
		//포워드
		
		
		
		
		//회원가입(action=join)
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
