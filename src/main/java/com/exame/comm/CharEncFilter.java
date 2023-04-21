package com.exame.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터:서블릿의 실행 전후에 끼어들아거 실행
//	다수의 서블릿이 수행하는 공통작업을 실행할때 사용
//	Filter 인터페이스를 구현하여 필터클래스 정의
//web.xml에<filter>태그로 등록하거나 클래스에 @WebFilter 적용


public class CharEncFilter implements Filter {
	
	private String enc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터가 처음 생성됐을 때 1번실행
		System.out.println("CharEncFilter init()실행");
		enc = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//필터의 경로에 맞는 요청이 올때마다 한번씩 실행
		System.out.println("CharEncFilter doFilter()실행");
		
		request.setCharacterEncoding(enc);
		
		
		//이후 길행될 필터 또는 서블릿들을 실행
		chain.doFilter(request, response);	
		
	}
	
	@Override
	public void destroy() {
		//필터 객체가 소멸(삭제)되기 전에 1번 실행
		System.out.println("CharEncFilter destroy()실행");
	}
	

}
