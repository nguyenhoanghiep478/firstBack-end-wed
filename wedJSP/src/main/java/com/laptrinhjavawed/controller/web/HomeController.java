 package com.laptrinhjavawed.controller.web;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;
import com.laptrinhjavawed.utils.FormUtils;
import com.laptrinhjavawed.utils.SessionUtils;
@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ResourceBundle rb= ResourceBundle.getBundle("message");
	@Inject
	private IUserService userService;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException, ServletException{
		String action=request.getParameter("action");
		if(action!=null) {
			String message=request.getParameter("message");
			String alert=request.getParameter("alert");
			if(message!=null && alert != null) {
				request.setAttribute("message", rb.getString(message));
				request.setAttribute("alert", alert);
			}
			if(action.equals("login")) {
				RequestDispatcher rd=request.getRequestDispatcher("/view/login.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("logout")) {
				SessionUtils.getInstance().removeValue(request,"USERMODEL");
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}	
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/view/wed/home.jsp");
			rd.forward(request, response);			
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		String action=request.getParameter("action");
		if(action!=null&&action.equals("login")) {
			UserModel model=FormUtils.toModel(UserModel.class, request);
			model=userService.findByUserNameAndPassWordAndStatus(model.getUserName(), model.getPassword(),1);
			if(model!=null) {
				SessionUtils.getInstance().putValue(request,"USERMODEL", model);
				if(model.getRole().getCode().equals("user")) {
					response.sendRedirect(request.getContextPath()+"/trang-chu");
				}else if(model.getRole().getCode().equals("admin")) {
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=usernameorpassword_invalid&alert=danger");
			}
		}
	}
}
