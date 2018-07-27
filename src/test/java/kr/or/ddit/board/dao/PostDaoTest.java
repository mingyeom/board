package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.upload.model.UploadVo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class PostDaoTest {

	private PostDaoInf postDao;

	@Before
	public void setup() {
		postDao = new PostDao();
	}

	/**
	 * 
	 * Method : getPostpost_id 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param post_id
	 * @return Method 설명 : 게시글 번호로 상세조회
	 */
	@Test
	public void getPostpost_idTest() {

		/*** Given ***/

		/*** When ***/
		PostVo postId = postDao.getPostpost_id(1);

		/*** Then ***/
		assertEquals("강병관", postId.getWriter());

	}

	/**
	 * 
	 * Method : selectAllPost 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 게시글 전체 조회
	 */
	@Test
	public void selectAllPostTest() {

		/*** Given ***/

		/*** When ***/
		List<PostVo> postList = postDao.selectAllPost();
		for (PostVo vo : postList)

			/*** Then ***/
			assertEquals(1, postList.size());

	}

	/**
	 * 
	 * Method : getPostPageList 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param map
	 * @return Method 설명 : 게시글 정보 페이징 조회
	 */
	@Test
	public void getPostPageListTest() {

		/*** Given ***/

		/*** When ***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		List<PostVo> postList = postDao.getPostPageList(map);
		for (PostVo vo : postList)

			/*** Then ***/
			assertEquals(1, postList.size());
	}

	/**
	 * 
	 * Method : getPostTotCnt 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 게시글 전체 건수 조회
	 */
	@Test
	public void getPostTotCntTest() {
		
		/*** Given ***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_id", 1);

		/*** When ***/
		int totCnt = postDao.getPostTotCnt(map);

		/*** Then ***/
		assertEquals(1, totCnt);
	};
	
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
	@Test
	public void postUpdateTest(){
		
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setPost_id(1);
		postVo.setTitle("치킨먹는 병관이");
		postVo.setContent("치킨어제먹었어오");
		
		/***When***/
		int updateCnt = postDao.postUpdate(postVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	/**
	 * 
	 * Method : insertPostTest
	 * 최초작성일 : 2018. 7. 21.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 게시글 생성
	 */
	@Test
	public void insertPostTest(){
		
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_id(2);
		postVo.setTitle("아배아파");
		postVo.setContent("많이먹어서 배아파요..");
		postVo.setStd_id("brown2");

		/***When***/
		int insertPo = postDao.insertPost(postVo);

		/***Then***/
		assertEquals(1, insertPo);

	}
	
	@Test
	public void insertAnswerTest(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setStd_id("brown2");
		postVo.setBoard_id(83);
		postVo.setTitle("답글달기");
		postVo.setContent("답글달기");
		postVo.setPost_papa(2);
		postVo.setPost_gid(2);

		/***When***/
		int insertAnswer = postDao.insertAnswer(postVo);

		/***Then***/
		assertEquals(1, insertAnswer);
	}
	
	@Test
	public void getPostIdTest(){
		
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setTitle("자유게시판 게시글 테스트");
		postVo.setStd_id("brown2");
		postVo.setBoard_id(83);
		
		/***When***/
		int postId = postDao.getPostId(postVo);

		/***Then***/
		assertEquals(1, postId);

	}

}
