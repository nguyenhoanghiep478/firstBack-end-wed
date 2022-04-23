package com.laptrinhjavawed.controller.web.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.model.CommentModel;
import com.laptrinhjavawed.service.ICommentService;
import com.laptrinhjavawed.utils.HttpUtils;
@WebServlet(urlPatterns = {"/api-comment"})
public class CommentAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private ICommentService commentService;
	
	@SuppressWarnings({ "resource", "unused" })
	@Override
	protected void  doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		ServerSocket serverSocket= new ServerSocket(8080);
		Socket socket=serverSocket.accept();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentService.save(commentModel);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentService.update(commentModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel commentModel=HttpUtils.of(req.getReader()).toModel(CommentModel.class);
		commentService.delete(commentModel.getIds());
	}

}
