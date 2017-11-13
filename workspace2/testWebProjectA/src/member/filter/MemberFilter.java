package member.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter("*.me")
public class MemberFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MemberFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 서블릿으로 전달될 데이터에 대한 필터링 처리 코드 작성함
		System.out.println("MemberFilter의 doFilter() 메소드 구동됨.");

		//전송방식이 post 이면, 한글 데이터 인코딩처리한 다음에 서블릿으로 넘김
		HttpServletRequest h_request = (HttpServletRequest) request;
		if (h_request.getMethod().equalsIgnoreCase("POST")) {
			request.setCharacterEncoding("utf-8");
		}

		// 실제 실행될 서블릿 연결하는 코드임
		chain.doFilter(request, response);
		
		// 뷰 페이지로 응답되는 데이터에 대한 필터링 처리 코드 작성하는 영역임...
		// 예를 들어, 파일 다운로드시 한글 파일명 urlencode 처리 등..
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
