package com.filter;

import java.io.IOException;
import java.security.Principal;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//web.xml 有寫；那@ annotation 最好也不要再寫(兩者會相互干擾；穩定性問題)
//@WebFilter(urlPatterns = "/*", asyncSupported = true) 
public class EncodeFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public EncodeFilter() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();

		Principal principal  = httpRequest.getUserPrincipal();
		//System.out.println(uri);
		// 排除靜態資源，例如 .css, .js, .png, .jpg 等
	    if (uri.matches(".*/?resource/.*")) {
	        chain.doFilter(request, response); // 不處理，直接放行
	        return;
	    }
		
	    // 練習 web.xml 配置 <filter> <init-para>
	    String encode = fConfig.getInitParameter("code");
	    
		// request encoding
		request.setCharacterEncoding(encode);
		
		// response ContentType
		response.setCharacterEncoding(encode);
		response.setContentType("text/html; charset:utf-8");
		
		 // 繼續執行後續過濾器
		chain.doFilter(request, response);
	}

	private FilterConfig fConfig;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
