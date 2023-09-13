package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.dao.PersonDao;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.PersonVo;

@Controller


public class GuestbookController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//localhost:8000/phonebook4/list
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		
		GuestbookDao guestbookDao = new GuestbookDao();
		List<GuestbookVo> guestbookList = guestbookDao.guestbookSelect();
		
		
		//model 주소를 받고 메소드를 이용해서 담는다 --> DS request.setAttribute("personList", personList)
		model.addAttribute("gbList", guestbookList);
		
		
		
		//list.jsp에 포워드한다
		return "/WEB-INF/addList.jsp";
	}
//	
//	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
//	public String writeForm() {
//		
//		System.out.println("PhoneController.writeForm()");
//		
//		return "/WEB-INF/writeForm.jsp";
//	}
	
//	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
//	public String write(@RequestParam(value="name") String name, 
//						@RequestParam(value="hp") String hp,
//						@RequestParam(value="company") String company) {
//		
//		//vo 묶기
//		PersonVo personVo = new PersonVo();
//		personVo.setName(name);
//		personVo.setHp(hp);
//		personVo.setCompany(company);
//		System.out.println(personVo);
//		
//		// dao를 통해서 저장
//		PersonDao personDao = new PersonDao();
//		personDao.personInsert(personVo);
//		
//		return "redirect:/list";
//	}
//	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		
		//vo 묶기 ds
		/*
		PersonVo personVo = new PersonVo();
		personVo.setName(name);
		personVo.setHp(hp);
		personVo.setCompany(company);
		System.out.println(personVo);
		*/
		
		// dao를 통해서 저장
		
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.guestbookInsert(guestbookVo);
		
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("deleteform");
		
		
		
		
		
		
		return "/WEB-INF/deleteForm.jsp";
	}
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no,
						 @RequestParam(value="password") String password) {
		
		
		System.out.println(no);
		
		GuestbookVo guestbookVo = new GuestbookVo();
		guestbookVo.setNo(no);
		guestbookVo.setPassword(password);
				
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.guestbookDelete(guestbookVo);
		
		return "redirect:/addList";
	}
	
//	@RequestMapping(value="/delete/{no}", method= {RequestMethod.GET, RequestMethod.POST})
//	public String delete(@PathVariable(value="no") int personId) {
//		
//		PersonDao personDao = new PersonDao();
//		personDao.personDelete(personId);
//		
//		return "redirect:/list";
//	}
//	
	/*
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@RequestParam(value="name") String name, 
			@RequestParam(value="hp") String hp,
			@RequestParam(value="id") int personId,
			@RequestParam(value="company") String company) {
		PersonVo personVo = new PersonVo(personId, name, hp, company);
		PersonDao personDao = new PersonDao();
		personDao.personUpdate(personVo);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(@RequestParam(value="no") int personId, Model model) {
		
		//System.out.println("PhoneController.list()");
		//new PersonDao()
		//personDao.personSelect() 리스트 가져온다
		PersonDao personDao = new PersonDao();
		PersonVo personVo = personDao.personSelectOne(personId);
		
		//System.out.println(personList);
		
		//model 주소를 받고 메소드를 이용해서 담는다 --> DS request.setAttribute("personList", personList)
		model.addAttribute("personVo", personVo);
		
		
		
		//list.jsp에 포워드한다
		return "/WEB-INF/updateForm.jsp";
	}
	
	*/
	

}
