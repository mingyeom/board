package kr.or.ddit.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/board/newPost.jsp").forward(request, response);

	}

}
