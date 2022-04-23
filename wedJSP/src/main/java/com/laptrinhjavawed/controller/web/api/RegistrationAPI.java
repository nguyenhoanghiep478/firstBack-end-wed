package com.laptrinhjavawed.controller.web.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;
import com.laptrinhjavawed.utils.HttpUtils;
@WebServlet(urlPatterns = {"/api-user-checking"})
public class RegistrationAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		UserModel userModel= HttpUtils.of(req.getReader()).toModel(UserModel.class);
		PrintWriter out= resp.getWriter();
		if(userService.findOneByUserName(userModel.getUserName())!=null) {
				out.print("<span style=\"color:red;\">Username unavailable</span>");
		}else {
			out.print("<span style=\"color:green;\">Username available</span>");
		}
			
	}
}
