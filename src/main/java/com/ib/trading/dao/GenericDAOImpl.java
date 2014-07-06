package com.ib.trading.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
	@PersistenceContext
	private EntityManager em ;
	
	private Class<T> type;
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(){
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public void save(T entity) {
		em.persist(entity);
	}
	
	public T find(Object id) {
		// TODO Auto-generated method stub
		return em.find(type, id);
	}
	public void delete(Object id) {
		this.em.remove(this.em.getReference(type, id));
	}

}
