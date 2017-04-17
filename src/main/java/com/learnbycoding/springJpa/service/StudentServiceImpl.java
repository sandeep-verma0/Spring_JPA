package com.learnbycoding.springJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnbycoding.springJpa.dao.StudentDao;
import com.learnbycoding.springJpa.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	

	@Autowired
	private StudentDao dao;
	
	@Override
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}

	@Override
	public void deleteStudentByUniqueID(String uniqueID) {
		dao.deleteStudentByUniqueID(uniqueID);
	}

	@Override
	public Student findByUniqueID(String uniqueID) {
	    return dao.findByUniqueID(uniqueID);
	}

	@Override
	public void updateStudent(Student student) {
		dao.updateStudent(student);	
	}

	@Override
	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}
}
