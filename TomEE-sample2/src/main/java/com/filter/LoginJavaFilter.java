package com.filter;

import java.io.IOException;
import java.security.Principal;

import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.service.JavaRoleService;

/**
 * Servlet Filter implementation class LoginActiveFilter
 */
@WebFilter(urlPatterns = "/LoginServlet")
public class LoginJavaFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	@Inject
	private JavaRoleService service;

    public LoginJavaFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpReq =  (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		Principal principal  = httpReq.getUserPrincipal();
		
//		if(principal == null) { 
//			
//			return; // 不回傳 chain.doFilter(request, response);
//		}	
		
		if(principal != null && httpReq.isUserInRole("USER")) {
						
		
			// if active is false, redirect to page of not verified;
			if(service.findUserActive(principal.getName())) {
				chain.doFilter(request, response);
				return;
			}
			else 
				httpResp.sendRedirect("http://localhost:8080/ServletBasic2/NoActiveServlet");				
							
		}
		else {
			chain.doFilter(request, response);		
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
