package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.upload.dao.UploadDao;
import kr.or.ddit.upload.dao.UploadDaoInf;
import kr.or.ddit.upload.model.UploadVo;

import org.junit.Before;
import org.junit.Test;

public class UploadDaoTest {
	
	private UploadDaoInf uploadDao;

	@Before
	public void setup() {
		uploadDao = new UploadDao();
	}

	/**
	 * 
	 * Method : fileUpdateTest
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 :
	 */
	
	/*
	 update student set pic='moon.png',
		picpath='D:\A_TeachingMaterial\7.JspSpring\fileUpload',
		picname='3fb36b6f-46ea-4aa7-82e6-998a36d2b4bc',
		addr1='대전광역시 중구 중앙로 76',
		addr2='영민빌딩 2층 대덕인재개발원',
		zipcd='34940',
		name='강병관'
		where id=2;
	 */
	@Test
	public void uploadFileTest() {
		
		/***Given***/
		

		/***When***/
		UploadVo uploadVo = new UploadVo();
		uploadVo.setPost_id(1);
		uploadVo.setPicname("3fb36b6f-46ea-4aa7-82e6-998a36d2b4bc");
		uploadVo.setPic("moon.png");
		uploadVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");

		int uploadFile = uploadDao.uploadFile(uploadVo);
		
		/***Then***/
		assertEquals(1, uploadFile);

	}
	
	@Test
	public void selectAllFileTest(){
		/***Given***/
		

		/***When***/
		List<UploadVo> uploadList = uploadDao.selectAllFile();
		for (UploadVo vo : uploadList)

		/***Then***/
		assertEquals(1, uploadList.size());

	}
	
	
	

}
