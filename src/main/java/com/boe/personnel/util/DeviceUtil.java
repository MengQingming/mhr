package com.boe.personnel.util;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

public class DeviceUtil {
	
	/**
	 * 计算卡路里
	 * @param bushu
	 * @param bufu
	 * @param weight
	 * @return
	 */
	public static double getKcal(int bushu,int bufu,int weight) {
		int steplength = 0;
		if(bufu==0){
			steplength = 60;
		}else{
			steplength = bufu;
		}
		System.out.println("步数=["+bushu+"],步幅=["+bufu+"],体重=["+bufu+"],");
        return bushu*steplength*weight*7.08*0.000001;    //6.530
	}
	
	/**
	 * 睡眠质量
	 * @param EffectiveTime
	 * @return
	 */
	public static String getSleepMass(String effectiveTime){
		if(false == effectiveTime.isEmpty()){
		double masstime  =   Double.valueOf(effectiveTime);
		if(masstime>6.5){
			return "睡眠质量高";
		}else if(masstime>5&&masstime<=6.5){
			return "睡眠质量中等";
		}else if(masstime>3&&masstime<=5){
			return "睡眠质量差";
		}else if(masstime>0&&masstime<=3){
			return "睡眠质量极差";
		}
		}
		return "未佩戴";
	}
	
	/**
	 * 计算行走距离
	 * @param bushu
	 * @param bufu
	 * @return
	 */
	public static String getDistance(int bushu,int bufu){
		int steplength = 0;
		if(bufu==0){
			steplength = 60;
		}else{
			steplength = bufu;
		}
		DecimalFormat df=new DecimalFormat("0.00");
		return df.format(bushu*steplength*0.01*0.001);
	}
	
	public static String emptyParseDouble(String str){
		if("".equals(StringUtils.trimToEmpty(str)) || "null".equals(str)){
			return "0.0";
		}
		return str;
	}
}
