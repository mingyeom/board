package kr.or.ddit.student.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String std_id = request.getParameter("std_id");
		String pass = request.getParameter("pass");
		String encryptPass = KISA_SHA256.encrypt(pass);

		// 로그인 프로세스
		StudentServiceInf studentService = new StudentService();

		response.setContentType("text/html;charset=utf-8");

		List<StudentVo> studentVo = studentService.selectAllStudents();

		for (StudentVo vo : studentVo) {
			if (std_id.equals(vo.getStd_id())
					&& encryptPass.equals(vo.getPass())) {
				HttpSession session = request.getSession();
				session.setAttribute("studentVo", vo);
				session.setAttribute("std_id", std_id);
				
				BoardServiceInf boardService = new BoardService();
				List<BoardVo> boardVoList = boardService.checkYList();
				
				ServletContext application = getServletContext();
				application.setAttribute("boardVoList", boardVoList);
				
				request.getRequestDispatcher("/board/main.jsp").forward(
						request, response);
				return;
			}
		}
		request.getRequestDispatcher("/login/login.jsp").forward(request,
				response);

	}

}
