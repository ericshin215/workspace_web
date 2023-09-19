package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	public List<GuestbookVo> getgbList() {
		
		List<GuestbookVo> gbList = sqlSession.selectList("guestbook.selectList");
		
		return gbList;

	}

	public void addList(GuestbookVo gbVo) {
		// TODO Auto-generated method stub
		
		sqlSession.insert("guestbook.insertGuestbook", gbVo);
		
	}

	public void guestbookDelete(GuestbookVo guestbookVo) {
		// TODO Auto-generated method stub
		
		sqlSession.delete("guestbook.deleteGuestbook", guestbookVo);
		
	}



}
