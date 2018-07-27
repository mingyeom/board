package kr.or.ddit.upload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.upload.model.UploadVo;

public class UploadDao implements UploadDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * 
	 * Method : uploadFile
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param uploadVo
	 * @return
	 * Method 설명 : 파일 추가
	 */
	@Override
	public int uploadFile(UploadVo uploadVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertFile = session.insert("upload.uploadFile", uploadVo);
		session.commit();
		session.close();
		
		return insertFile;
	}

	/**
	 * 
	 * Method : selectAllFile
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 파일 정보 조회
	 */
	@Override
	public List<UploadVo> selectAllFile() {
		SqlSession session = sqlSessionFactory.openSession();
		List<UploadVo> getAllFile = session.selectList("upload.selectAllFile");
		session.close();
		
		return getAllFile;
	}

	/**
	 * 
	 * Method : fileUpdate
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param uploadVo
	 * @return
	 * Method 설명 : 첨부파일 업데이트
	 */
	@Override
	public int fileUpdate(UploadVo uploadVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int fileUpdateCnt = session.update("upload.fileUpdate", uploadVo);
		session.commit();
		session.close();
		
		return fileUpdateCnt;
	}

	/**
	 * 
	 * Method : selectfile_id
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param uploadVo
	 * @return
	 * Method 설명 : 파일 정보 조회
	 */
	@Override
	public List<UploadVo> selectfile_postId(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<UploadVo> getFileList = session.selectList("upload.selectfile_postId", id);
		session.close();
		
		return getFileList;
	}


}
