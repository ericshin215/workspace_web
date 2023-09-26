package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.JsonResultVo;


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
		//System.out.println(guestbookList);
		
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
	
	
	//방명록 메인 화면
		@RequestMapping(value="/api/guestbook/addlist2", method= {RequestMethod.GET, RequestMethod.POST})
		public String addList2() {
			System.out.println("ApiGuestbookController.addList2()");
			
			
			return "guestbook/listAjax2";
		}
		
		
		//요청데이터를 json으로 받기
		@ResponseBody
		@RequestMapping(value="/api/guestbook/add2", method= {RequestMethod.GET, RequestMethod.POST})
		public JsonResultVo add2(@RequestBody GuestbookVo guestbookVo) {
			System.out.println("ApiGuestbookController.add2()");
			System.out.println(guestbookVo);
			
			//service 처리
			GuestbookVo gVo = guestbookService.addGuest(guestbookVo);
			
			JsonResultVo jsonResultVo= new JsonResultVo();
			jsonResultVo.success(gVo);
			
			return jsonResultVo; 
			
		}
		
		
		//복잡한 데이터 전송 테스트
		@RequestMapping(value="/api/guestbook/add3", method= {RequestMethod.GET, RequestMethod.POST})
		public String add3(@RequestBody List<GuestbookVo> guestbookList) {
			System.out.println("ApiGuestbookController.add3()");
			System.out.println(guestbookList);
			
			
			return null;
		}
	
	
	
}