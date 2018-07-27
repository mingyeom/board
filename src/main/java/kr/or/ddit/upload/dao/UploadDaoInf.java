package kr.or.ddit.upload.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.upload.model.UploadVo;

public interface UploadDaoInf {

	/**
	 * 
	 * Method : createBoard 최초작성일 : 2018. 7. 23. 작성자 : PC23 변경이력 :
	 * 
	 * @param boardVo
	 * @return Method 설명 : 파일 추가
	 */
	int uploadFile(UploadVo uploadVo);
	
	/**
	 * 
	 * Method : selectAllFile
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 파일 정보 조회
	 */
	List<UploadVo> selectAllFile();
	
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
	int fileUpdate(UploadVo uploadVo);
	
	/**
	 * 
	 * Method : selectOnefile
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param uploadVo
	 * @return
	 * Method 설명 : 파일 정보 조회
	 */
	List<UploadVo> selectfile_postId(int id);
	
	
}
