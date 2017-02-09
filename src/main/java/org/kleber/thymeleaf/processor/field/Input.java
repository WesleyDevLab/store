package org.kleber.thymeleaf.processor.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

public class Input extends AbstractElementProcessor {

	public Input() {
		super("input");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		Field field = (Field) arguments.getLocalVariable("field");
		
		if(field != null && field.getAnnotation(org.kleber.annotations.field.Input.class) != null) {
			Element input = new Element("input");
			for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
				input.setAttribute(entry.getKey(), entry.getValue().getValue());
			input.setAttribute("type", type(field));
			input.setAttribute("name", field.getName());
			input.setAttribute("value", value(command).toString());
			input.setProcessable(false);
			element.getParent().insertBefore(element, input);
			element.getParent().removeChild(element);
		}
		
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}
	
	private Object value(Object command) {
		return null;
	}
	
	private String type(Field field) {
		String annotation_name = null;
		for(Annotation annotation : field.getDeclaredAnnotations())
			if(annotation.annotationType().getPackage().getName().equals("org.kleber.annotations.input_type"))
				annotation_name = annotation.annotationType().getSimpleName().toLowerCase();
		return annotation_name;
	}

}
