package first.fileUpload.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet("/multiUpload.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		// 파일 저장 경로
		String fileSavePath = "upload";

		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		// System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, // request 객체
				uploadPath, // 서버 상 업로드 될 디렉토리
				uploadSizeLimit, // 업로드 파일 크기 제한
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);

		Enumeration files = multi.getFileNames();
		out.println("<h2>멀티 파일 업로드 구현하기</h2>");
		while (files.hasMoreElements()) {
			// 업로드 된 파일 이름 얻어오기
			String file = (String) files.nextElement();
			String fileName = multi.getFilesystemName(file);

			out.println("<br> 첨부파일명 : " + fileName);
		}
	}
}