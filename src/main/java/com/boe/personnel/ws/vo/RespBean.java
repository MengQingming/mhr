package com.boe.personnel.ws.vo;

import java.io.Serializable;

import com.boe.personnel.common.Constants;


/**
 * 服务器响应信息
 * @author MengQingming
 * @date 2016-07-06
 */
public class RespBean implements Serializable {

	private static final long serialVersionUID = 8278825888167581879L;

	private int code = Constants.RES_SECCESS_CODE;  //响应状态码    -1:系统异常，  0:参数错误 ，  1：正常 ，  2：登录认证过期
	
	private boolean success = true; 	//响应标识
	
	private String msg = ""; 			//返回信息
	
	private Object data;  				//返回信息数据实体
	
	private String token;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
