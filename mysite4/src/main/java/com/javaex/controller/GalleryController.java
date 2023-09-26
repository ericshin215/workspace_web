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
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.UserVo;

@Controller
public class GalleryController {
	
	
	@Autowired
	private GalleryService galleryService;
	
	
	
	
	//리스트
	@RequestMapping(value="/gallery/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list( Model model) {
		System.out.println("GalleryController.list()");
		
		//boardService를 통해서 리스트를 가져온다
		List<GalleryVo> galleryList = galleryService.getGalleryList();	
		
		
		//모델에 리스트를 담는다(포워드)
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	@RequestMapping(value="/gallery/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GalleryVo galleryVo, HttpSession session, @RequestParam(value="file") MultipartFile file, Model model) {
		
		System.out.println("GalleryController.write()");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		galleryService.save(file, authUser.getNo(), galleryVo.getContent(), authUser.getName() );
		
		
		
		
		
		
		System.out.println(galleryVo);
		
		
		
		
		
		
		
		
		return "redirect:list";
	}

}
