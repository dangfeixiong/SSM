package com.ziroom.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
* @ClassName CommonException 
* @Description 全局异常处理类
* @author dfx
* @date 2016年6月19日 上午10:21:41 
*
 */
public class CommonExceptionResolver implements HandlerExceptionResolver{

	//异常处理方法
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		//异常打印
		ex.printStackTrace();
		//异常赋值
		CommonException commonException = null;
		if(ex instanceof CommonException){
			commonException = (CommonException)ex;
		}else{
			commonException = new CommonException("未知错误[统一提示]");
		}
		//获取异常信息
		String message = ex.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorInfo", message);
		//跳转到统一页面
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
