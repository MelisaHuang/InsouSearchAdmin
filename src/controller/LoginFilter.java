package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
public class LoginFilter implements Filter {
	 public void destroy() {
	        // TODO Auto-generated method stub
	        
	    }

	 public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	        // TODO Auto-generated method stub
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse resp = (HttpServletResponse) response;
	        
	        request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        HttpSession session = req.getSession();
	        StringBuffer url = req.getRequestURL();
	        String username = (String) session.getAttribute("username");
	    
	        if (!"".equals(username) || username != null) {
	                     //如果已经通过
	            chain.doFilter(request, response);
	            
	        }
	        
	        else if (url.indexOf("index.jsp")>0) {
	                          //可以访问jsp，也可以访问login。do对应的servlet，通过
	            chain.doFilter(request, response);
	        }
	        
	        
	        else {
	            
	            resp.sendRedirect("/index.jsp");
	        }
	        
	    }
	    public void init(FilterConfig filterConfig) throws ServletException {
	        // TODO Auto-generated method stub
	        
	    }
	    

}
