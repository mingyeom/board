package kr.or.ddit.student.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	 
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
	@Override
	public StudentVo getStudentStd_id(String std_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo stdStudent = session.selectOne("student.getStudentStd_id", std_id);
		session.close();
		
		return stdStudent;
	}
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체학생 조회
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}

}
