package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.GuestbookVo;

@RequestMapping(value="/guestbook")
@Controller
public class GuestbookController {
	
	
	@Autowired
	private GuestbookService gbService;
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		
		
		List<GuestbookVo> gbList = gbService.getgbList();
		
		
		//model 주소를 받고 메소드를 이용해서 담는다 --> DS request.setAttribute("personList", personList)
		model.addAttribute("gbList", gbList);
		
		
		
		//list.jsp에 포워드한다
		return "/guestbook/addList";
	}
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo gbVo, Model model) {
		
		
		
		gbService.addList(gbVo);
		
		
		//model 주소를 받고 메소드를 이용해서 담는다 --> DS request.setAttribute("personList", personList)

		
		
		
		//list.jsp에 포워드한다
		return "redirect:/guestbook/addList";
	}
	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("deleteform");
		
		
		
		
		
		
		return "/guestbook/deleteForm";
	}
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no,
						 @RequestParam(value="password") String password) {
		
		
		System.out.println(no);
		
		GuestbookVo guestbookVo = new GuestbookVo();
		guestbookVo.setNo(no);
		guestbookVo.setPassword(password);
				
		
		gbService.guestbookDelete(guestbookVo);
		
		return "redirect:/guestbook/addList";
	}
	
	
	
	
	
	

}