package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoInf;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.upload.dao.UploadDao;
import kr.or.ddit.upload.dao.UploadDaoInf;

public class ReplyService implements ReplyServiceInf {
	
	private ReplyDaoInf replyDao = new ReplyDao();

	@Override
	public List<ReplyVo> getReply_id(int com_id) {
		return replyDao.getReply_id(com_id);
	}

	@Override
	public List<ReplyVo> selectAllReply() {
		return replyDao.selectAllReply();
	}

	@Override
	public int createReply(ReplyVo replyVo) {
		return replyDao.createReply(replyVo);
	}

	@Override
	public int getCheckY(int com_id) {
		return replyDao.getCheckY(com_id);
	}

}
