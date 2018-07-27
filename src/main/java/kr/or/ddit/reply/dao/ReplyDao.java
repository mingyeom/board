package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
	@Override
	public List<ReplyVo> getReply_id(int com_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<ReplyVo> replyVo = session.selectList("reply.getReply_id", com_id);
		session.close();
		
		return replyVo;
		
	}

	/**
	 * 
	 * Method : selectAllReply
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 댓글 정보 조회
	 */
	@Override
	public List<ReplyVo> selectAllReply() {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<ReplyVo> replyList = session.selectList("reply.selectAllReply");
		session.close();
		
		return replyList;
	}

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
	@Override
	public int createReply(ReplyVo replyVo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int insertReply = session.insert("reply.createReply", replyVo);
		session.commit();
		session.close();
		
		return insertReply;
	}

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
	@Override
	public int getCheckY(int com_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		int CheckY = session.insert("reply.getCheckY", com_id);
		session.commit();
		session.close();
		
		return CheckY;
	}

}
