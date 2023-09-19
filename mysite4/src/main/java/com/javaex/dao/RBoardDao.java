package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.javaex.vo.RBoardVo;

@Repository
public class RBoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<RBoardVo> rboardSelectList(){
		System.out.println("RBoardDao.boardSelecList()");
		
		List<RBoardVo> rboardList = sqlSession.selectList("rboard.selectList");
		
		return rboardList;
		
	}
	
	public void rupdateHit(int no) {
		
		sqlSession.update("rboard.rupdateHit",no);
		
		
		
	}
	
	public RBoardVo rboardSelectOne(int no) {
		
		RBoardVo rboardVo = sqlSession.selectOne("rboard.selectOne", no);
		
		return rboardVo;
		
	}
	
	public void insertrBoard(RBoardVo rboardVo) {
		
		sqlSession.insert("rboard.insertrBoard", rboardVo);
		
		
		
	}
	
	
	

}
