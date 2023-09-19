package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//리스트
	@RequestMapping(value="/board/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		//boardService를 통해서 리스트를 가져온다
		List<BoardVo> boardList = boardService.getBoardList();	
		
		
		//모델에 리스트를 담는다(포워드)
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
		
	
	//글읽기
	@RequestMapping(value="board/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value="no") int no, Model model) {
		System.out.println("BoardController.read()");
		
		
		//글1개가져오기
		BoardVo boardVo = boardService.getBoard(no);
		
		//화면에 보내기(포워딩)
		model.addAttribute("boardVo", boardVo);
		
		return "board/read";
	}
	
	@RequestMapping(value="board/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("BoardController.writeForm()");
		
		
		
		
		return "board/writeForm";
	}
	
	
	
	@RequestMapping(value="board/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		
		System.out.println("BoardController.write()");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		boardVo.setUserNo(authUser.getNo());
		System.out.println(boardVo);
		
		
		boardService.insertBoard(boardVo);
		
		
		
		
		
		
		return "redirect:list";
	}
	
	
	@RequestMapping(value="board/modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		
		System.out.println("BoardController.modifyForm()");
		
		BoardVo boardVo = boardService.getBoard(no);
		
		//화면에 보내기(포워딩)
		model.addAttribute("boardVo", boardVo);
		
		
		return "board/modifyForm";
	}
	
	
	@RequestMapping(value="board/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@RequestParam(value="no") int no, @ModelAttribute BoardVo boardVo) {
		
		System.out.println("BoardController.modify()");
		
		
		boardService.updateBoard(boardVo);
		
		no = boardVo.getNo();
		return "redirect:read?no=" + no;
		
		
	}
	
	
	
		
	}

