package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	
	@RequestMapping(value="/fileupload/form",method= {RequestMethod.GET, RequestMethod.POST})
	public String form() {
		System.out.println("FileController.form()");
		
		
		return "gallery/form";
	}
	
	@RequestMapping(value="/fileupload/upload",method= {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam(value="file") MultipartFile file, Model model) {
		System.out.println("FileController.upload()");
		System.out.println(file.getOriginalFilename());
		//System.out.println(file);
		//System.out.println(file.isEmpty()); 파일 선택안하고 업로드 누르면 true 나옴
		
		String saveName = fileService.save(file); //db저장, 서버에 파일복사
		
		model.addAttribute("saveName", saveName);
		return "/gallery/result";
		
	}
	
	

}
