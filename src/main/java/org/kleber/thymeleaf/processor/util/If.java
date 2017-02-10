package org.kleber.thymeleaf.processor.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;

public class If extends AbstractConditionalVisibilityElementProcessor {

	private String type;
	
	public If() {
		super("if");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean isVisible(Arguments arguments, Element element) {
		type = element.getAttributeValue("type");
		Field field = (Field) arguments.getLocalVariable("field");
		if(field != null)
			for(Annotation annotation : field.getAnnotations())
				if(annotation.annotationType().getSimpleName().equals(type)) return true;
		return false;
	}

	@Override
	public boolean removeHostElementIfVisible(Arguments arguments, Element element) {
		return true;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
