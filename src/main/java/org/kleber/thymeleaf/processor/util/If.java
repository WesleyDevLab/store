package org.kleber.thymeleaf.processor.util;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class If extends AbstractStandardConditionalVisibilityTagProcessor {

	public If() {
		super(TemplateMode.HTML, null, "if", 0);
	}

	@Override
	public boolean isVisible(ITemplateContext arg0, IProcessableElementTag arg1, AttributeName arg2, String arg3) {
		return false;
	}

}
