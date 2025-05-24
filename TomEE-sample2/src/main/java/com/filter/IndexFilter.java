package com.filter;

import java.io.IOException;

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

/**
 * Servlet Filter implementation class IndexFilter
 */
@WebFilter(urlPatterns = {"/index.html", "/"})
public class IndexFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public IndexFilter() {
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
		// 之所以讀不到.jsp 的 Attribute 是因為網頁在讀取前顯示；chatgpt 會先以.html輸出。不會被後面真正的 JSP 頁面統一處理。
//		httpReq.setAttribute("isAdmin", httpReq.isUserInRole("Admin"));
//		httpReq.setAttribute("role", (httpReq.getUserPrincipal()==null)? true: false);		

		// 傳送靜態網頁
		httpReq.getRequestDispatcher("./WEB-INF/view/authorityCtrl.html").include(httpReq, httpResp);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
