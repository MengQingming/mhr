package com.boe.personnel.ws.impl;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.boe.personnel.common.Constants;
import com.boe.personnel.entity.UserBase;
import com.boe.personnel.service.IUserBaseService;
import com.boe.personnel.util.DateUtils;
import com.boe.personnel.util.MD5;
import com.boe.personnel.ws.vo.Module;
import com.boe.personnel.ws.vo.RespBean;

@Path("/app")
public class RESTWebserviceImpl {
	
	private Logger log = Logger.getLogger(RESTWebserviceImpl.class);
	
	@Autowired  
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request; 
	
	@Autowired
	private IUserBaseService userBaseService;
	
	
	@POST
	@Produces("application/json")
	@Path("/user/query_login_user")
	public RespBean queryLoginUser(@FormParam(value = "token") String token) {
		
		RespBean respBean = new RespBean();
		respBean.setSuccess(false);
		
		if(StringUtils.isEmpty(StringUtils.trim(token))){
			respBean.setCode(Constants.RES_PARAM_ERROR_CODE);
			respBean.setMsg("认证密钥不能为空!");
			log.error("/user/query_login_user==>token is null");
			return respBean;
		}
		
		UserBase userBase = (UserBase) this.session.getAttribute(token);
		
		if(userBase != null){
			respBean.setCode(Constants.RES_SECCESS_CODE);
			respBean.setSuccess(true);
			respBean.setToken(token);
			respBean.setMsg("用户已登录");
			respBean.setData(userBase);
		}else{
			respBean.setCode(Constants.RES_LOGIN_ERROR_CODE);
			respBean.setMsg("用户未登录");
		}
		
		return respBean;
	}
	
	/**
	 * 用户登录
	 * @date 2016-07-14
	 * @param account
	 * @param password
	 * @return
	 */
	@POST
	@Produces("application/json")
	@Path("/user/login")
	public RespBean login(
			@FormParam(value = "account") String account, 
			@FormParam(value = "password") String password
					) {
		//设置session失效时间   30分钟
		this.session.setMaxInactiveInterval(30*60);
		
		RespBean respBean = new RespBean();
		respBean.setSuccess(false);
		
		if(StringUtils.isEmpty(StringUtils.trim(account))){
			respBean.setCode(Constants.RES_PARAM_ERROR_CODE);
			respBean.setMsg("用户名不能为空!");
			log.error("/user/login==>account is null");
			return respBean;
		}
		
		if(StringUtils.isEmpty(StringUtils.trim(password))){
			respBean.setCode(Constants.RES_PARAM_ERROR_CODE);
			respBean.setMsg("密码不能为空!");
			log.error("/user/login==>password is null");
			return respBean;
		}
		
		//...
		//portal登录账号验证，  调用portal登录认证接口
		
		
		//...
		//规则判断是否为作业员
		Module module = new Module();
		module.setWages(true);
		
		
		
		UserBase userBase = new UserBase();
		//...
		userBase.setAccount(account);
		//查询用户
		List<UserBase> list = userBaseService.selectUserLogin(userBase);
		
		if(CollectionUtils.isNotEmpty(list)){
			//生成 token
			String uuid = UUID.randomUUID().toString();
			String token = MD5.digest(account+uuid);
			log.info("/user/login==>account:"+account+",uuid:"+uuid+",token:"+token);
			
			userBase = list.get(0);
			this.session.setAttribute(token, userBase);
			
			respBean.setCode(Constants.RES_SECCESS_CODE);
			respBean.setSuccess(true);
			respBean.setMsg("登录成功");
			respBean.setToken(token);
			//...
			//设置参数
			respBean.setData(userBase);
		}else{
			respBean.setCode(Constants.RES_LOGIN_ERROR_CODE);
			respBean.setSuccess(false);
			respBean.setMsg("此用户不存在，请联系管理员!");
		}
		
		return respBean;
	}
	
	
	/**
	 * 问题咨询
	 * @return
	 */
	@GET
	@Produces("application/json")
	@Path("/user/issue_consult")
	public RespBean issueConsult() {
		
		RespBean respBean = new RespBean();
		
		String toTen = request.getParameter("toTen");
		
		if(StringUtils.isEmpty(StringUtils.trim(toTen))){
			respBean.setSuccess(false);
			respBean.setCode(Constants.RES_LOGIN_ERROR_CODE);
			respBean.setMsg("登录过期，请您重新登录");
			respBean.setData(null);
			return respBean;
		}
		
		return respBean;
	}
	
	
}
