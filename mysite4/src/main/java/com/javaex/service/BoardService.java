package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardDao boardDao;
	
	
	//게시판 리스트 가져오기
	public List<BoardVo> getBoardList(String word){
		System.out.println("BoardService.getBoardList()");
		
		List<BoardVo> boardList = boardDao.boardSelectList(word);
		
		return boardList;
		
	}
	
	public BoardVo getBoard(int no) {
	
		
		System.out.println("BoardService.getBoard()");
		
		//글읽기 비즈니스로직
		
		//조회수 증가
		boardDao.updateHit(no);
		
		//글1개 가져오기
		BoardVo boardVo = boardDao.boardSelectOne(no);
		
		return boardVo;
	}
	
	public void insertBoard(BoardVo boardVo) {
		
		boardDao.insertBoard(boardVo);
		
		
		
	}
	
	public void updateBoard(BoardVo boardVo) {
		
		boardDao.updateBoard(boardVo);
		
		
		
	}
	
	public void deleteBoard(int no) {
		
		boardDao.deleteBoard(no);
		
		
		
	}
	
	public List<BoardVo> searchList(String word){
		System.out.println("BoardService.getBoardList()");
		
		List<BoardVo> boardList = boardDao.searchList(word);
		
		return boardList;
		
	}
	
	
	


}
