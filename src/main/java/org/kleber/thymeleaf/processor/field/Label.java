package org.kleber.thymeleaf.processor.field;

public class Label {

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
