package org.kleber.settings.paypal;

import org.kleber.settings.PropertyService;
import org.springframework.stereotype.Service;

@Service
public class PaypalService extends PropertyService<Paypal> {

	public PaypalService() {
		super(Paypal.class);
	}

}
