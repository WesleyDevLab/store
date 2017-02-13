package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Util extends AbstractDialect {

	protected Util() {
		super("util");
	}

	public String getPrefix() {
		return null;
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new org.kleber.thymeleaf.processor.util.If());
		processors.add(new org.kleber.thymeleaf.processor.util.List());
		return processors;
	}

}
