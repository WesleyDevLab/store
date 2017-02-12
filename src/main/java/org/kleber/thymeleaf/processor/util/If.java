package org.kleber.thymeleaf.processor.util;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;

public class If extends AbstractConditionalVisibilityAttrProcessor {

	public If() {
		super("if");
	}

	@Override
	public boolean isVisible(Arguments arguments, Element element, String attributeName) {
		return false;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
