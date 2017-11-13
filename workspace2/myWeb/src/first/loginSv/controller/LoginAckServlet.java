package first.loginSv.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAckServlet
 */
@WebServlet("/loginAck.do")
public class LoginAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		out.println("<html>\r\n<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n" + 
				"<title>필터와 래퍼 확인 Page</title>\r\n" + 
				"</head>\r\n<body>"
				+ "<h1>필터 & 래퍼 확인</h1><hr><br>");
		out.println("전달된 ID : "+id+"<br>");
		out.println("전달된 비밀번호 : "+(String)request.getAttribute("pwdChk")+"<br>");
		out.println("암호화된 비밀번호 : "+pwd+"<br>");
		out.println("<a href='index.html'>이전으로 가기</a>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

}
