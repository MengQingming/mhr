package com.boe.personnel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author MengQingming
 *
 */
public class DateUtils{
	
	
	
	/**
	 * 当前日期的前一天按格式转为String
	 * @param format  转换Str格式
	 * @return
	 */
	public static String curBeforeDateStr(String format){
		Date now =new Date();
		Date BefDate = new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		BefDate=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(format); //设置时间格式
		String BefDateStr = sdf.format(BefDate);    //格式化前一天
		return BefDateStr;
	}
	
	/**
	 * 获得日期的前几天的格式转为String
	 */
	public static String BeforeDateStr(String format,int i){
		Date now =new Date();
		Date BefDate = new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, i);
		BefDate=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(format); //设置时间格式
		String BefDateStr = sdf.format(BefDate);    
		return BefDateStr;
	}
	
	
	/**
	 * date转为String
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date, String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
	
	/**
	 * 计算两个date日期的天数
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public static int getBetweenday(Date starttime,Date endtime) throws Exception{
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
		   starttime=sdf.parse(sdf.format(starttime));  
		   endtime=sdf.parse(sdf.format(endtime));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(starttime);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(endtime);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	public static long getTimesByStrFormat(String format,String date) throws ParseException{
	DateFormat t = new SimpleDateFormat(format);
		Date d=t.parse(date);
		return d.getTime();
	}
}