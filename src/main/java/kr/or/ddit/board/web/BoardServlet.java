package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 게시판 조회
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardVoList = boardService.checkYList();
		List<BoardVo> allBoardList = boardService.selectAllBoard();
		
		request.setAttribute("boardVoList", boardVoList);
		request.setAttribute("allBoardList", allBoardList);

		request.getRequestDispatcher("/board/newBoard.jsp").forward(request,
				response);
	}

}
