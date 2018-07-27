package kr.or.ddit.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 파라미터 값을 받아서 sysout으로 console 창에 출력
		String std_id = request.getParameter("std_id");
		String pass = request.getParameter("pass");
		String encryptPass = KISA_SHA256.encrypt(pass);

		// 로그인 프로세스
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudentStd_id(std_id);

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		
		if (studentVo.validateUser(std_id, pass)) {

			HttpSession session = request.getSession();
			session.setAttribute("studentVo", studentVo);

			RequestDispatcher rd = request
					.getRequestDispatcher("/board/main.jsp");
			rd.forward(request, response);

		} else {
//			request.getRequestDispatcher("/login/login.jsp").forward(request,
//					response);
			response.sendRedirect("/login/login.jsp");
		}

	}

}
