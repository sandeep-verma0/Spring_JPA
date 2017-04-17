package com.learnbycoding.springJpa.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learnbycoding.springJpa.model.Student;

@Repository("studentDao")
@Transactional
public class StudentDaoImpl extends AbstractDao implements StudentDao{

	@Override
	//Equivalent to 'Insert into Student ...'
	public void saveStudent(Student student) {
		persist(student);
	}

	@Override
	@SuppressWarnings("unchecked")
	//Equivalent to 'select * from Students'
	public List<Student> findAllStudents() {
		Query query = (Query) em.createQuery("Select e from Student e");
        return ((javax.persistence.Query) query).getResultList();
	}

	@Override
	//Equivalent to 'delete from student where uniqueID='someID''
	public void deleteStudentByUniqueID(String uniqueID) {
		Query query = (Query) em.createQuery("delete from Student where uniqueID = :uniqueID");
		query.setParameter("uniqueID",uniqueID);
	
        query.executeUpdate();
	}

	@Override
	//Equivalent to 'select from student where uniqueID='someID''
	public Student findByUniqueID(String uniqueID) {
		Query query = (Query) em.createQuery("Select c from Student c where uniqueID = :uniqueID");
		query.setParameter("uniqueID",uniqueID);
		
		return (Student) query.getSingleResult();
	
	}

	@Override
	//Equivalent to 'update student where id='someID''
	public void updateStudent(Student student) {
		em.merge(student);
	}
}
