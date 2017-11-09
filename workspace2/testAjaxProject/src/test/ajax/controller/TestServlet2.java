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
 * Servlet implementation class TestServlet2
 */
@WebServlet("/test2.do")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송값 받아서 처리하고, 결과로 문자열 내보내는 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		//기타 중간 과정 생략....
		
		String name = "홍길동";
		
		if(name != null && !name.equals("") && name.length() > 0){
			PrintWriter pw = response.getWriter();
			pw.write(name);
			pw.flush();
			pw.close();
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/error.jsp");
			request.setAttribute("message", "test2.do 요청 처리 실패");
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
