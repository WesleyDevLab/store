package org.kleber.settings.geral;

import org.kleber.annotation.class_type.Property;
import org.kleber.annotation.input_type.Email;
import org.kleber.annotation.input_type.Text;
import org.kleber.annotations.field.Input;

@Property
public class Geral extends org.kleber.settings.Property {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1336603477955595950L;
	
	@Input
	@Text
	private String autor;
	
	@Input
	@Email
	private String email;
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
