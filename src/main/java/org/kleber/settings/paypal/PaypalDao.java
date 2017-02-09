package org.kleber.settings.paypal;

import org.kleber.settings.PropertyDao;
import org.springframework.stereotype.Repository;

@Repository
public class PaypalDao extends PropertyDao<Paypal> {

	public PaypalDao() {
		super(Paypal.class);
	}

}
