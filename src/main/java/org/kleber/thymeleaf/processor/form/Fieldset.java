package org.kleber.thymeleaf.processor.form;

import java.util.Map;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractIterationElementProcessor;

public class Fieldset extends AbstractIterationElementProcessor {

	public Fieldset() {
		super("fieldset");
	}

	@Override
	public String getIteratedElementName(Arguments arguments, Element element) {
		return "fieldset";
	}

	@Override
	public IterationSpec getIterationSpec(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		if(command == null)
			command = arguments.getContext().getVariables().get("setting");
		return new IterationSpec("field", "status", command.getClass().getDeclaredFields());
	}

	@Override
	public void processClonedHostIterationElement(Arguments arguments, Element element) {
		Element fieldset = new Element("field-box");
		for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
			fieldset.setAttribute(entry.getKey(), entry.getValue().getValue());
		fieldset.setProcessable(false);
		element.getParent().insertBefore(element, fieldset);
		element.getParent().removeChild(element);
	}

	@Override
	public boolean removeHostIterationElement(Arguments arguments, Element element) {
		return true;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
