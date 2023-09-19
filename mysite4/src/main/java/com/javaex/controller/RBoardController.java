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

import com.javaex.service.RBoardService;
import com.javaex.vo.RBoardVo;
import com.javaex.vo.UserVo;


@Controller
public class RBoardController {
	
	@Autowired
	private RBoardService rboardService;
	
	//리스트
	@RequestMapping(value="/rboard/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("RBoardController.list()");
		
		//boardService를 통해서 리스트를 가져온다
		List<RBoardVo> rboardList = rboardService.getRBoardList();	
		
		
		//모델에 리스트를 담는다(포워드)
		model.addAttribute("rboardList", rboardList);
		
		return "rboard/list";
	}
		
	
	//글읽기
	@RequestMapping(value="rboard/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value="no") int no, Model model) {
		System.out.println("RBoardController.read()");
		
		
		//글1개가져오기
		RBoardVo rboardVo = rboardService.getRBoard(no);
		
		//화면에 보내기(포워딩)
		model.addAttribute("rboardVo", rboardVo);
		
		return "rboard/read";
	}
	
	@RequestMapping(value="rboard/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("RBoardController.writeForm()");
		
		
		
		
		return "rboard/writeForm";
	}
//	
//	
//	
	@RequestMapping(value="rboard/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute RBoardVo rboardVo, HttpSession session) {
		
		System.out.println(rboardVo);
		System.out.println("RBoardController.write()");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		rboardVo.setUserNo(authUser.getNo());
		
		
		
		rboardService.insertrBoard(rboardVo);
		
		
		
		
		
		
		return "redirect:list";
	}
//	
//	
//	@RequestMapping(value="board/modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
//	public String modifyForm(@RequestParam(value="no") int no, Model model) {
//		
//		System.out.println("BoardController.modifyForm()");
//		
//		BoardVo boardVo = boardService.getBoard(no);
//		
//		//화면에 보내기(포워딩)
//		model.addAttribute("boardVo", boardVo);
//		
//		
//		return "board/modifyForm";
//	}
//	
//	
//	@RequestMapping(value="board/modify", method= {RequestMethod.GET, RequestMethod.POST})
//	public String modify(@RequestParam(value="no") int no, @ModelAttribute BoardVo boardVo) {
//		
//		System.out.println("BoardController.modify()");
//		
//		
//		boardService.updateBoard(boardVo);
//		
//		no = boardVo.getNo();
//		return "redirect:read?no=" + no;
//		
//		
//	}
//	
//	@RequestMapping(value="board/delete", method= {RequestMethod.GET, RequestMethod.POST})
//	public String delete(@RequestParam(value="no") int no) {
//		
//		System.out.println("BoardController.delete()");
//		
//		
//		boardService.deleteBoard(no);
//		
//		return "redirect:list";
//		
//		
//	}
//	
//	
//	@RequestMapping(value="board/search", method= {RequestMethod.GET, RequestMethod.POST})
//	public String search(@RequestParam(value="word") String word, Model model) {
//		
//		System.out.println("BoardController.search()");
//		
//		
//		List<BoardVo> boardList = boardService.searchList(word);
//		
//		model.addAttribute("boardList", boardList);
//		
//		return "board/list";
//		
//		
//	}
//	
//	
	

	}
