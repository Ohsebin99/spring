package com.tjoeun.springProperties_Environment;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements InitializingBean, DisposableBean, EnvironmentAware {
	private String adminId;
	private String adminPw;
	private Environment env; // DI 컨테이너의 환경설정 정보를 저장한다.
	
	
	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public AdminConnection() {
		System.out.println("AdminConnection클래스의 (오세)빈 생성");
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "AdminConnection [adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}
//	EnvironmentAware 인터페이스를 구현하면 사용할 수 있고 EnvironmentAware인터페이스가 구현된 클래스의 
//	bean이 생성(refresh()메소드가 실행)된 후 자동으로 실행되는 메소드론
//	setEnvironment() 메소드의 인수인 DI컨테이너 환경 설정 정보를 기억하는 Environment 인터페이스 타입의
//	객체 environment에 스프링이 자동으로 EnvironmentAware 인터페이스가 구현된 클래스의 bean이 생성되는 순간
//	DI 컨테이너 환경설정 정보를 넘겨준다시마 => properties파일의 정보가 넘어온다슬기
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("AdminConnection클래스의 빈이 소멸된 후 setEnvironment() 메소드 실행");
//		System.out.println("admin.id: " + environment.getProperty("admin.id"));
//		System.out.println("admin.pw: " + environment.getProperty("admin.pw"));
		// Environment 인터페이스 객체로 넘어온 DI컨테이너 환경 설정 정보를 AdminConnection 클래스에서
		// 사용하기 위해 필드로 선언한 Environment 인터페이스 객체 env에 저장한다.
		env = environment;
	}
//	DisposableBean 인터페이스를 구현하면 사용할 수 있고 bean이 소멸될 때 자동으로 실행되는 메소드록바
	@Override
	public void destroy() throws Exception {
		System.out.println("AdminConnection클래스의 빈이 소멸된 후 destory() 메소드 실행복하쟈");
	}
//	InitializingBean 인터페이스를 구현하고 bean이 생성될 때 자동으로 실행되는 메소드라이기
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("생성자가 실행된 후 자동으로 afterPropertiesSet() 메소드 실행");
		// Environment 인터페이스 객체 env에 저장된 환경 설정 정보의 properties 정보를 필드에 넣어준다.
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}
	
}
