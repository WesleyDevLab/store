package org.kleber.thymeleaf.processor.field;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Label extends AbstractElementModelProcessor {

	public Label() {
		super(TemplateMode.HTML, null, "label", false, null, false, 0);
	}

	@Override
	public void doProcess(ITemplateContext arg0, IModel arg1, IElementModelStructureHandler arg2) {
		// TODO Auto-generated method stub
	}

}

/*public class Label extends AbstractElementProcessor {

	public Label() {
		super("label");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		Field field = (Field) arguments.getLocalVariable("field");
		
		if(field != null) {
			Element label = new Element("label");
			for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
				label.setAttribute(entry.getKey(), entry.getValue().getValue());
			
			Locale currentLocale = Locale.getDefault();
			ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);
			String msg = messages.getString(field.getName());
			Text txt = new Text(msg);
			label.addChild(txt);
			
			label.setProcessable(false);
			element.getParent().insertBefore(element, label);
			element.getParent().removeChild(element);
		}
		
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}*/
