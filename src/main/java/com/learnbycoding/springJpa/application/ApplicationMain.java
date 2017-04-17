package com.learnbycoding.springJpa.application;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.learnbycoding.springJpa.config.AppConfig;
import com.learnbycoding.springJpa.model.Student;
import com.learnbycoding.springJpa.service.StudentService;

public class ApplicationMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		StudentService service = (StudentService) context.getBean("studentService");

		/*
		 * Create student1
		 */
		Student student1 = new Student();
		student1.setName("Sandeep Verma");
		student1.setBirthDate(new LocalDate(1999, 11, 07));
		student1.setRollNO(new BigDecimal(11999));
		student1.setUniqueID("stud546781");

		/*
		 * Create student2
		 */
		Student student2 = new Student();
		student2.setName("Ravi Sharma");
		student2.setBirthDate(new LocalDate(1998, 05, 17));
		student2.setRollNO(new BigDecimal(12000));
		student2.setUniqueID("stud546555");

		/*
		 * Persist both Student
		 */
		service.saveStudent(student1);
		service.saveStudent(student2);

		/*
		 * Get all Students list from database
		 */
		List<Student> students = service.findAllStudents();
		for (Student stud : students) {
			System.out.println(stud);
		}

		/*
		 * delete a student
		 */
		service.deleteStudentByUniqueID("stud546781");

		/*
		 * update a student
		 */

		Student student = service.findByUniqueID("stud546555");
		student.setRollNO(new BigDecimal(13001));
		service.updateStudent(student);

		/*
		 * Get all students list from database
		 */
		List<Student> studentList = service.findAllStudents();
		for (Student stud : studentList) {
			System.out.println(stud);
		}
		context.close();
	}
}
