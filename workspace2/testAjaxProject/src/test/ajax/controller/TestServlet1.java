package test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/test1.do")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 제이쿼리가 요청한 서비스 처리용 컨트롤러
		// 처리 결과로 문자열 내보내기
		response.setContentType("text/html; charset=utf-8");
		
		//중간 처리과정 생략....
		
		String value = "test1.do 가 보내는 결과 문자열입니다.";
		
		//response.getWriter().append("test1.do 가 보내는 결과 문자열입니다.");
		if(value != null && value.length() > 0){
			PrintWriter pw = response.getWriter();
			pw.println(value);
			pw.flush();
			pw.close();
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/error.jsp");
			request.setAttribute("message", "test1.do 요청 처리 실패!");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
