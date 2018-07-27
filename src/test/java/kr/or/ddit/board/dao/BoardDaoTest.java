package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {

	private BoardDaoInf boardDao;

	@Before
	public void setup() {
		boardDao = new BoardDao();
	}

//	/**
//	 * 
//	 * Method : getBoardboard_name 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
//	 * 
//	 * @param board_name
//	 * @return Method 설명 : 게시판 아이디로 상세조회
//	 */
//	@Test
//	public void getBoardboard_idTest() {
//		/*** Given ***/
//
//		/*** When ***/
//		BoardVo idBoard = boardDao.getBoardboard_id(1);
//
//		/*** Then ***/
//		assertEquals("자유게시판", idBoard.getBoard_name());
//
//	}
//
//	/**
//	 * 
//	 * Method : selectAllBoard 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
//	 * 
//	 * @return Method 설명 : 게시판 전체 조회
//	 */
//	@Test
//	public void selectAllBoardTest() {
//		/*** Given ***/
//
//		/*** When ***/
//		List<BoardVo> idBoardList = boardDao.selectAllBoard();
//
//		/*** Then ***/
//		assertEquals(2, idBoardList.size());
//
//	}
//
//	/**
//	 * 
//	 * Method : getBoardPageList 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
//	 * 
//	 * @param map
//	 * @return Method 설명 : 게시판 정보 페이징 조회
//	 */
//	@Test
//	public void getBoardPageListTest() {
//		/*** Given ***/
//
//		/*** When ***/
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("page", 1);
//		map.put("pageSize", 10);
//		List<BoardVo> boardList = boardDao.getBoardPageList(map);
//
//		/*** Then ***/
//		assertEquals(2, boardList.size());
//
//	}
//	
	/**
	 * 
	 * Method : getBoardTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 건수 조회
	 */
	@Test
	public void getBoardTotCntTest(){
		
		/***Given***/
		

		/***When***/
		int totCnt = boardDao.getBoardTotCnt();

		/***Then***/
		assertEquals(2, totCnt);

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
	@Test
	public void createBoardTest(){
		
		/***Given***/
		

		/***When***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_id(boardVo.getBoard_id());
		boardVo.setBoard_name("강병관게시판");
		boardVo.setUse_yn(0);
		
		/***Then***/
		assertEquals("강병관게시판", boardVo.getBoard_name());

	}
	
}
