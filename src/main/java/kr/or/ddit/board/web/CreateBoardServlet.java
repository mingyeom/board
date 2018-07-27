package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("utf-8");
		
		String title = request.getParameter("title");
		int checkNy = Integer.parseInt(request.getParameter("isYn"));
		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(title);
		boardVo.setUse_yn(checkNy);
		boardService.createBoard(boardVo);
		
		List<BoardVo> allBoardList = boardService.selectAllBoard();
		List<BoardVo> boardVoList = boardService.checkYList();
		
		ServletContext application = getServletContext();
		application.setAttribute("allBoardList", allBoardList);
		request.setAttribute("boardVoList", boardVoList);
		
		
		request.getRequestDispatcher("/board/newBoard.jsp").forward(request,
				response);
		
	}

}
