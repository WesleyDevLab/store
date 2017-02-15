package org.kleber.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class Dao<E> {
	protected Class<E> clazz;
	
	@Autowired
	protected SessionFactory sessionFactory;
		
	public Dao(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	public void insert(E object) {
		sessionFactory.getCurrentSession().persist(object);
	}
	
	@Transactional
	public void update(E object) {
		sessionFactory.getCurrentSession().merge(object);
	}
	
	@Transactional
	public void delete(E object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<E> select(String orderby, String groupby) {
		return (List<E>) sessionFactory.getCurrentSession().createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	@Transactional
	public E findById(String id) {
		E instance = (E) sessionFactory.getCurrentSession().get(clazz, id);
		return instance;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public E findBy(String key, String value) {
		String query = "from "+ clazz.getSimpleName() +" where "+ key +" = :data";
		List<E> instance = (List<E>) sessionFactory.getCurrentSession().createQuery(query).setString("data", value).list();
		if(instance != null)
			return instance.get(0);
		return null;
	}
}
