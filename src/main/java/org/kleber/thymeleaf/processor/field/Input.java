package org.kleber.thymeleaf.processor.field;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Input extends AbstractElementModelProcessor {

	public Input() {
		super(TemplateMode.HTML, null, "input", false, null, false, 0);
	}

	@Override
	public void doProcess(ITemplateContext arg0, IModel arg1, IElementModelStructureHandler arg2) {
		// TODO Auto-generated method stub
	}

}

/*public class Input extends AbstractElementProcessor {

	public Input() {
		super("input");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		if(command == null)
			command = arguments.getContext().getVariables().get("setting");
		Field field = (Field) arguments.getLocalVariable("field");
		
		if(field != null && field.getAnnotation(org.kleber.annotations.field.Input.class) != null) {
			Element input = new Element("input");
			for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
				input.setAttribute(entry.getKey(), entry.getValue().getValue());
			input.setAttribute("type", type(field));
			input.setAttribute("name", field.getName());
			input.setAttribute("value", value(command).toString());
			input.setProcessable(false);
			element.getParent().insertBefore(element, input);
			element.getParent().removeChild(element);
		}
		
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}
	
	private Object value(Object command) {
		return null;
	}
	
	private String type(Field field) {
		String annotation_name = null;
		for(Annotation annotation : field.getDeclaredAnnotations())
			if(annotation.annotationType().getPackage().getName().equals("org.kleber.annotations.input_type"))
				annotation_name = annotation.annotationType().getSimpleName().toLowerCase();
		return annotation_name;
	}

}*/
