package org.kleber.thymeleaf.processor.form;

import org.thymeleaf.standard.processor.AbstractStandardFragmentInsertionTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class Form extends AbstractStandardFragmentInsertionTagProcessor {

	public Form() {
		super(TemplateMode.HTML, null, "form", 0, true);
	}

	/*public Form() {
		super("form");
	}

	@Override
	public List<Node> computeFragment(Arguments arguments, Element element) {
		Object command = arguments.getContext().getVariables().get("command");
		if(command == null)
			command = arguments.getContext().getVariables().get("setting");
		
		Element form = new Element("form");
		for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
			form.setAttribute(entry.getKey(), entry.getValue().getValue());
		
		List<Node> list = new ArrayList<Node>();
		for(Field field : command.getClass().getDeclaredFields()) {
			for(Node node : element.getChildren()) {
				Node temp = node.cloneNode(null, true);
				temp.setNodeLocalVariable("field", field);
				list.add(temp);
			}
		}
		
		form.setProcessable(false);
		element.getParent().insertBefore(element, form);
		element.getParent().removeChild(element);
		
		return list;
	}

	@Override
	public boolean getRemoveHostNode(Arguments arguments, Element element) {
		return false;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}*/

}
