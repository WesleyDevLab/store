package org.kleber.thymeleaf.processor.field;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Select extends AbstractElementModelProcessor {

	public Select() {
		super(TemplateMode.HTML, null, "datalist", false, null, false, 0);
	}

	@Override
	public void doProcess(ITemplateContext arg0, IModel arg1, IElementModelStructureHandler arg2) {
		// TODO Auto-generated method stub
	}

}
