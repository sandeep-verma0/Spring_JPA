package com.learnbycoding.springJpa.dao;

import java.util.List;

import com.learnbycoding.springJpa.model.Student;


public interface StudentDao{

	void saveStudent(Student student);
	
	List<Student> findAllStudents();
	
	void deleteStudentByUniqueID(String uniqueID);
	
	Student findByUniqueID(String uniqueID);
	
	void updateStudent(Student student);
}
