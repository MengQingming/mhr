package com.boe.personnel.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 环信群组排名分享定时任务
 *
 */
public class RankShareChatroomTaskScanner {
	
	private static Logger logger = LoggerFactory.getLogger(RankShareChatroomTaskScanner.class);
	
	/**
	 * 向各个集团群组发送集团昨日健走top10排名
	 * @throws Exception 
	 */
	public void sendEnterRank() throws Exception{
		String path = RankShareChatroomTaskScanner.class.getResource("/").getPath();
		String jianzoupath = path.substring(0,path.indexOf("/WEB-INF"));
		
	}
	/**
	 * 发送环信部门排名信息昨日健走top10排名
	 * @param request
	 * @throws Exception 
	 */
	public void sendDepartRank() throws Exception{
		String path=RankShareChatroomTaskScanner.class.getResource("/").getPath();
		String jianzoupath=path.substring(0,path.indexOf("/WEB-INF"));
		
	}
	
	/**
	 * 发送环信小组的排名信息昨日健走top10排名
	 * @param request
	 * @throws Exception 
	 */
	public void sendGroupRank() throws Exception{
		String path=RankShareChatroomTaskScanner.class.getResource("/").getPath();
		String jianzoupath=path.substring(0,path.indexOf("/WEB-INF"));
	}
	
}
