package test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.ajax.model.vo.User;

/**
 * Servlet implementation class TestServlet4
 */
@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 요청의 결과로 json 객체를 내보내는 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
		
		User user = new User("u1234", "p1234", "홍길순", 25, 
				"hongks@kh.org", "010-1234-5678");
		
		//내보낼 json 객체로 바꿈
		JSONObject job = new JSONObject();
		job.put("userid", user.getUserId());
		job.put("userpwd", user.getUserPwd());
		//json에서 한글 깨짐을 막으려면, java.net.URLEncoder 클래스의 
		//encode() 메소드로 인코딩 처리함
		job.put("username", URLEncoder.encode(user.getUserName(), "UTF-8"));
		job.put("age", user.getAge());
		job.put("email", user.getEmail());
		job.put("phone", user.getPhone());
		
		System.out.println("job : " + job.toJSONString());
		
		PrintWriter pw = response.getWriter();
		//문자스트림이므로 객체를 문자열형으로 바꿔서 내보내야 함
		pw.print(job.toJSONString());
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








