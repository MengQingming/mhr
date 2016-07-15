package com.boe.personnel.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 类 名: ConfigHandler
 * <br/>描 述: 资源文件的读取
 * <br/>作 者: MengQingming
 * <br/>创 建： 2016-07-15
 *
 * <br/>历 史: 无
 */
public class ConfigHandler {
	
	/**文件名**/
	private String configFile = "systemConfig";
	
	/**配置绑定**/
	private ResourceBundle configBundle = null;

	/**
	 * @return tag 
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * @param configFile 
	 */
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	/**
	 * 读取资源文件
	 * @return tag 
	 */
	public ResourceBundle getConfigBundle(){
		if(configBundle==null){
			configBundle = ResourceBundle.getBundle(configFile);
		}
		return configBundle;
	}
	
	/**
	 * 根据key值获取配置
	 * @param propertyName 资源文件的key
	 * @return 配置值
	 */
	public String getProperty(String propertyName) throws Exception{
		return getConfigBundle().getString(propertyName);
	}
	
	/**
	 * 获取带参数的属性值 
	 * @param propertyName 资源文件的key
	 * @param params 参数值
	 * @return 替换参数后的配置值
	 * @throws Exception 
	 */
	public String getProperty(String propertyName, String[] params) throws Exception {
		MessageFormat messgeFormat = new MessageFormat(this.getProperty(propertyName));  
		return messgeFormat.format(params);
	}
}
