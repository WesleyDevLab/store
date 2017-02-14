package org.kleber.thymeleaf.processor.form;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
		
		Element form = new Element("form");
		for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
			form.setAttribute(entry.getKey(), entry.getValue().getValue());
		
		List<Node> list = new ArrayList<Node>();
		for(Field field : command.getClass().getDeclaredFields()) {
			for(Node node : element.getChildren()) {
				Node temp = node.cloneNode(form, true);
				temp.setNodeLocalVariable("field", field);
				list.add(temp);
			}
		}
		
		form.setProcessable(false);
		element.getParent().insertBefore(element, form);
		element.getParent().removeChild(element);
		
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
