package org.kleber.thymeleaf.processor.util;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;

public class If extends AbstractConditionalVisibilityElementProcessor {

	public If() {
		super("if");
	}

	@Override
	public boolean isVisible(Arguments arguments, Element element) {
		return false;
	}

	@Override
	public boolean removeHostElementIfVisible(Arguments arguments, Element element) {
		return false;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
