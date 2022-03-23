package com.laptrinhjavawed.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavawed.model.CommentModel;
import com.laptrinhjavawed.service.ICommentService;
import com.laptrinhjavawed.utils.HttpUtils;
@WebServlet(urlPatterns = {"/api-admin-comment"})
public class CommentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	ICommentService commentService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentModel=commentService.save(commentModel);
		mapper.writeValue(resp.getOutputStream(), commentModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentService.delete(commentModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentModel=commentService.update(commentModel);
		mapper.writeValue(resp.getOutputStream(), commentModel);
	}
}
