package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Field extends AbstractDialect {

	public String getPrefix() {
		return null;
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		//processors.add(new Datalist());
		//processors.add(new Input());
		//processors.add(new Label());
		//processors.add(new Select());
		//processors.add(new Textarea());
		return processors;
	}

}
