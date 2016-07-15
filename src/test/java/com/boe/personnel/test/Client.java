package com.boe.personnel.test;

import java.text.DecimalFormat;

public class Client {  
	  
    public static void main(String[] args) throws Exception {
    	
    	
    	String content = "<p>\r\n\t<img src=\"/upload/images/enterprise/20150302135512834lDK6.jpg\" width=\"93\" height=\"62\" alt=\"\" />\r\n</p>\r\n<p>\r\n\t为了鼓励大家更好的健走，拥有健康的身体和积极的心态，现公布3月份新的“乐走规则”如下：\r\n</p>\r\n<p>\r\n\t1、维持惩罚日步行数低于10000步的最后一名来奖励当日的“健走达人”；\r\n</p>\r\n<p>\r\n\t2、[乐走联盟]的各位同仁每人交30元的备用金，用来奖励这个月每天形成的“幸运之星”，奖金10元。\r\n</p>\r\n<p>\r\n\t幸运之星真够幸运的。<img border=\"0\" alt=\"\" src=\"http://www.17jianzou.com/static/kindeditor-4.1.7/plugins/emoticons/images/79.gif\" /> \r\n</p>";
    	
    	System.out.println(content.replaceAll("http://www.17jianzou.com", "").replaceAll("src=\"", "src=\"http://www.17jianzou.com"));
    	
//    	String createTime = "2015-03-03 15:00:30.0";
//    	System.out.println( (createTime.length() > 19)? createTime.substring(0, 19):createTime );
//    	
//    	String num = new DecimalFormat("#,##0.0").format(new Double(".40000"));
//    	System.out.println("Double :" + num);
//    	System.out.println("Double :" + String.format("%f", new Double(".4")));
    	
//    	String str = "1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17";
//    	int contentLength = str.length();
//    	System.out.println(contentLength);
//    	for (int i = 0; i < Math.ceil(Double.valueOf(contentLength)/Double.valueOf(20)); i++) {
//    		if(contentLength<(i+1)*20){
//    			System.out.println(str.substring(i*20, contentLength));
//    		}else{
//    			System.out.println(str.substring(i*20, (i+1)*20));
//    		}
//    		//System.out.println(str.substring(i*20, (i+1)*20));
//		}
    	
//    	System.out.println(Double.valueOf(25)/Double.valueOf(20));
//    	System.out.println(Math.ceil(Double.valueOf(25)/Double.valueOf(20)));
//    	String a = new Date().toLocaleString();
//    	System.out.println(a);
    	
//    	int score= 1500; 	//积分
//    	int healthlevel=0;	//等级
//    	int honor = 30;
//    	
//    	for (int i = 500; i <= score; i+=500) {
//    		for(int j=10; j<=honor; j+=10){
//    			if((i/500) == (j/10))
//    				healthlevel++;
//    			//System.out.println("j:" + (j/10));
//    		}
//    		//System.out.println("i:" + (i/500));
//		}
//    	System.out.println(healthlevel);
    	
    	
    	
//    	System.out.println(String.format("%.0f", 22*1.0 / ((174/100)*(174/100)) ));
//    	System.out.println(String.format("%.1f", 52.8*1.0 / ((161/100)*(161/100)) ));
//    	
//    	System.out.println(DateUtils.curBeforeDateStr("yyyy/M/d"));
//    	
//    	System.out.println(String.format("%.1f", 15.64561));
//    	  MultipartEntity entity=new MultipartEntity();  
//        entity.addPart("userId",new StringBody("151", Charset.forName("UTF-8")));  
//        entity.addPart("activityId",new StringBody("157",Charset.forName("UTF-8")));  
//        entity.addPart("tokenId",new StringBody("aaaaaaaaaaaaaaaaaaaaaaaaaaa",Charset.forName("UTF-8"))); 
//        entity.addPart("file",new FileBody(new File("C:\\Users\\developer\\Desktop\\1.png")));  
//          
//        HttpPost request=new HttpPost("http://localhost:8080/sohealth/service/rest/app/activity/uploadfile");  
//        request.setEntity(entity);  
//        HttpClient client=new DefaultHttpClient();  
//        client.execute(request);  
    }  
  
} 