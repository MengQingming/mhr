package com.boe.personnel.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;


/**
 * 短信发送工具类
 * @author sw_qilin
 *
 */
public class SmsMessageSender {

	private static Logger logger = Logger.getLogger(SmsMessageSender.class);
	private static String cpid;
	private static String httpUrl;
	private static String channelid;
	private static String password;
	static {
		cpid = SystemVariableUtils.getProperty("sms.cpid", "");
		httpUrl = SystemVariableUtils.getProperty("sms.url", "");
		channelid = SystemVariableUtils.getProperty("sms.channelid", "");
		password = SystemVariableUtils.getProperty("sms.password", "");
	}
	/**
	 * 
	 * @param telnums 电话号码（多个号码用半角逗号分开，最多500个号码）
	 * @param msg  信息内容(每70个字为1条短信，系统自动拆分，汉字内容请使用gbk格式的urlencode编码形式)
	 * @return
	 */
	public static String sendMsg(String telnums, String msg){
		logger.info("短信号码："+telnums+",短信内容："+msg);
		
		String timestamp = String.valueOf(Math.round(System.currentTimeMillis()/1000l));
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			password += "_"+ timestamp + "_topsky";
		    //加密后的字符串
		    password=MD5(password);
			
		    String content = "cpid="+cpid+"&password="+password+"&channelid="+channelid+"&tele="+telnums+"&msg="+msg+"&timestamp="+timestamp;
		    byte[] temp=content.getBytes("utf-8");//这里写原编码方式
			byte[] newtemp=new String(temp,"utf-8").getBytes("gbk");//这里写转换后的编码方式
			content = new String(newtemp,"gbk");
			
			OutputStream out = urlConnection.getOutputStream();
			out.write(content.getBytes("gbk"));
			out.flush();
			int respCode = urlConnection.getResponseCode();
			String message = urlConnection.getResponseMessage();
			logger.info("响应码："+respCode+",响应信息："+message);
			InputStream in = urlConnection.getInputStream();
			byte[] b = new byte[512];
			int len = -1;
			StringBuffer sb = new StringBuffer();
			while((len = in.read(b))!=-1){
				sb.append(new String(b,0,len));
			}
			urlConnection.disconnect();
			logger.info("服务器处理信息："+sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param telnums  电话号码（多个号码用半角逗号分开，最多500个号码）
	 * @param msg   信息内容(每70个字为1条短信，系统自动拆分，汉字内容请使用gbk格式的urlencode编码形式)
	 * @param delyTime  20130405 10:30:35 
	 * @return
	 */
	@Deprecated
	public String sendMsgDely(String telnums, String msg,String delyTime){
		
		return null;
	}
	
	private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sendMsg("18633480230","sohealth这是什么");
		/* String str="字符串编码转换";
	        try {
	          byte[] temp=str.getBytes("utf-8");//这里写原编码方式
	            byte[] newtemp=new String(temp,"utf-8").getBytes("gbk");//这里写转换后的编码方式
	            String newStr=new String(newtemp,"gbk");//这里写转换后的编码方式
	            System.out.println(newStr);
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }*/
	}

}
