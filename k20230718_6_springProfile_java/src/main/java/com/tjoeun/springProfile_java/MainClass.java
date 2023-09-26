package com.tjoeun.springProfile_java;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		String dev = "applicationCTX_dev.xml";
		String run = "applicationCTX_run.xml";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("실행할 작업 환경을 입력하세요(1 => dev, 2=> run):");
		int info = scanner.nextInt();
		String config = "";
		switch (info) {
			case 1:
				config = "dev";
				break;
			case 2:
				config = "run";
				break;
		}
		// profile이 설정된 java파일의 bean을 읽어오기 위해서는 DI컨테이너를 먼저 만든 후 읽어올 bean의
		// profile을 지정한 다음 해당 profile이 지정된 bean, load 시켜야 한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		// 읽어올 bean의 profile을 넣어준다.
		ctx.getEnvironment().setActiveProfiles(config);

		// AnnotationConfigApplicationContext 클래스로 java파일에서 @Profile어노테이션을 붙여서 설정한
		// bean 설정 정보를 넣어주려면 아래와 같이
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(serverInfo);
		
	}
}
