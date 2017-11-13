package first.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import first.member.model.service.MemberService;
import first.member.model.vo.Member;

/**
 * Servlet implementation class MemberSelectServlet
 */
@WebServlet("/mselect.do")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		ArrayList<Member> mlist = new MemberService().selectAll();
		if(mlist != null && mlist.size() > 0) {
			view = request.getRequestDispatcher("view/member/memberView.jsp");
			request.setAttribute("mlist", mlist);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("view/error/errorPage.jsp");
			request.setAttribute("msg", "유저 정보 조회 실패!!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
