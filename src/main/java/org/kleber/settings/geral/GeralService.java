package org.kleber.settings.geral;

import org.kleber.settings.PropertyService;
import org.springframework.stereotype.Service;

@Service
public class GeralService extends PropertyService<Geral> {

	public GeralService() {
		super(Geral.class);
	}

}
