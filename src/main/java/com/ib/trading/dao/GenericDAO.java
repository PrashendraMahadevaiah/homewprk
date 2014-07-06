package com.ib.trading.dao;


public interface GenericDAO<T> {
	void save(T entity);
	T find(Object id);
	void delete(Object id);
	
}
