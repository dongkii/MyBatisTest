package first.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListenerServlet
 */
@WebServlet("/listener.li")
public class ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		
		if(session != null){
			session.invalidate();
		}
		out.println("<html>\r\n<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n" + 
				"<title>Listener Test Page</title>\r\n" + 
				"</head>\r\n<body>"
				+ "<h1>리스너 테스트 하기</h1><hr><br>");
		out.println("<form action='listenerAck.li' method='post'>");
		out.println("이름 : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='확인하기'>");
		out.println("</form>");
		out.println("<hr>");
		out.println("<a href='index.html'>메인으로 가기</a>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
