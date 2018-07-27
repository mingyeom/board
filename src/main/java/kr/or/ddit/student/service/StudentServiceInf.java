package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.model.StudentVo;

public interface StudentServiceInf {
	
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
	StudentVo getStudentStd_id(String std_id);
	
	/**
	 * 
	 * Method : selectAllStudents 최초작성일 : 2018. 7. 19. 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 전체 학생 조회
	 */
	List<StudentVo> selectAllStudents();

}
