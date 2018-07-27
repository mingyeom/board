package kr.or.ddit.board.service;

import static org.junit.Assert.*;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadService;
import kr.or.ddit.upload.service.UploadServiceInf;

import org.junit.Before;
import org.junit.Test;

public class UploadServiceTest {
	
	private UploadServiceInf uploadService;

	@Before
	public void setUp(){
		uploadService = new UploadService();
	}

	@Test
	public void uploadFileTest() {
		
		/***Given***/
		UploadVo uploadVo = new UploadVo();
		uploadVo.setPost_id(6);
		uploadVo.setPicname("3fb36b6f-46ea-4aa7-82e6-998a36d2b4bc");
		uploadVo.setPic("moon.png");
		uploadVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");

		/***When***/
		int uploadFile = uploadService.uploadFile(uploadVo);
		
		/***Then***/
		assertEquals(1, uploadFile);

	}

}
