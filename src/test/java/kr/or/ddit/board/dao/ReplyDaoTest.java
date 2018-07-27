package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoInf;
import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;

public class ReplyDaoTest {

	private ReplyDaoInf replyDao;

	@Before
	public void setup() {
		replyDao = new ReplyDao();
	}
	
	@Test
	public void createReplyTest() {
		
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setContext("두번째 댓글입니다.");
		replyVo.setPost_id(1);
		replyVo.setStd_id("brown2");

		/***When***/
		int insertReply = replyDao.createReply(replyVo);

		/***Then***/
		assertEquals(2, insertReply);

	}
	
//	@Test
//	public void getReply_idTest() {
//		
//		/***Given***/
//		
//
//		/***When***/
//		ReplyVo replyVo = (ReplyVo) replyDao.getReply_id(1);
//
//		/***Then***/
//		assertEquals("첫번째 댓글입니다.", replyVo.getContext());
//	}
	
	@Test
	public void selectAllReplyTest(){
		/***Given***/
		

		/***When***/
		List<ReplyVo> replyList = replyDao.selectAllReply();
		for (ReplyVo vo : replyList)

		/***Then***/
		assertEquals(3, replyList.size());

	}

}
