package com.laptrinhjavawed.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavawed.constant.SystemConstant;
import com.laptrinhjavawed.model.UserModel;

public class AuthorizationFilter implements Filter {
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context=filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		String url=request.getRequestURI();
		if(url.startsWith("/admin")) {
			UserModel model= (UserModel) request.getAttribute("USERMODEL");
			if(model!=null) {
					if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
						filterChain.doFilter(servletRequest, servletResponse);
					}else if(model.getRole().getCode().equals(SystemConstant.USER)) {
						response.sendRedirect("/trang-chu?action=login&message=not_permission&alert=danger");
					}
			}else {
				response.sendRedirect("/trang-chu?action=login&message=not_login&alert=danger");
			}
		}else {
			filterChain.doFilter(servletRequest,servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
