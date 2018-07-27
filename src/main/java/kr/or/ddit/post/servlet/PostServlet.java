package kr.or.ddit.post.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadService;
import kr.or.ddit.upload.service.UploadServiceInf;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/postServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Method : doGet
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 게시글 페이지 리스트 만들어보는거..
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String board_name = request.getParameter("board_name");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);

		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);

		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_id", board_id);

		PostServiceInf postService = new PostService();
		UploadServiceInf uploadService = new UploadService();
		
		Map<String, Object> resultMap = postService.getPostPageList(paramMap);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("pageList");
		request.setAttribute("postList", postList);

		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		HttpSession session = request.getSession();
		session.setAttribute("board_id", board_id);
		request.setAttribute("board_name", board_name);
		
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardVoList = boardService.checkYList();
		request.setAttribute("boardVoList", boardVoList);

		
		RequestDispatcher rd = request
				.getRequestDispatcher("/board/freeList.jsp");
		rd.forward(request, response);
	}
	
	
}
