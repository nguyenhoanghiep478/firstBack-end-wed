 package com.laptrinhjavawed.controller.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.constant.SystemConstant;
import com.laptrinhjavawed.model.CommentModel;
import com.laptrinhjavawed.model.NewsModel;
import com.laptrinhjavawed.model.UserModel;
import com.laptrinhjavawed.service.ICommentService;
import com.laptrinhjavawed.service.INewsService;
import com.laptrinhjavawed.service.IUserService;
import com.laptrinhjavawed.utils.FormUtils;
import com.laptrinhjavawed.utils.SessionUtils;
@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat","/dang-ky","/bang-tin"})
public class HomeController extends HttpServlet{
	@Inject
	private INewsService newsService;
	private static final long serialVersionUID = 1L;
	ResourceBundle rb= ResourceBundle.getBundle("message");
	@Inject
	private IUserService userService;
	@Inject
	private ICommentService commentService;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException, ServletException{
		String action=request.getParameter("action");
		String view=null;
		if(action!=null) {
			String message=request.getParameter("message");
			String alert=request.getParameter("alert");
			if(message!=null && alert != null) {
				request.setAttribute("message", rb.getString(message));
				request.setAttribute("alert", alert);
			}
			if(action.equals("login")) {
				view="/view/login.jsp";
			}else if(action.equals("registration")) {
				view="/view/registration/registration.jsp";
			}
			else if(action.equals("logout")) {
				SessionUtils.getInstance().removeValue(request,"USERMODEL");
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}	
		}else {
			NewsModel newsModel= new NewsModel();
			CommentModel commentModel=new CommentModel();
			List<CommentModel> listComment=new ArrayList<CommentModel>();
			UserModel userModel=(UserModel)SessionUtils.getInstance().getValue(request, "USERMODEL");
			if( userModel!=null) {
				URL url=new URL("http://localhost:8080/wedJSP/trang-chu");
				ServerSocket serverSocket= new ServerSocket(url.getPort());
				Socket socket=serverSocket.accept();
				if(socket.isConnected()) {
					System.out.println("client connected");
				}
				newsModel.setListResult(newsService.findByUserName(userModel.getUserName()));
				for (NewsModel newsModels  : newsModel.getListResult()) {
					listComment.addAll(commentService.findByNewsId(newsModels.getId()));
				}
				commentModel.setListResult(listComment);
				request.setAttribute(SystemConstant.NEWSMODEL, newsModel);
				request.setAttribute(SystemConstant.USERMODEL, userModel);
				request.setAttribute(SystemConstant.COMMENTMODEL, commentModel);
				view="/view/newsfeed.jsp";
			}else {
				view="view/wed/home.jsp";
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		String action=request.getParameter("action");
		if(action!=null&&action.equals("login")) {
			UserModel userModel=FormUtils.toModel(UserModel.class, request);
			userModel=userService.findByUserNameAndPassWordAndStatus(userModel.getUserName(), userModel.getPassword(),1);
			if(userModel!=null) {
				SessionUtils.getInstance().putValue(request,"USERMODEL", userModel);
				if(userModel.getRole().getCode().equals("user")) {
					response.sendRedirect(request.getContextPath()+"/bang-tin");
				}else if(userModel.getRole().getCode().equals("admin")) {
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			}
			else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=usernameorpassword_invalid&alert=danger");
			}
		}else if(action!=null && action.equals("registration")) {
			UserModel userModel= FormUtils.toModel(UserModel.class, request);
			if(userService.findOneByUserName(userModel.getUserName())!=null) {
				response.sendRedirect(request.getContextPath()+"/dang-ky?action=registration&message=usernameisexist&alert=warning&isExist=");
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-ky?action=registration&message=usernameisexist&alert=warning&isExist=false");
			}
		}
	}
}
