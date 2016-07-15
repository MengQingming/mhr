package com.boe.personnel.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import weibo4j.http.BASE64Encoder;



public class ssss {
	/*public static void main(String[] args) throws MalformedURLException,  
    IOException, URISyntaxException, AWTException {  
//此方法仅适用于JdK1.6及以上版本  
Desktop.getDesktop().browse(  
        new URL("http://image.baidu.com/").toURI());  
Robot robot = new Robot();  
robot.delay(10000);  
Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());  
int width = (int) d.getWidth();  
int height = (int) d.getHeight();  
//最大化浏览器  
robot.keyRelease(KeyEvent.VK_F11);  
robot.delay(2000);  
Image image = robot.createScreenCapture(new Rectangle(0, 0, width,  
        height));  
BufferedImage bi = new BufferedImage(width, height,  
        BufferedImage.TYPE_INT_RGB);  
Graphics g = bi.createGraphics();  
g.drawImage(image, 0, 0, width, height, null);  
//保存图片  
System.out.println(new File("google.jpg").getAbsolutePath());
ImageIO.write(bi, "jpg", new File("google.jpg"));  
} */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Hmac加密
//		String data = "我的明文测试信息";
//		String key = "12345678901234567890123456789012";//32位密钥，从app信息中获取
//
//		byte[] bytes = encryptHMAC(data.getBytes("UTF-8"), key);
//		System.out.println(bytes);
//		BASE64Encoder be= new BASE64Encoder();
//		System.out.println(be.encode(bytes));//作为sign的密文内容
		
		String activityPhotoPath = SystemVariableUtils.getProperty("activity.images.dir", "");
		System.out.println(activityPhotoPath);
		String url = ssss.class.getClassLoader().getSystemResource(activityPhotoPath).getPath();
		System.out.println(url);
		
	}

	public static final String KEY_MAC = "HmacSHA256";

	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
		SecretKey sk = new SecretKeySpec(key.getBytes("UTF-8"), KEY_MAC);
		Mac mac = Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}

}
