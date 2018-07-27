package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

public interface PostServiceInf {

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
	PostVo getPostpost_id(int post_id);
	
	/**
	 * 
	 * Method : selectAllPost
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 전체 조회
	 */
	List<PostVo> selectAllPost();
	
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
	Map<String, Object> getPostPageList(Map<String, Integer> map);
	
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
	int postUpdate(PostVo postVo);
	
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
	int insertPost(PostVo postVo);
	
	/**
	 * 
	 * Method : getCheckY
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return 
	 * Method 설명 : 0=Y 삭제 안된 게시글 데려오기
	 */
	int getCheckY(int post_id);
	
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
	List<PostVo> getPostByNo(int board_id);
	
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
	int insertAnswer(PostVo postVo);

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
	int getPostId(PostVo postVo);
	
	
}
