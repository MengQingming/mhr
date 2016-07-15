package com.boe.personnel.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;

/**
 *文件流工具类 
 *
 */
public class StreamUtils {
	private StreamUtils() {
	}

	public static InputSupplier<InputStream> toInputSupplier(final InputStream is) {
	    return new InputSupplier<InputStream>() {
	        @Override
	        public InputStream getInput() throws IOException{
	            return is;
	        }
	    };
	}

	public static String toString(final InputStream is, final Charset cs) throws IOException {
	    return CharStreams.toString(
	            CharStreams.newReaderSupplier(toInputSupplier(is), Charsets.UTF_8));
	}

	public static OutputSupplier<OutputStream> toOutputSupplier(final OutputStream os) {
		return new OutputSupplier<OutputStream>() {
	        @Override
	        public OutputStream getOutput() {
	            return os;
	        }
	    };
	}
	
	/**
	 * 保存文件
	 * @param file
	 * @param req
	 * @param imageDir 虚拟目录
	 * @return
	 */
	public static String saveFile(MultipartFile file,HttpServletRequest req,String imageDir){
		if(file.isEmpty()){
			return "";
		}
		String realPath=req.getSession().getServletContext().getRealPath(imageDir);
		File dir = new File(realPath);
		if(!dir.exists()) dir.mkdirs();
		
		
		String fileExt=Files.getFileExtension(file.getOriginalFilename());
		String fileName= SystemVariableUtils.generateFileName(new Date(), 4)+"."+fileExt;
		try {
			InputSupplier<InputStream> mapSup=StreamUtils.toInputSupplier(file.getInputStream());
			Files.copy(mapSup, new File(realPath+File.separator+fileName));
			return imageDir+"/"+fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 如果传入的新文件非空,就删除旧文件
	 * @param file
	 * @param req
	 * @param image 虚拟路径
	 * @return
	 */
	public static boolean deleteFileIfNewFileExist(MultipartFile file,HttpServletRequest req,String image){
		//新文件不存在,就不删除就旧文件了
		if(file.isEmpty()||StringUtils.isEmpty(image)){
			return true;
		}
		String realPath=req.getSession().getServletContext().getRealPath(image);
		File imageFile=new File(realPath);
		try {
			if(imageFile.exists()){
				imageFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 如果文件非空，重命名旧文件
	 * @param file
	 * @param req
	 * @param image
	 * @return
	 */
	public static boolean renameFeleExist(MultipartFile file,HttpServletRequest request,String image){
		if(file.isEmpty()||StringUtils.isEmpty(image)){
			return true;
		}
		String realPath = request.getSession().getServletContext().getRealPath(image);
		File imageFile = new File(realPath);
		try {
			if(imageFile.exists()){
				imageFile.createNewFile();
			}
			String rootPath = imageFile.getParent();
			String fileExt = Files.getFileExtension(file.getOriginalFilename());
			String fileName= SystemVariableUtils.generateFileName(new Date(), 4)+"."+fileExt;
			
			File newFile = new File(rootPath + File.separator + fileName);
			if (imageFile.renameTo(newFile)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 保存广告图
	 * @param file
	 * @param req
	 * @param imageDir
	 * @return
	 */
	public static String saveAds(MultipartFile file,HttpServletRequest req,String imageDir, String image){
		if(file.isEmpty()){
			return "";
		}
		String realPath = req.getSession().getServletContext().getRealPath(imageDir);
		String filePath = req.getSession().getServletContext().getRealPath(image);
		File dir = new File(realPath);
		File file2 = new File(filePath);
		String fileName = file2.getName();
		if(!dir.exists()) dir.mkdirs();
		try {
			InputSupplier<InputStream> mapSup=StreamUtils.toInputSupplier(file.getInputStream());
			Files.copy(mapSup, new File(realPath+File.separator+fileName));
			return imageDir+"/"+fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * String转换double
	 * @param value
	 * @return 为空返回0
	 */
	public static double stringOfDouble(String value){
		if(null!=value && !value.trim().equals("")){
			return Double.parseDouble(value);
		}else{
			return 0;
		}
	}

	
}

