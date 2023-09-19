package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<BoardVo> boardSelectList(String word) {
		System.out.println("BoardDao.boardSelecList()");
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList", word);
		
		return boardList;
	}
	
	
	public int updateHit(int no) {
		System.out.println("BoardService.updateHit()");
		System.out.println(no);
		
		int count = sqlSession.update("board.updateHit", no);
		
		
		return count;
		
	}
	
	public BoardVo boardSelectOne(int no) {
		System.out.println("BoardService.boardSelectOne()");
		System.out.println(no);
		
		BoardVo boardVo = sqlSession.selectOne("board.selectOne", no);
		System.out.println(boardVo);
		
		
		return boardVo;
		
		
	}
	public void insertBoard(BoardVo boardVo) {

		sqlSession.insert("board.insertBoard", boardVo);				
		
	}
	
	
	public void updateBoard(BoardVo boardVo) {

		sqlSession.update("board.updateBoard", boardVo);			
		
	}
	
	public void deleteBoard(int no) {
		
		sqlSession.delete("board.deleteBoard", no);
		
	}
	
	public List<BoardVo> searchList(String word) {
		List<BoardVo> boardList = sqlSession.selectList("board.searchList", word);
		
		return boardList;
	}
	

}
