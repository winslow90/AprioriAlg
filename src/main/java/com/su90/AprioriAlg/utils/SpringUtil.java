package com.su90.AprioriAlg.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("com/su90/AprioriAlg/spring/applicationContext.xml");		
	}
}
