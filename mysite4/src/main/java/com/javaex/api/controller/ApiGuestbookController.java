package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;


@Controller
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	
	
	//방명록 메인 화면
	@RequestMapping(value="/api/guestbook/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		System.out.println("apiGuestbookaddList()");
		
		return "/guestbook/listAjax";
	}
	
	
	//방명록 데이터만 가져오기 (데이터만 전송) ajax
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list",method= {RequestMethod.GET, RequestMethod.POST })
	public List<GuestbookVo> list(){
		System.out.println("list");
		
		
		List<GuestbookVo> guestbookList = guestbookService.getgbList();
		System.out.println(guestbookList);
		
		return guestbookList;
		}
	
	
	
	
	//방명록 저장 ajax
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public GuestbookVo add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController.add()");
		
		//all                          //name  password content
		GuestbookVo gVo = guestbookService.addGuest(guestbookVo);
		 
		return gVo;
	}
	
	//방명록 삭제
	@RequestMapping(value="/api/guestbook/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public void delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController.delete()");
		
		//all                          //name  password content
		guestbookService.deleteGuestBook(guestbookVo);
		 
		
	}
	
	
	
	
}