package kr.or.ddit.upload.service;

import java.util.List;

import org.junit.Before;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.upload.dao.UploadDao;
import kr.or.ddit.upload.dao.UploadDaoInf;
import kr.or.ddit.upload.model.UploadVo;

public class UploadService implements UploadServiceInf {
	
	private UploadDaoInf uploadDao = new UploadDao();

	@Override
	public int uploadFile(UploadVo uploadVo) {
		return uploadDao.uploadFile(uploadVo);
	}

	@Override
	public List<UploadVo> selectAllFile() {
		return uploadDao.selectAllFile();
	}

	@Override
	public int fileUpdate(UploadVo uploadVo) {
		return uploadDao.fileUpdate(uploadVo);
	}

	@Override
	public List<UploadVo> selectfile_postId(int id) {
		return uploadDao.selectfile_postId(id);
	}

	
}
