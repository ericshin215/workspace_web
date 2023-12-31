package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	  
	  
	 
	 
	  
	  return "blog/blog-main"; 
	  }
	  
	// 블로그 기본설정 /////////////////////////////////////////////////
		@RequestMapping("/{id}/admin/basic")
		public String basic(@PathVariable("id") String id, Model model) {
			System.out.println("블로그 기본설정");
			BlogVo blogVo = blogService.selectBlog(id);
			model.addAttribute("blogVo", blogVo);
			return "blog/admin/blog-admin-basic";
		}

		// 블로그 대문명, 사진 변경하기
		@RequestMapping(value = "/{id}/admin/basic/update", method = { RequestMethod.GET, RequestMethod.POST })
		public String update(@RequestParam(value = "blogTitle") String blogTitle, HttpSession session) {
			System.out.println("블로그 업데이트");
			UserVo authUser = (UserVo) session.getAttribute("authUser");
			BlogVo blogVo = new BlogVo(authUser.getId(), authUser.getUserName(), blogTitle);
			blogService.blogUpdate(blogVo);
			return "redirect:/{id}/admin/basic";
		}
	 

}
