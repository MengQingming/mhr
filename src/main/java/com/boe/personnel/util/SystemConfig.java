package com.boe.personnel.util;

/**
 * 类名: SystemConfig 
 * 作用: 读取资源文件 
 * 作者: MengQingming 
 * 日期: 2016-7-15 14:37:10 
 * 版本: V 1.0
 *
 */
public class SystemConfig {
	
	public SystemConfig() {
	}
	
	public SystemConfig(String configName){
		this.configName = configName;
	}
	
	/** 配置文件keyval.properties **/
	public String configName = "systemConfig";
	
	/**配置绑定**/
	private ConfigHandler configHandler = null;
	
	/**
	 * 获取资源文件实例
	 * @return ConfigHandler
	 */
	public ConfigHandler getConfigHandler() {
		configHandler = new ConfigHandler();
		configHandler.setConfigFile(configName);
		return configHandler;
	}
	
	/**
	 * 根据key值获取配置
	 * @return String
	 */
	public String getProperty(String proterty){
		try {
			String str = getConfigHandler().getProperty(proterty);
			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		SystemConfig systemConfig = new SystemConfig();
		String ctoMeetingAccoutPwd = systemConfig.getProperty("boe.meeting.accoutpwd_94");
		if(ctoMeetingAccoutPwd != null){
			
			System.out.println(ctoMeetingAccoutPwd);
		}
		
		
	}
	
}
