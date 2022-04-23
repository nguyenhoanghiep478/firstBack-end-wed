package com.laptrinhjavawed.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.Pageble.impl.PageRequest;
import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.IUserService;
import com.laptrinhjavawed.sort.Sorter;
import com.laptrinhjavawed.utils.FormUtils;
@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel userModel= FormUtils.toModel(UserModel.class, req);
		Pageble pageble= new PageRequest(userModel.getPage(),userModel.getMaxPageItems(),new Sorter(userModel.getSortName(), userModel.getSortBy()));
		userModel.setListResult(userService.findAll(pageble));
		userModel.setTotalItem(userService.getTotalItem());
		userModel.setTotalPages((int) Math.ceil((double) userModel.getTotalItem()/pageble.getLimit()));
		req.setAttribute("model", userModel);
		RequestDispatcher rd= req.getRequestDispatcher("/view/admin/user/user.jsp");
		rd.forward(req, resp);
	}
}
