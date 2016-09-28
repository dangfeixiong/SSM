package com.ziroom.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandleInterceptor1 implements HandlerInterceptor{

	//在执行handler之前来执行的
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//System.out.println("HandleInterceptor1 preHandle...");
		StringBuffer url = request.getRequestURL();//访问url
		String queryString = request.getQueryString();//url中参数
		System.out.println("访问url为:" + url.toString());
		System.out.println("url参数为:" + queryString);
		return true;
	}

	//在执行handler返回modelAndView之前来执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandleInterceptor1 postHandle...");
		
	}

	//执行handler之后执行此方法
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("HandleInterceptor1 afterCompletion...");
		System.out.println("相应数据为:" + response.getWriter());
		
	}

}
