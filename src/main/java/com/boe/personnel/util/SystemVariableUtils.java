package com.boe.personnel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springside.modules.utils.PropertiesLoader;

/**
 * 系统变量工具类
 *
 */
@Component
public class SystemVariableUtils {
	
	public static final String PROP_FILE="application.properties";
	public static final String WEIBO_PROP_FILE="weibo.properties";
	private static Random random = new Random();
	/**
	 * 取出Shiro中的当前用户.
	 * @return
	 
	public static ShiroUser getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null && subject.getPrincipal() != null && subject.getPrincipal() instanceof ShiroUser) {
			return (ShiroUser) subject.getPrincipal();
		}
		return null;
	}
	*/
	/**
	 * 取出Shiro中的会话.
	 * @return
	 */
	public static Session getSession(boolean create) {
		Subject subject = SecurityUtils.getSubject();
		Session session=subject.getSession(create);
		return session;
	}
	
	/**
	 * 判断当前会话是否登录
	 * @return
	 */
	public static boolean isAuthenticated() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
	
	/**
	 * 
	 */
	public static String entryptPassword(String password) {
		String entryptPassword = new SimpleHash("MD5", password.toCharArray()).toString();
		return entryptPassword.toUpperCase();
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		PropertiesLoader prop=new PropertiesLoader(PROP_FILE);
		return prop.getProperty(key, defaultValue);
	}
	
	public static String getWeiboProperty(String key, String defaultValue) {
		PropertiesLoader prop=new PropertiesLoader(WEIBO_PROP_FILE);
		return prop.getProperty(key, defaultValue);
	}
	
	/**
	 * 
	 * @return
	 */
	public static String generateFileName(Date date,int num){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String timestamp=sdf.format(date);
		for (int i = 0; i < num; i++) {
			// 取得一个随机字符
			String tmp = getRandomChar();
			timestamp += tmp;
		}
		return timestamp;
	}
	
	public static String getRandomChar() {
		int rand = (int) Math.round(Math.random() * 2);
		long itmp = 0;
		char ctmp = '\u0000';
		// 根据rand的值来决定是生成一个大写字母，小写字母和数字
		switch (rand) {
		// 生成大写字母的情形
		case 1:
			itmp = Math.round(Math.random() * 25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
			// 生成小写字母的情形
		case 2:
			itmp = Math.round(Math.random() * 25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
			// 生成数字的情形
		default:
			itmp = Math.round(Math.random() * 9);
			return String.valueOf(itmp);
		}
	}
	
	/**
	 * 返回随机ID.
	 */
	public static long randomId() {
		return random.nextLong();
	}
	
	/**
	 * 返回短信验证码,6位随机数字.
	 */
	public static String randomSmsCode() {
		StringBuffer sRand=new StringBuffer();  
		for (int i=0;i<6;i++){    
			String rand=String.valueOf(random.nextInt(10));    
			sRand.append(rand);
		}   
		return sRand.toString();
	}
	
	public static Date char2Date(String dateStr) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	/**
	 * 手机接口日期
	 * @param dateStr
	 * @return
	 */
	public static Date char2Date2(String dateStr) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	/**
	 * 将每次请求环信的返回access_token 存放
	 * @date 2014-11-28
	 * @param result
	 */
	public static void updateAccessToken(String result){
		   Const.EASEMOB_ACCESS.clear();  //先清空
		   JSONObject json = JSONObject.fromObject(result);
		   Const.EASEMOB_ACCESS.put("access_token", json.getString("access_token"));
		   Const.EASEMOB_ACCESS.put("expires_in", json.getLong("expires_in"));  //单位为s
		   Const.EASEMOB_ACCESS.put("application", json.getString("application"));
		   long curent = System.currentTimeMillis();
		   Const.EASEMOB_ACCESS.put("current", curent);
		   Const.EASEMOB_ACCESS.put("expirestime", json.getLong("expires_in") * 1000 + curent - 100);   //过期时间
	}
	
	
	
	public static void main(String[] args) {
	System.out.println(char2Date("2014-12-12").toLocaleString());
	}
}
