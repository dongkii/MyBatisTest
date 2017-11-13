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
 * Servlet implementation class listenerAckServlet
 */
@WebServlet("/listenerAck.li")
public class ListenerAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerAckServlet() {
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
		
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>\r\n<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n" + 
				"<title>Listener Test Page</title>\r\n" + 
				"</head>\r\n<body>"
				+ "<h1>리스너 테스트 확인</h1><hr><br>");
		out.println("전달된 이름 : "+name+"<br>");
		out.println("이벤트 확인을 위해 서버 콘솔을 확인해 보세요!<br>");
		out.println("<a href='listener.li'>세션 종료</a>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

}
