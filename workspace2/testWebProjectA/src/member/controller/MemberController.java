package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

public class MemberController {
	public MemberController(){}
	
	public void loginCheck(HttpServletRequest request, HttpServletResponse response){
		try{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		Member sendMember = new Member();
		sendMember.setMemberId(userId);
		sendMember.setMemberPwd(userPwd);
		
		//4. 鍮꾩쫰�땲�뒪 濡쒖쭅 泥섎━�슜 �겢�옒�뒪 媛앹껜 �깮�꽦
		MemberService mservice = new MemberService();	
		//濡쒓렇�씤 泥섎━�슜 硫붿냼�뱶 �떎�뻾�븯怨�, 寃곌낵 諛쏆쓬
		//Member member = mservice.loginCheck(userId, userPwd);
		Member member = mservice.loginCheck(sendMember);
		
		//5. 諛쏆� 寃곌낵瑜� 媛�吏�怨�, �꽦怨�/�떎�뙣 �럹�씠吏� �꽑�깮�빐�꽌 �겢�씪�씠�뼵�듃濡� �궡蹂대깂
		RequestDispatcher view = null;
		if(member != null){ //濡쒓렇�씤 �꽦怨듭떆
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			//System.out.println("session id : " + session.getId());
			
			//response.sendRedirect("views/member/loginSuccess.jsp");
			if(userId.equals("admin")){
				//�쉶�썝 �쟾泥� �젙蹂� 議고쉶 泥섎━�슜 硫붿냼�뱶 �떎�뻾�븿
				ArrayList<Member> mlist = mservice.selectAll();
				view = request.getRequestDispatcher("views/member/memberListView.jsp");
				request.setAttribute("list", mlist);
				view.forward(request, response);
			}else
				response.sendRedirect("index.jsp");
		}else{
			//response.sendRedirect("views/member/loginFail.html");
			view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "濡쒓렇�씤 �떎�뙣! �븘�씠�뵒 �삉�뒗 �븫�샇 �솗�씤�븯�꽭�슂.");
			view.forward(request, response);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void logOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void memberInfo(HttpServletRequest request, HttpServletResponse response){
		try {
			// 회원 정보 조회 처리용 컨트롤러
			response.setContentType("text/html; charset=utf-8");
			
			Member member = new MemberService().selectMember(request.getParameter("userid"));
			
			RequestDispatcher view = null;
			if(member != null){
				view = request.getRequestDispatcher("views/member/myInfo.jsp");
				request.setAttribute("member", member);
				view.forward(request, response);
			}else{
				//getRequestDispatcher("상대경로만 사용할 수 있음")
				//절대경로 사용하면 에러남
				view = request.getRequestDispatcher("views/member/memberError.jsp");
				request.setAttribute("message", "회원 정보 조회 실패!");
				view.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void memberInsert(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String userId = request.getParameter("userid");
			String userPwd = request.getParameter("userpwd");
			String userName = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			String[] hobbies = request.getParameterValues("hobby");
			StringBuilder hb = new StringBuilder();
			for(int i = 0; i < hobbies.length; i++){
				if(i < hobbies.length - 1)
					hb.append(hobbies[i] + ",");
				else
					hb.append(hobbies[i]);
			}
			
			String hobby = hb.toString();
			
			Member member = new Member(userId, userPwd, userName, 
					gender, age, email, phone, address, hobby, null);
			
			int result = new MemberService().insertMember(member);
			
			if(result > 0){
				response.sendRedirect("/twa/index.jsp");
			}else{
				RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
				request.setAttribute("message", "회원 가입 실패!");
				view.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void memberUpdate(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			//2. 내보낼 뷰의 컨텐츠타입 지정
			response.setContentType("text/html; charset=utf-8");
			
			//3. 전송값 꺼내서 변수에 저장하기
			String userId = request.getParameter("userid");
			String userPwd = request.getParameter("userpwd");
			String userName = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			String[] hobbies = request.getParameterValues("hobby");
			StringBuilder hb = new StringBuilder();
			for(int i = 0; i < hobbies.length; i++){
				if(i < hobbies.length - 1)
					hb.append(hobbies[i] + ",");
				else
					hb.append(hobbies[i]);
			}
			
			String hobby = hb.toString();
			
			Member member = new Member(userId, userPwd, userName, 
					gender, age, email, phone, address, hobby, null);
			
			//System.out.println(member);
			
			/* 전송값 추출해서 객체에 저장하는 또 다른 방법
			 * Member member = new Member();
			member.setAddress(request.getParameter("address"));
			member.setAge(Integer.parseInt(request.getParameter("age")));*/
			
			//4. 모델서비스로 전달하고, 결과받기
			int result = new MemberService().updateMember(member);
			
			//5. 받은 결과에 따라 뷰를 선택해서 내보냄
			RequestDispatcher rd = null;
			if(result > 0){
				//수정된 회원정보 읽어와서, 세션객체에 저장된 회원 정보 변경 처리함
				Member smember = new MemberService().selectMember(userId);
				HttpSession session = request.getSession(false);
				session.removeAttribute("member");
				session.setAttribute("member", smember);
				
				response.sendRedirect("/twa/index.jsp");
			}else{
				rd = request.getRequestDispatcher("views/member/memberError.jsp");
				request.setAttribute("message", "회원 정보 수정 실패!");
				rd.forward(request, response);
				
				//response.sendRedirect("views/member/memberError.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void memberDelete(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType("text/html; charset=utf-8");
			
			if(new MemberService().deleteMember(request.getParameter("userid")) > 0){
				response.sendRedirect("/twa/*.me?action=logout");
			}else{
				RequestDispatcher errorPage = request.getRequestDispatcher("views/member/memberError.jsp");
				request.setAttribute("message", "회원 탈퇴 실패!");
				errorPage.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void selectList(HttpServletRequest request, HttpServletResponse response){
		
	}
}
