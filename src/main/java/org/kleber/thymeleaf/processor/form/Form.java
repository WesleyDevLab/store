package org.kleber.thymeleaf.processor.form;

import java.util.Map;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractIterationElementProcessor;

public class Form extends AbstractIterationElementProcessor {

	public Form() {
		super("form");
	}

	@Override
	public String getIteratedElementName(Arguments arguments, Element element) {
		return "form";
	}

	@Override
	public IterationSpec getIterationSpec(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		return new AbstractIterationElementProcessor.IterationSpec("field", "status", command.getClass().getDeclaredFields());
	}

	@Override
	public void processClonedHostIterationElement(Arguments arguments, Element element) {
		Element form = new Element("form");
		for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
			form.setAttribute(entry.getKey(), entry.getValue().getValue());
		form.setAttribute("method", "post");
		form.setAttribute("action", null);
		form.setProcessable(false);
		element.getParent().insertBefore(element, form);
		element.getParent().removeChild(element);
		
	}

	@Override
	public boolean removeHostIterationElement(Arguments arguments, Element element) {
		return false;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
