package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.upload.model.UploadVo;

public interface ReplyDaoInf {
	
	/**
	 * 
	 * 
	 * Method : getReply_id
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param com_id
	 * @return
	 * Method 설명 : 아이디로 댓글 상세조회
	 */
	List<ReplyVo> getReply_id(int com_id);
	
	/**
	 * 
	 * Method : selectAllReply
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 댓글 정보 조회
	 */
	List<ReplyVo> selectAllReply();
	
	/**
	 * 
	 * Method : createReply
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param replyVo
	 * @return
	 * Method 설명 : 댓글 생성
	 */
	int createReply(ReplyVo replyVo);
	
	/**
	 * 
	 * Method : getCheckY
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param com_id
	 * @return
	 * Method 설명 : 댓글 삭제 버튼 누르면 1로 바뀌는거
	 */
	int getCheckY(int com_id);

}
