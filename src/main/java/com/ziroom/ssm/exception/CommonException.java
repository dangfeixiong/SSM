package com.ziroom.ssm.exception;

/**
 * 
 * @ClassName CommonException
 * @Description 局异常处理类
 * @author dfx
 * @date 2016年6月19日 上午10:26:58
 * 
 */
public class CommonException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommonException(String message) {
		super();
		this.message = message;
	}

}
