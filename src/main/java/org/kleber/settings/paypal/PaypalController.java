package org.kleber.settings.paypal;

import org.kleber.settings.PropertyController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paypal")
public class PaypalController extends PropertyController<Paypal> {

	public PaypalController() {
		super(Paypal.class);
	}

}
