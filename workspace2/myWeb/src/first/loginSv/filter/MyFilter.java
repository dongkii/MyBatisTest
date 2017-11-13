package first.loginSv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import first.loginSv.wrapper.LoginWrapper;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter.init() 호출~!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest h_request = (HttpServletRequest) request;
			
		request.setAttribute("pwdChk", h_request.getParameter("pwd"));
		LoginWrapper lw = new LoginWrapper(h_request);
		chain.doFilter(lw, response);
	}

	@Override
	public void destroy() {
		System.out.println("Myfilter.destroy() 호출!!");
	}
}
