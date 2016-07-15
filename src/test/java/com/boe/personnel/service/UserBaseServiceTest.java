package com.boe.personnel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springside.modules.test.spring.SpringTransactionalTestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserBaseServiceTest extends  SpringTransactionalTestCase{
	
	public static void main(String[] args){
		
		System.out.println("end");
		
	}
	
	@Test
	public void test(){
		System.out.println("end");
	}
	
	
}

