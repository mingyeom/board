package kr.or.ddit.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int board_id = Integer.parseInt(request.getParameter("board_id"));

		request.setAttribute("board_id", board_id);

		request.getRequestDispatcher("/board/answer.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		PostServiceInf postService = new PostService();
		PostVo postVo = new PostVo();

		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int post_id = Integer.parseInt(request.getParameter("id"));
		int post_papa = Integer.parseInt(request.getParameter("id"));
		int post_gid = postService.getPostpost_id(post_id).getPost_gid();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		HttpSession session = request.getSession();
		String std_id = (String) session.getAttribute("std_id");

		postVo.setStd_id(std_id);
		postVo.setBoard_id(board_id);
		postVo.setTitle(title);
		postVo.setContent(content);
		postVo.setPost_papa(post_papa);
		postVo.setPost_gid(post_gid);

		postService.insertAnswer(postVo);

		response.sendRedirect("/postServlet?board_id=" + board_id
				+ "&page=1&pageSize=10");
		
	}

}
