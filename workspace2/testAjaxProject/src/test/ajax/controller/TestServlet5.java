package test.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import test.ajax.model.vo.User;

/**
 * Servlet implementation class TestServlet5
 */
@WebServlet("/test5.do")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list 나 map 을 json 배열로 내보내는 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("u1234", "p1234", "홍길동", 25, "h1234@kh.org", "010-1234-5678"));
		list.add(new User("u2345", "p2345", "박문수", 33, "h2345@kh.org", "010-2345-7777"));
		list.add(new User("u3456", "p3456", "장영실", 38, "h3456@kh.org", "010-3456-8888"));
		list.add(new User("u4567", "p4567", "이순신", 45, "h4567@kh.org", "010-4567-9999"));
		list.add(new User("u5678", "p5678", "유관순", 16, "h5678@kh.org", "010-5678-9510"));
	
		//json 객체 하나만 내보낼 수 있음
		//json 배열을 json 객체에 저장함
		//내보낼 json 객체 선언
		JSONObject job = new JSONObject();
		//list 옮겨담을 json 배열 선언
		JSONArray jarr = new JSONArray();
		
		for(User user : list){
			//user 객체 한 개를 저장할 json 객체 선언
			JSONObject j = new JSONObject();
			j.put("userid", user.getUserId());
			j.put("userpwd", user.getUserPwd());
			j.put("username", URLEncoder.encode(user.getUserName(), "UTF-8"));
			j.put("age", user.getAge());
			j.put("email", user.getEmail());
			j.put("phone", user.getPhone());
			
			jarr.add(j);
		}		
		
		job.put("list", jarr);
		System.out.println("job : " + job.toJSONString());
		
		PrintWriter pw = response.getWriter();
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
