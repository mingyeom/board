package kr.or.ddit.board.web;

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

/**
 * Servlet implementation class ChangeBoardServlet
 */
@WebServlet("/changeBoard")
public class ChangeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		int broad_id = Integer.parseInt(request.getParameter("board_id"));
		int checkNy = Integer.parseInt(request.getParameter("isYn"));
		String board_name = request.getParameter("board_name");

		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoardboard_id(broad_id);

		boardVo.setUse_yn(checkNy);
		boardVo.setBoard_name(board_name);

		boardService.updateBoard(boardVo);
		
		//List<BoardVo> allBoardList = boardService.selectAllBoard();
		List<BoardVo> boardVoList = boardService.checkYList();

		ServletContext application = getServletContext();
		//application.setAttribute("allBoardList", allBoardList);
		request.setAttribute("boardVoList", boardVoList);

		response.sendRedirect("/boardServlet");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
