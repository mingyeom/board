package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
	private StudentDaoInf studentDao;

	@Before
	public void setup() {
		studentDao = new StudentDao();
	}

	/**
	 * 
	 * Method : getStudentId
	 * 최초작성일 : 2018. 7. 18.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param std_id
	 * @return
	 * Method 설명 : 아이디로 학생 상세조회
	 */
	@Test
	public void getStudentStd_idTest() {
		/***Given***/
		

		/***When***/
		StudentVo stdStudent = studentDao.getStudentStd_id("brown2");
		System.out.println(stdStudent);

		/***Then***/
		assertEquals("brown2", stdStudent.getStd_id());

	}
	
	
	@Test
	public void selectAllStudentsTest(){
		/*** Given ***/

		/*** When ***/
		List<StudentVo> studentList = studentDao.selectAllStudents();
		for (StudentVo vo : studentList)

		/*** Then ***/
		assertEquals(25, studentList.size());

	}

}
