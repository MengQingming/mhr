package com.boe.personnel.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.boe.personnel.util.Const;
import com.boe.personnel.util.DateUtils;
import com.boe.personnel.ws.vo.RespBean;

/**
 * 我的心声
 * @author MengQingming
 */
@Controller
@RequestMapping(value="/service/app")
public class FeedbackController {
	
	@Autowired  
	private HttpSession session;
	
	private static Logger log = LoggerFactory.getLogger(FeedbackController.class);

	/**
	 * 我的心声接口 (图+文)
	 * @param problem
	 * @param contactWay
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/sub_feedback", consumes = "multipart/form-data", method = RequestMethod.POST)
	@ResponseBody
	public RespBean login(@RequestParam(value="problem") String problem,
			@RequestParam(value="contactWay") String contactWay,
			HttpServletRequest request) {

		long startTime = System.currentTimeMillis();

		RespBean respBean = new RespBean();
		respBean.setSuccess(true);
		respBean.setMsg("上传成功");
		
		log.info("问题意见problem:"+problem);
		log.info("联系方式contactWay:"+contactWay);
		
		
		String pathname = Const.FEEDBACK_PICTURE_PATH; ;
        File file = new File(pathname);
        if (!file.exists()) {
            file.mkdirs();
        }
        
        MultipartHttpServletRequest muti = (MultipartHttpServletRequest) request;
 
        MultiValueMap<String, MultipartFile> map = muti.getMultiFileMap();
        for (Map.Entry<String, List<MultipartFile>> entry : map.entrySet()) {
 
            List<MultipartFile> list = entry.getValue();
            for (MultipartFile multipartFile : list) {
                try {
                	//图片文件格式  年4月2日2时2分2秒2毫秒3 随机数4
                	String fileName = DateUtils.dateToString(new Date(), "yyyyMMddHHmmssSSS") + (int)(Math.random()*9000+1000);
                	String uploadFileName = multipartFile.getOriginalFilename();
                	String suffix = ".jpg";
                	if(StringUtils.isNotEmpty(uploadFileName) && StringUtils.lastIndexOf(uploadFileName, ".") > 0){
                		suffix = uploadFileName.substring(StringUtils.lastIndexOf(uploadFileName, "."), uploadFileName.length());
                	}else{
                		continue;
                	}
                	String filePath = pathname+"/"+fileName+suffix;
                    multipartFile.transferTo(new File(filePath));
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
		long endTime = System.currentTimeMillis()-startTime;
		log.info("图片上传共用时："+endTime+"ms");
		return respBean;
	}
	
}
