package com.boe.personnel.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boe.personnel.entity.UserBase;
import com.boe.personnel.service.IUserBaseService;


/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 */
@Controller
@RequestMapping(value="/service/app")
public class LoginController {
	
	@Autowired
	private IUserBaseService userBaseService;
	
	@Autowired  
	private HttpSession session;
	
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/user/login", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public UserBase login(@RequestParam(value="account",required=false) String account, 
			@RequestParam(value="token",required=false) String token,
			Model model, 
			HttpServletRequest req, RedirectAttributes redirectAttributes) {
		
		UserBase userBase = new UserBase();
		
		userBase = (UserBase) req.getSession().getAttribute(token);
		
		//List<UserBase> list = userBaseService.selectUserLogin(userBase);
		
		return userBase;
		
	}
	
}
