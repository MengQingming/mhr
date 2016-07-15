package com.boe.personnel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 常量类 
 */
public class Const {
	
	/** 我的心声图片目录路径 */
	public static String FEEDBACK_PICTURE_PATH;
	
	private static Logger log = Logger.getLogger(Const.class);
	
	public static void main(String[] args) {
		System.out.println(FEEDBACK_PICTURE_PATH);
	}
	
	static{
		String configFile = "systemConfig.properties";
		try {
			Properties pro = new Properties();
			InputStream is = Const.class.getResourceAsStream("/"+configFile);
			pro.load(is);
			FEEDBACK_PICTURE_PATH = pro.getProperty("boe.mhr.feedback.picture.path");
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			log.error("读取"+configFile+"文件出现错误!");
			System.exit(1);
		}
	}
	
	/**
	 * 当前登录的用户
	 */
	String CURRENT_USER = "userBase";
	
	/**
	 * 活动报名信息提示
	 */
	String[] activityMsg = new String[] { "你已经报名了该活动", "报名活动成功", "当前活动不存在" };
	
	/**
	 * 申请顾问信息提示
	 */
	String[] applyMsg = new String[]{"您已经申请过此顾问，不可重复申请！", "您已成功提交申请，请等待此顾问批准申请！", "普通用户最多只能申请四位顾问！", "申请失败", "您已成功取消申请！", "该医师已经是您的顾问了", "集团用户至多只能申请一位顾问"};
	/**
	 * 错误key
	 */
	String ERROR = "error";
	/**
	 * 图片类型
	 */
	String[] IMAGEBLETYPE = new String[]{"generalInfo"};
	
	/**
	 * 评论类型
	 */
	String[] COMMONTYPE = new String[]{"activity", "enterprise", "generalinfo"};
	
	int SMS_SEND_SUCCEED = 0;
	int SMS_SEND_FAIL = 1;
	
	/**
	 * 存放访问环信的返回token信息
	 * {"access_token":"YWMtrRTTQnbGEeSNx33BLOZJtgAAAUsqDI2i50nRdkoy1DpszJwHCuzKfW6ypuA","expires_in":5184000,"application":"8a5c2ef0-6e00-11e4-a582-b5f52534fd80"}
	 */
	public static Map<String, Object> EASEMOB_ACCESS = new HashMap<String, Object>(0);
	
	/**厂商授权key**/
	public static Map<String, String> DEVICE_KEY_MAP = new HashMap<String, String>(){{
		put("8D143C538F8D4DE7", "1");
		put("561A1F8646FD4C46", "1");
		put("92C61CF12F0B43E4", "1");
		put("154550011744484D", "1");
		put("E6581CA5640C4FCA", "1");
	}};
	
}
