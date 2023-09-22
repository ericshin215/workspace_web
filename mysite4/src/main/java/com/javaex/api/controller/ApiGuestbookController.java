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
	@RequestMapping(value="/api/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo ) {
		System.out.println("apiGuestbookadd()");
		
		guestbookService.addList(guestbookVo);
		
		//데이터 1개 가져오기
		
		
		return "";
	}
}
