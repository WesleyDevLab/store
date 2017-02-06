package org.kleber.settings.geral;

import org.kleber.settings.PropertyDao;
import org.springframework.stereotype.Repository;

@Repository
public class GeralDao extends PropertyDao<Geral> {

	public GeralDao() {
		super(Geral.class);
		System.out.println("GeralDao --> "+Geral.class.getSimpleName());
	}

}
