package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

//	@Autowired
//	public BlogService blogService;

	
	  @RequestMapping(value = "/{id}", method = { RequestMethod.GET,RequestMethod.POST }) 
	  public String showBlog(@PathVariable (value="id") String id, Model model) {
	  
		  
	  model.addAttribute("id", id);
	  System.out.println("blog()");
	  
	 
	  
	  return "blog/blog-main"; }
	 

}
