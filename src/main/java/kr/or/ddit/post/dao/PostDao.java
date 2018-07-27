package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * 
	 * Method : getPostpost_id
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param post_id
	 * @return
	 * Method 설명 : 게시글 번호로 상세조회
	 */
	@Override
	public PostVo getPostpost_id(int post_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		PostVo idPost = session.selectOne("post.getPostpost_id", post_id);
		session.close();
		
		return idPost;
	}

	/**
	 * 
	 * Method : selectAllPost
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 전체 조회
	 */
	@Override
	public List<PostVo> selectAllPost() {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.selectAllPost");
		session.close();
		
		return postList;
	}

	/**
	 * 
	 * Method : getPostPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 게시글 정보 페이징 조회
	 */
	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postPageList = session.selectList("post.getPostPageList", map);
		session.close();
		
		return postPageList;
	}

	/**
	 * 
	 * Method : getPostTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 전체 건수 조회
	 */
	@Override
	public int getPostTotCnt(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("post.getPostTotCnt", map);
		session.close();
		
		return totCnt;
	}

	/**
	 * 
	 * Method : postUpdate
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 정보 업데이트 건수 조회
	 */
	@Override
	public int postUpdate(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("post.postUpdate", postVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : insertPost
	 * 최초작성일 : 2018. 7. 21.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 생성
	 */
	@Override
	public int insertPost(PostVo postVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int insertPo = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		
		return insertPo;
	}

	/**
	 * 
	 * Method : getCheckY
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return 
	 * Method 설명 : 0=Y 삭제 안된 게시글 데려오기
	 */
	@Override
	public int getCheckY(int post_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int checkY = session.update("post.getCheckY", post_id);
		session.commit();
		session.close();
		
		return checkY;
	}

	/**
	 * 
	 * Method : getPostByNo
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param board_id
	 * @return
	 * Method 설명 : 계층형 게시글 조회
	 */
	@Override
	public List<PostVo> getPostByNo(int board_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getPostByNo", board_id);
		session.close();
		
		return postList;
	}

	/**
	 * 
	 * Method : insertAnswer
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 답글생성
	 */
	@Override
	public int insertAnswer(PostVo postVo) {

		SqlSession session = sqlSessionFactory.openSession();
		int insertAn = session.insert("post.insertAnswer", postVo);
		session.commit();
		session.close();
		
		return insertAn;
	}

	/**
	 * 
	 * Method : getPostId
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : postId 가져오기
	 */
	@Override
	public int getPostId(PostVo postVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int postId = session.selectOne("post.getPostId", postVo);
		session.close();
		
		return postId;
	}
	
	
	

}
