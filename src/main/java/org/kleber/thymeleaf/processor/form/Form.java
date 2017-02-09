package org.kleber.thymeleaf.processor.form;

import java.lang.reflect.Field;
import java.util.Map;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

public class Form extends AbstractElementProcessor {

	public Form() {
		super("form");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		if(command == null)
			command = arguments.getContext().getVariables().get("setting");
		
		if(command != null) {
			Element form = new Element("form");
			for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
				form.setAttribute(entry.getKey(), entry.getValue().getValue());
			form.setAttribute("method", "post");
			form.setAttribute("action", null);
			for(Node child : element.getChildren()) {
				for(Field field : command.getClass().getDeclaredFields()) {
					child.setNodeProperty("field", field);
					form.addChild(child.cloneNode(form, true));
				}
			}
			form.setProcessable(false);
			element.getParent().insertBefore(element, form);
			element.getParent().removeChild(element);
		}
		
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
