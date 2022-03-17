package com.laptrinhjavawed.controller.admin;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns ={"/admin-home"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException, ServletException{
		RequestDispatcher rd= request.getRequestDispatcher("/view/admin/home.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		
	}
}
