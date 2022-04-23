package com.laptrinhjavawed.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;
import com.laptrinhjavawed.utils.HttpUtils;
@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel= HttpUtils.of(req.getReader()).toModel(UserModel.class);
		userService.save(userModel);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserModel userModel= HttpUtils.of(req.getReader()).toModel(UserModel.class);
		userModel=userService.update(userModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
