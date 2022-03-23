package com.laptrinhjavawed.controller.admin;

import java.io.IOException;
import java.rmi.ServerException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.Pageble.Pageble;
import com.laptrinhjavawed.Pageble.impl.PageRequest;
import com.laptrinhjavawed.constant.SystemConstant;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.service.INewsService;
import com.laptrinhjavawed.sort.Sorter;
import com.laptrinhjavawed.utils.FormUtils;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	@Inject
	INewsService news;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {
		NewsModel newsModel = FormUtils.toModel(NewsModel.class, request);
		Pageble pageble=new PageRequest(newsModel.getPage(), newsModel.getMaxPageItems(), new Sorter(newsModel.getSortName(), newsModel.getSortBy()));
		newsModel.setListResult(news.findAll(pageble));
		newsModel.setTotalItem(news.getTotalItem());
		newsModel.setTotalPages((int) Math.ceil((double)  newsModel.getTotalItem()/pageble.getLimit()));
		request.setAttribute(SystemConstant.MODEL, newsModel);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/new/list.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}
}
