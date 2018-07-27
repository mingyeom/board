package kr.or.ddit.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int com_id = Integer.parseInt(request.getParameter("com_id"));
		int post_id = Integer.parseInt(request.getParameter("id"));

		ReplyServiceInf replyService = new ReplyService();
		replyService.getCheckY(com_id);

		response.sendRedirect("/freeListDetail?id=" + post_id);
	}
}
