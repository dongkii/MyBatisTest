package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
//@WebServlet("*.me")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원서비스를 처리하는 서블릿 : 회원서비스용 프론트 컨트롤러
		System.out.println("MemberServlet의 doGet() 메소드 구동됨.");
		MemberController mcontroller = new MemberController();	
		String action = request.getParameter("action");
		
		switch(action){
		case "login" : mcontroller.loginCheck(request, response);  break;
		case "logout" : mcontroller.logOut(request, response);  break;
		case "menroll" : mcontroller.memberInsert(request, response); break;
		case "minfo" : mcontroller.memberInfo(request, response); break;
		case "mdelete" : mcontroller.memberDelete(request, response); break;
		case "mupdate" : mcontroller.memberUpdate(request, response); break;
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
