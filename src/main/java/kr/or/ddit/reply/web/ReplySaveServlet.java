package kr.or.ddit.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplySaveServlet
 */
@WebServlet("/replySave")
public class ReplySaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int post_id = Integer.parseInt(request.getParameter("id"));
		
		String context = request.getParameter("reply");
		
		ReplyServiceInf replyService = new ReplyService();
		ReplyVo replyVo = new ReplyVo();
		
		HttpSession session = request.getSession();
		String std_id = (String) session.getAttribute("std_id");
		
		replyVo.setContext(context);
		replyVo.setStd_id(std_id);
		replyVo.setPost_id(post_id);
		
		replyService.createReply(replyVo);
		
		response.sendRedirect("/freeListDetail?id="+post_id);
		
	}

}
