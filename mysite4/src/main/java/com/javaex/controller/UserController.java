package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.JsonResultVo;
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
			
			
			
			return "redirect:/main";
			
			
		} else {	
			
			
			return "redirect:/user/loginForm?result=fail";
		}	
	}
	
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		
		
		System.out.println("joinForm()");
		
		
		return "user/joinForm";
	}

	@RequestMapping(value = "/joinOk", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinOk(@ModelAttribute UserVo userVo) {	
		
		
		System.out.println("joinOk");
		
		System.out.println(userVo);
		
		
		//int count = userService.join(userVo);	
		
		return "user/joinOk";
	}
	
	

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		
		System.out.println("logout");		
		
		
		session.invalidate();		
		
		
		return "redirect:/main";
	}
	
//	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
//	public String modifyForm(HttpSession session, Model model) {
//		
//		System.out.println("modifyForm");
//		
//		
//		
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		
//		
//		UserVo change = userDao.userSelect2(authUser);
//		
//		
//		model.addAttribute("change",change);	
//		
//		
//		return "user/modifyForm";
//	}
//	
//	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
//	public String modify(@ModelAttribute UserVo userVo , HttpSession session) {		
//		System.out.println("modify");
//		
//		
//		userDao.userUpdate(userVo);	
//		
//		
//		System.out.println(userVo);
//		
//		
//		UserVo authUser = userDao.userSelect(userVo);
//		
//		System.out.println(authUser);
//	
//		
//		
//		session.setAttribute("authUser", authUser);
//		
//		
//		return "redirect:/main";
//	}
	
	//id check
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResultVo idCheck(@RequestParam(value="id") String id) {
		
		System.out.println("idcheck");
		
		boolean check=userService.idCheck(id);
		System.out.println(check);
		
		/*
		 * JsonResultVo jsonResultVo =new JsonResultVo("success", check, null);
		 * JsonResultVo jsonResultVo =new JsonResultVo("fail", null, "통신오류");
		 */
		
		
		JsonResultVo jsonResultVo = new JsonResultVo();
		jsonResultVo.success(check);
		
		return jsonResultVo;
	}
	
	
		
	
}