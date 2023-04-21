package com.exame.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너:특정 사건이 발생했을때 자동으로 실해되는 객체
// -감지하고 싶은 사건의 종류에 따라서 그에 맞는 리스너인터페이스를 구현
//web.xml파일에 <Listener>를 사용하여 등록하거나 @Weblistener를 클래스에 적용

//@WebListener
public class DriverListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("DriverListener contextInitialized()실행" );
	    		
		ServletContext context = sce.getServletContext();//생건된 서블릿컨텍스트 객체 가져오기
		//"driver"라는 이름으로 저장되어 있는 컨텍스트파라미터 값 읽기
		String cname = context.getInitParameter("driver");
		//서블릿컨텍스트객체가 처음 생성된 시점(서버(톰캣)시작시점)에 실해되는 메서드
		try {
			Class.forName(cname);
		} catch (ClassNotFoundException e) {						
			e.printStackTrace();
		}	
}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//서블릿컨텍스트객체가 소멸되기 직전(서버(톰캣)종료시점)에 실해되는 메서드
		System.out.println("DriverListener contextDestroyed()실행" );
	}
}
