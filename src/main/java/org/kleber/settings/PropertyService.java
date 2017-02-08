package org.kleber.settings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

public abstract class PropertyService<E extends Property> {
	
	@Autowired
	protected PropertyDao<E> dao;
	
	protected Class<E> clazz;
	
	public PropertyService(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public E get() throws ClassNotFoundException, IOException {
		return dao.get();
	}
	
	public void set(E object) throws IOException {
		dao.set(object);
	}
	
	public List<Class<?>> settings() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		for (BeanDefinition bd : scanner.findCandidateComponents("org.kleber.settings")) {
			Class<?> clazz;
			try {
				clazz = Class.forName(bd.getBeanClassName());
			} catch (ClassNotFoundException e) {
				clazz = null;
			}
			if(clazz != null && clazz.getSuperclass().equals(Property.class)) {
				list.add(clazz);
			}
		}
		
		return list;
	}

}
