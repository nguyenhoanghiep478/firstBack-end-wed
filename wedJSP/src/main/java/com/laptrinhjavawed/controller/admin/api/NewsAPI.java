package com.laptrinhjavawed.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.service.INewsService;
import com.laptrinhjavawed.utils.HttpUtils;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet{
	private static final long serialVersionUID = 6177916819997376320L;
		@Inject
		private INewsService newsService;
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper= new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			NewsModel newsModel=HttpUtils.of(req.getReader()).toModel(NewsModel.class);
			newsModel=newsService.save(newsModel);
			mapper.writeValue(resp.getOutputStream(), newsModel);
		}
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			NewsModel newsModel=HttpUtils.of(req.getReader()).toModel(NewsModel.class);
			newsService.delete(newsModel.getIds());
			mapper.writeValue(resp.getOutputStream(), "{}");
		}
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			NewsModel newsModel=HttpUtils.of(req.getReader()).toModel(NewsModel.class);
			newsModel=newsService.update(newsModel);
			mapper.writeValue(resp.getOutputStream(), newsModel);
		}
}
