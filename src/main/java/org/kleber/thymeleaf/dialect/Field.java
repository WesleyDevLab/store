package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Field extends AbstractDialect {

	public String getPrefix() {
		return "f";
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new org.kleber.thymeleaf.processor.field.Datalist());
		processors.add(new org.kleber.thymeleaf.processor.field.Input());
		processors.add(new org.kleber.thymeleaf.processor.field.Label());
		processors.add(new org.kleber.thymeleaf.processor.field.Select());
		processors.add(new org.kleber.thymeleaf.processor.field.Textarea());
		return processors;
	}

}
