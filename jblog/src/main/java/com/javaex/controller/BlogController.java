package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	public BlogService blogService;

	
	  @RequestMapping(value = "/{id}", method = { RequestMethod.GET,RequestMethod.POST }) 
	  public String showBlog(@PathVariable (value="id") String id, Model model) {
	  
		  
		BlogVo blogVo = blogService.selectBlog(id);
	  model.addAttribute("blogVo", blogVo);
	  
	  
	  UserVo userVo = blogService.selectBlogHost(id);
	  model.addAttribute("userVo", userVo);
	  System.out.println(blogVo);
	  
	 
	  
	  return "blog/blog-main"; }
	 

}
