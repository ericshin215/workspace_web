package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao gbdao;
	
	public List<GuestbookVo> getgbList(){
		System.out.println("d");
		
		List<GuestbookVo> gbList = gbdao.getgbList();
		
		return gbList;
		
	}

	public void addList(GuestbookVo gbVo) {
		// TODO Auto-generated method stub
		gbdao.addList(gbVo);
	}

	public void guestbookDelete(GuestbookVo guestbookVo) {
		// TODO Auto-generated method stub
		
		gbdao.guestbookDelete(guestbookVo);
		
	}	
	

}
