package org.kleber.thymeleaf.processor.field;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

public class Fieldset extends AbstractElementProcessor {
	
	private String type;

	public Fieldset() {
		super("fieldset");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
