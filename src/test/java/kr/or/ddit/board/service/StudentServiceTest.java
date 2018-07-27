package kr.or.ddit.board.service;

import static org.junit.Assert.*;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

	private StudentServiceInf studentService;

	@Before
	public void setup() {
		studentService = new StudentService();
	}

	/**
	 * 
	 * Method : getStudentId 최초작성일 : 2018. 7. 18. 작성자 : PC23 변경이력 :
	 * 
	 * @param std_id
	 * @return Method 설명 : 아이디로 학생 상세조회
	 */
	@Test
	public void getStudentStd_idTest() {
		/*** Given ***/

		/*** When ***/
		StudentVo stdStudent = studentService.getStudentStd_id("brown");
		System.out.println(stdStudent);

		/*** Then ***/
		assertEquals("brown", stdStudent.getStd_id());

	}

}
