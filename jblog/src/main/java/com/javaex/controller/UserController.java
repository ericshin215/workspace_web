package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		
		System.out.println("loginForm()");
		
		return "user/loginForm";
	}
	
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		
		UserVo authUser = userService.login(userVo);	
		
		System.out.println(authUser);	
		
		if(authUser != null) {
			
			session.setAttribute("authUser", authUser);
			
			
			System.out.println("loginSuccess");
			return "redirect:/";
			
			
		} else {	
			
			
			return "redirect:/user/loginForm?result=fail";
		}	
	}
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		
		System.out.println("logout");		
		
		
		session.invalidate();		
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		
		
		System.out.println("joinForm()");
		
		
		return "user/joinForm";
	}
	
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinOk(@ModelAttribute UserVo userVo) {	
		
		
		System.out.println("joinSucess");
		
		System.out.println(userVo);
		
		
		userService.join(userVo);	
		
		return "user/joinSuccess";
	}
	
	
	

}
