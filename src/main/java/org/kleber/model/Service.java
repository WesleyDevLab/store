package org.kleber.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class Service<E> {
	@Autowired
	protected Dao<E> dao;
	
	protected Class<E> clazz;
	
	public Service(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	public void insert(E object) {
		dao.insert(object);
	}
	
	@Transactional
	public void update(E object) {
		dao.update(object);
	}
	
	@Transactional
	public void delete(E object) {
		dao.delete(object);
	}
	
	@Transactional
	public List<E> select(String orderby, String groupby) {
		return dao.select(orderby, groupby);
	}
	
	public E newObject() throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}
	
	@Transactional
	public E getObject(String id) {
		return dao.findById(id);
	}
	
	@Transactional
	public E getObject(String key, String value) {
		return dao.findBy(key, value);
	}
}
