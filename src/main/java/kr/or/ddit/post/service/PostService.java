package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceInf {

	private PostDaoInf postDao = new PostDao();

	/**
	 * 
	 * Method : getPostpost_id 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param post_id
	 * @return Method 설명 : 게시글 번호로 상세조회
	 */
	@Override
	public PostVo getPostpost_id(int post_id) {
		return postDao.getPostpost_id(post_id);
	}

	/**
	 * 
	 * Method : selectAllPost 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 게시글 전체 조회
	 */
	@Override
	public List<PostVo> selectAllPost() {
		return postDao.selectAllPost();
	}

	/**
	 * 
	 * Method : getPostPageList 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @param map
	 * @return Method 설명 : 게시글 정보 페이징 조회
	 */
	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);

		int totCnt = postDao.getPostTotCnt(map);
		resultMap.put("totCnt", totCnt);

		int page = map.get("page");
		int pageSize = map.get("pageSize");
		int board_id = map.get("board_id");

		resultMap.put("pageNavi",
				makePageNavi(page, pageSize, totCnt, board_id));

		return resultMap;
	}

	/**
	 * 
	 * Method : makePageNavi 최초작성일 : 2018. 7. 20. 작성자 : PC23 변경이력 :
	 * 
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt, int board_id) {
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0) {
			cnt++;
		}

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;

		pageNaviStr
				.append("<li><a href=\"/postServlet?board_id="
						+ board_id
						+ "&page="
						+ prevPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");

		// for(int i = 0; i < cnt; i++)
		for (int i = 1; i <= cnt; i++) {
			// /postServlet?page=3&pageSize=10
			String activeClass = "";
			if (i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass
					+ "><a href=\"/postServlet?board_id=" + board_id + "&page=" + i + "&pageSize="
					+ pageSize + "\">" + i + "</a></li>");

			// else {
			// pageNaviStr.append("<li><a href=\"/postServlet?page=" + i +
			// "&pageSize=" + pageSize + "\">" + i + "</a></li>");
			// }

		}

		pageNaviStr
				.append("<li><a href=\"/postServlet?board_id="
						+ board_id
						+ "&page="
						+ nextPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	/**
	 * 
	 * Method : postUpdate 최초작성일 : 2018. 7. 20. 작성자 : PC23 변경이력 :
	 * 
	 * @param postVo
	 * @return Method 설명 : 게시글 정보 업데이트 건수 조회
	 */
	@Override
	public int postUpdate(PostVo postVo) {
		return postDao.postUpdate(postVo);
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
		return postDao.insertPost(postVo);
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
		return postDao.getCheckY(post_id);
	}

	/**
	 * 
	 * Method : insertAnswer
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 답글 생성
	 */
	@Override
	public int insertAnswer(PostVo postVo) {
		return postDao.insertAnswer(postVo);
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
		return postDao.getPostByNo(board_id);
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
		return postDao.getPostId(postVo);
	}


}
