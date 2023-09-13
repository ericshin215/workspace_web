package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Controller


public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//localhost:8000/phonebook4/list
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		//System.out.println("PhoneController.list()");
		//new PersonDao()
		//personDao.personSelect() 리스트 가져온다
		PersonDao personDao = new PersonDao();
		List<PersonVo> personList = personDao.personSelect("");
		//System.out.println(personList);
		
		//model 주소를 받고 메소드를 이용해서 담는다 --> DS request.setAttribute("personList", personList)
		model.addAttribute("pList", personList);
		
		
		
		//list.jsp에 포워드한다
		return "/WEB-INF/list.jsp";
	}
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("PhoneController.writeForm()");
		
		return "/WEB-INF/writeForm.jsp";
	}
	
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
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		
		//vo 묶기 ds
		/*
		PersonVo personVo = new PersonVo();
		personVo.setName(name);
		personVo.setHp(hp);
		personVo.setCompany(company);
		System.out.println(personVo);
		*/
		
		// dao를 통해서 저장
		
		PersonDao personDao = new PersonDao();
		personDao.personInsert(personVo);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int personId) {
		System.out.println(personId);
		PersonDao personDao = new PersonDao();
		personDao.personDelete(personId);
		
		return "redirect:/list";
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
	
	

}
