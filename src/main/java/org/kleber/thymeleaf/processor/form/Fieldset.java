package org.kleber.thymeleaf.processor.form;

import java.lang.reflect.Field;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;

public class Fieldset extends AbstractConditionalVisibilityElementProcessor {

	public Fieldset() {
		super("fieldset");
	}

	@Override
	public boolean isVisible(Arguments arguments, Element element) {
		Field field = (Field) arguments.getLocalVariable("field");
		String type = element.getAttributeValue("type");
		if(type.equals(field.getName()))
			return true;
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
