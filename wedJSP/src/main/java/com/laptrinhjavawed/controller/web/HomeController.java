 package com.laptrinhjavawed.controller.web;

import java.io.IOException;
import java.rmi.ServerException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.CategoryModel;
import com.laptrinhjavawed.service.impl.CategoryService;
import com.laptrinhjavawed.service.impl.CommentService;
import com.laptrinhjavawed.service.impl.NewsService;
import com.laptrinhjavawed.service.impl.RoleService;
import com.laptrinhjavawed.service.impl.UserService;
@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private CategoryService categoryService;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException, ServletException{
		CategoryModel category=new CategoryModel();
		category.setId(5L);
		category.setName("chính trị");
		category.setCode("chinh-tri");
		request.setAttribute("categories", categoryService.save(category));
//		request.setAttribute("news", newsService.findAll());
//		request.setAttribute("comments", commentService.findAll());
//		request.setAttribute("roles", roleService.findAll());
//		request.setAttribute("users", userService.findAll());
		RequestDispatcher rd=request.getRequestDispatcher("/view/wed/home.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
	}
}
