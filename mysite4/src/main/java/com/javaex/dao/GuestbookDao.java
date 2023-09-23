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

	public int addList(GuestbookVo gbVo) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("guestbook.insertGuestbook", gbVo);
		
	}

	public int guestbookDelete(GuestbookVo guestbookVo) {
		// TODO Auto-generated method stub
		
		return sqlSession.delete("guestbook.deleteGuestbook", guestbookVo);
		
	}
	
	//방명록 글 저장 ajax selectKey
	public int insertSelectKey(GuestbookVo guestbookVo) {
		
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		
		return guestbookVo.getNo();
	}
	//no의 데이터 1개 가져오기
	public GuestbookVo selectGuestOne(int no) {
		System.out.println("GuestbookDao>selectGuestOne()");
		
		//GuestbookVo guestbookVo = sqlSession.selectOne("guestbook.selectOneByNo", no);
		return sqlSession.selectOne("guestbook.selectOneByNo", no);
	}

	



}
