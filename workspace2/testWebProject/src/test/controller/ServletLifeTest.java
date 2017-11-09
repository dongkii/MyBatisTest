package test.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeTest
 */
@WebServlet("/life")
public class ServletLifeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLifeTest() {
        super();
        // 최초 요청시에만 실행되며, 웹 컨테이너에 로딩된 다음 생성됨
        System.out.println("ServletLifeTest 객체 생성됨...");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 최초 요청시에만 실행되며, 웹 컨테이너에 서블릿이 로딩되어 객체가 생성된 다음 실행됨
		System.out.println("ServletLifeTest 객체 초기화되었음...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 서비스 종료시 웹 컨테이너에서 서블릿이 소멸됨
		// 서비스 종료는 웹 컨테이너 중지시 발생함
		System.out.println("ServletLifeTest 객체가 웹 컨테이너에서 소멸됨...");
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스에 대한 요청을 전송방식에 따라 해당 메소드로 넘김
		System.out.println("service() 구동됨...");
		if(request.getMethod().equalsIgnoreCase("post"))
			this.doPost(request, response);
		else
			this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송방식이 get 일 때 실행되는 메소드임
		System.out.println("doGet() 메소드 실행됨...");
		response.sendRedirect("/testw/views/testView.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송방식이 post 일 때 실행되는 메소드임
		System.out.println("doPost() 메소드 실행됨...");
		doGet(request, response);
	}

}
