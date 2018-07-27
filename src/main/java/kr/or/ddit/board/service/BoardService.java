package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.student.model.StudentVo;

public class BoardService implements BoardServiceInf {

	private BoardDaoInf boardDao = new BoardDao();

	/**
	 * 
	 * Method : getBoardboard_name 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param board_name
	 * @return Method 설명 : 게시판 아이디로 상세조회
	 */
	@Override
	public BoardVo getBoardboard_id(int board_id) {
		return boardDao.getBoardboard_id(board_id);
	}

	/**
	 * 
	 * Method : selectAllBoard 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 게시판 전체 조회
	 */
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	/**
	 * 
	 * Method : getBoardPageList 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param map
	 * @return Method 설명 : 게시판 정보 페이징 조회
	 */
	@Override
	public Map<String, Object> getBoardPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<BoardVo> pageList = boardDao.getBoardPageList(map);
		resultMap.put("pageList", pageList);

		int totCnt = boardDao.getBoardTotCnt();
		resultMap.put("totCnt", totCnt);

		int page = map.get("page");
		int pageSize = map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}

	private String makePageNavi(int page, int pageSize, int totCnt) {
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0) {
			cnt++;
		}

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;

		pageNaviStr
				.append("<li><a href=\"/boardList?page="
						+ prevPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");

		// for(int i = 0; i < cnt; i++)
		for (int i = 1; i <= cnt; i++) {
			// /boardList?page=3&pageSize=10
			String activeClass = "";
			if (i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass
					+ "><a href=\"/boardList?page=" + i + "&pageSize="
					+ pageSize + "\">" + i + "</a></li>");

			// else {
			// pageNaviStr.append("<li><a href=\"/boardList?page=" + i +
			// "&pageSize=" + pageSize + "\">" + i + "</a></li>");
			// }

		}

		pageNaviStr
				.append("<li><a href=\"/boardList?page="
						+ nextPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}


	/**
	 * 
	 * Method : BoareCreate
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	@Override
	public int createBoard(BoardVo boardVo) {
		return boardDao.createBoard(boardVo);
	}

	/**
	 * 
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 사용여부 수정
	 */
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public List<BoardVo> checkYList() {
		return boardDao.checkYList();
	}

}
