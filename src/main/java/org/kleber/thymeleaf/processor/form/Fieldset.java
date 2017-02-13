package org.kleber.thymeleaf.processor.form;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class Fieldset extends AbstractStandardConditionalVisibilityTagProcessor {

	public Fieldset() {
		super(TemplateMode.HTML, null, "fieldset", 0);
	}

	@Override
	public boolean isVisible(ITemplateContext arg0, IProcessableElementTag arg1, AttributeName arg2, String arg3) {
		return false;
	}

	/*public Fieldset() {
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
	}*/
}
