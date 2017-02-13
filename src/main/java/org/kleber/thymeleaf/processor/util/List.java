package org.kleber.thymeleaf.processor.util;

public class List {

	/*public List() {
		super("list");
	}

	@Override
	public String getIteratedElementName(Arguments arguments, Element element) {
		return "list";
	}

	@Override
	public IterationSpec getIterationSpec(Arguments arguments, Element element) {
		String item = element.getAttributeValue("item");
		return new IterationSpec("item", "status", this.getList(item));
	}

	@Override
	public void processClonedHostIterationElement(Arguments arguments, Element element) {
		String item = element.getAttributeValue("item");
		Class<?> classe = this.getClasse(item);
		Element list = new Element(classe.getSimpleName());
		list.setProcessable(false);
		element.getParent().insertBefore(element, list);
		element.getParent().removeChild(element);
	}

	@Override
	public boolean removeHostIterationElement(Arguments arguments, Element element) {
		String remove = element.getAttributeValue("remove");
		if(remove == null || remove.equals("sim"))
			return true;
		return false;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}
	
	public Class<?> getClasse(String item) {
		return null;
	}
	
	public List getList(String item) {
		return null;
	}*/

}
