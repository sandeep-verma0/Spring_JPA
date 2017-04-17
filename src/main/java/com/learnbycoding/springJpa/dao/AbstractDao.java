package com.learnbycoding.springJpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractDao {

	@PersistenceContext
	protected EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public void persist(Object entity) {
		em.persist(entity);
	}

	public void delete(Object entity) {
		em.remove(entity);
	}
}
