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
	
	//방명록 들록 ajax
	public void addGuest(GuestbookVo gbVo) {
		// TODO Auto-generated method stub
		
		//등록
		int no = gbdao.insertSelectKey(gbVo);
		gbdao.addList(gbVo);
		
		//데이터 1개 가져오기
		
		
	}
	

}
