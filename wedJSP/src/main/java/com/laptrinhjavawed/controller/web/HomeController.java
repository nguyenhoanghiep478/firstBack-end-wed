package com.laptrinhjavawed.controller.web;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.UserModel;
@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		UserModel userModel = new UserModel();
		userModel.setFullName("Hello guys");
		request.setAttribute("model", userModel);
		RequestDispatcher rd=request.getRequestDispatcher("/view/wed/home.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		
	}
}
