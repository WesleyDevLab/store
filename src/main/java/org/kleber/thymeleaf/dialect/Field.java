package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.kleber.thymeleaf.processor.field.Datalist;
import org.kleber.thymeleaf.processor.field.Input;
import org.kleber.thymeleaf.processor.field.Label;
import org.kleber.thymeleaf.processor.field.Select;
import org.kleber.thymeleaf.processor.field.Textarea;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Field extends AbstractDialect {

	public Field() {
		super("field");
	}

	public String getPrefix() {
		return null;
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new Datalist());
		processors.add(new Input());
		processors.add(new Label());
		processors.add(new Select());
		processors.add(new Textarea());
		return processors;
	}

}
