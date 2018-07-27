package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
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
	@Override
	public BoardVo getBoardboard_id(int board_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo idBoard = session.selectOne("board.getBoardboard_id", board_id);
		session.close();
		
		return idBoard;
	}

	/**
	 * 
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 조회
	 */
	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> idBoardList = session.selectList("board.selectAllBoard");
		session.close();
		
		return idBoardList;
	}

	/**
	 * 
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 게시판 페이지 리스트 조회
	 */
	@Override
	public List<BoardVo> getBoardPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getBoardPageList", map);
		session.close();
		
		return boardList;
	}

	/**
	 * 
	 * Method : getBoardTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 건수 조회
	 */
	@Override
	public int getBoardTotCnt() {
		
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("board.getBoardTotCnt");
		session.close();
		
		return totCnt;
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
		
		SqlSession session = sqlSessionFactory.openSession();
		int createVo = session.insert("board.createBoard", boardVo);
		session.commit();
		session.close();
		
		return createVo;
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
		
		SqlSession session = sqlSessionFactory.openSession();
		int updateBo = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateBo;
	}

	/**
	 * 
	 * Method : checkYList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : Y 체크 된 애들만 데려오기
	 */
	@Override
	public List<BoardVo> checkYList() {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> checkY = session.selectList("board.checkYList");
		session.close();
		
		return checkY;
	}
	
	

}
