package com.ex.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import file.Student;

import java.util.List;

public class StudentDAO {
	private EntityManagerFactory emf;

	public StudentDAO() {
		emf = Persistence.createEntityManagerFactory("nekazi");
	}

	public void addStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(student);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Student> getAllStudents() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("FROM Student", Student.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<Student> getStudentsAbove60Percent() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery(
					"SELECT DISTINCT s FROM Student s JOIN FETCH s.marks m WHERE (m.marks * 100 / 100) > 60",
					Student.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
