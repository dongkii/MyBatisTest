package first.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class CalcAjaxServlet
 */
@WebServlet("/calc.do")
public class CalcAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcAjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		JSONObject jobj = new JSONObject();
		try {
			int num1 = Integer.parseInt(request.getParameter("n1"));
			int num2 = Integer.parseInt(request.getParameter("n2"));
			String oper = request.getParameter("oper");

			if (oper.equals("add")) {
				jobj.put("result",String.format("%d+%d=%d", num1, num2, num1 + num2));
			} else if (oper.equals("sub")) {
				jobj.put("result",String.format("%d-%d=%d", num1, num2, num1 - num2));
			} else if (oper.equals("mul")) {
				jobj.put("result",String.format("%d*%d=%d", num1, num2, num1 * num2));
			} else if (oper.equals("div")) {
				jobj.put("result",String.format("%d/%d=%d", num1, num2, num1 / num2));
			}
		} catch (ArithmeticException e) {
			jobj.put("result","0으로는 나눌 수 없습니다.");
		} catch (NumberFormatException e) {
			jobj.put("result","계산 값이 숫자가 아닙니다.");
		} finally {
			PrintWriter out = response.getWriter();
			out.print(jobj.toJSONString());
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
