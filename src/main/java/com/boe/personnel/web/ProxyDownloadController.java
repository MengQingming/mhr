package com.boe.personnel.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * (外网)代理下载(内网)文件请求
 * @author MengQingming
 */
@Controller
@RequestMapping(value="/service/app/proxy")
public class ProxyDownloadController {
	
	private static Logger logger = LoggerFactory.getLogger(ProxyDownloadController.class);

	/**
	 * 服务器请求url地址获取文件 (跨服务器)
	 * @param urlPath
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/show_url_file", method = { RequestMethod.GET,RequestMethod.POST })
	public void showUrlFile(String urlPath,
			HttpServletRequest request, HttpServletResponse response) throws Exception {  
		
		if(StringUtils.isEmpty(urlPath)){
			logger.error("文件url地址为空!");
			return;
		}
		
		URL url = new URL(urlPath);
		HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
		httpURL.connect();
		
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        bis = new BufferedInputStream(httpURL.getInputStream());  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
	}
	
	/**
	 * 
	 * @param urlName
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/download_url_file", method = { RequestMethod.GET,RequestMethod.POST })
	public void downloadUrlFile(String urlPath,
			HttpServletRequest request, HttpServletResponse response) throws Exception {  
		
		if(StringUtils.isEmpty(urlPath)){
			logger.error("文件url地址为空!");
			return;
		}
		
		String fileName = "downloadfile";
		
		if(urlPath.indexOf("/") > 0){
			fileName = urlPath.substring(urlPath.lastIndexOf("/")+1, urlPath.length());
		}
		
		URL url = new URL(urlPath);
		HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
		httpURL.connect();
		
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
        response.reset(); response.setContentType("application/octet-stream; charset=utf-8"); 
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        bis = new BufferedInputStream(httpURL.getInputStream());  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
	}
	
}
