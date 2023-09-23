package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getgbList(){
		
		
		List<GuestbookVo> gbList = guestbookDao.getgbList();
		
		return gbList;
		
	}

	public int addList(GuestbookVo gbVo) {
		// TODO Auto-generated method stub
		 return guestbookDao.addList(gbVo);
	}

	public String guestbookDelete(GuestbookVo guestbookVo) {
		// TODO Auto-generated method stub
		
		String state;

		int count = guestbookDao.guestbookDelete(guestbookVo);

		if (count > 0) {
			state = "succeess";
		} else {
			state = "fail";
		}

		return state;
		
	}	
	
	//방명록 등록 ajax
		public GuestbookVo addGuest(GuestbookVo guestbookVo) {
			System.out.println("guestbookService/addGuest()");
			
			//등록
			int count = guestbookDao.insertSelectKey(guestbookVo);

			//no 의 데이터 가져오기
			// no값 확인
			int no = guestbookVo.getNo();
			// no데이터 가져오기
			
			return guestbookDao.selectGuestOne(no);
		}

		public void deleteGuestBook(GuestbookVo guestbookVo) {
			// TODO Auto-generated method stub
			
			guestbookDao.guestbookDelete(guestbookVo);
			
		}
	

}