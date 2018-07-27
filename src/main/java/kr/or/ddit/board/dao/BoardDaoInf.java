package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.student.model.StudentVo;

public interface BoardDaoInf {
	
	/**
	 * 
	 * Method : getBoardboard_name
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param board_name
	 * @return
	 * Method 설명 : 게시판 아이디로 상세조회
	 */
	BoardVo getBoardboard_id(int board_id);
	
	/**
	 * 
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 조회
	 */
	List<BoardVo> selectAllBoard();
	
	/**
	 * 
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 게시판 정보 페이징 조회
	 */
	List<BoardVo> getBoardPageList(Map<String, Integer> map);
	
	/**
	 * 
	 * Method : getStudentToCntTest
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 게시판 전체 건수 조회
	 */
	int getBoardTotCnt();
	
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
	int createBoard(BoardVo boardVo);

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
	int updateBoard(BoardVo boardVo);
	
	/**
	 * 
	 * Method : selectYBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : Y체크 된 애들만 데려오기
	 */
	List<BoardVo> checkYList();
}
