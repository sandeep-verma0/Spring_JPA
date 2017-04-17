package com.learnbycoding.springJpa.service;

import java.util.List;

import com.learnbycoding.springJpa.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> findAllStudents();

	void deleteStudentByUniqueID(String uniqueID);

	Student findByUniqueID(String uniqueID);

	void updateStudent(Student student);
}
