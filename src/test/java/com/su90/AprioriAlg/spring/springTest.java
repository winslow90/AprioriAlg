package com.su90.AprioriAlg.spring;

import org.junit.Test;

import com.su90.AprioriAlg.utils.SpringUtil;

public class springTest extends SpringUtil{
	
	@Test
	public void testSessionFactory(){
		context.getBean("sqlSessionFactory");		
	}
	
}
