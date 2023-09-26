package com.tjoeun.springProperties_xml;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin.id: " + adminConnection.getAdminId());
		System.out.println("admin.pw: " + adminConnection.getAdminId());
		System.out.println("sub_admin.id: " + adminConnection.getSub_adminId());
		System.out.println("sub_admin.pw: " + adminConnection.getSub_adminPw());
		
}

}











