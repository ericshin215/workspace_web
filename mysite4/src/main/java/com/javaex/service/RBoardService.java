package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RBoardDao;

import com.javaex.vo.RBoardVo;

@Service
public class RBoardService {
	
	@Autowired
	private RBoardDao rboardDao;
	
	
	//게시판 리스트 가져오기
	public List<RBoardVo> getRBoardList(){
		System.out.println("RBoardService.getRBoardList()");
		
		List<RBoardVo> rboardList = rboardDao.rboardSelectList();
		
		return rboardList;
		
	}
	
	public RBoardVo getRBoard(int no) {
	
		
		System.out.println("BoardService.getRBoard()");
		
		//글읽기 비즈니스로직
		
		//조회수 증가
		rboardDao.rupdateHit(no);
		
		//글1개 가져오기
		RBoardVo rboardVo = rboardDao.rboardSelectOne(no);
		
		return rboardVo;
	}
	
	public void insertrBoard(RBoardVo rboardVo) {
		
		rboardDao.insertrBoard(rboardVo);
		
		
		
	}
	
//	public void updateBoard(RBoardVo boardVo) {
//		
//		rboardDao.updateBoard(boardVo);
//		
//		
//		
//	}
//	
//	public void deleteBoard(int no) {
//		
//		boardDao.deleteBoard(no);
//		
//		
//		
//	}
//	
//	public List<BoardVo> searchList(String word){
//		System.out.println("BoardService.getBoardList()");
//		
//		List<BoardVo> boardList = boardDao.searchList(word);
//		
//		return boardList;
//		
//	}
	
	
	

}
