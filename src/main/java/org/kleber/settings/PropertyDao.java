package org.kleber.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class PropertyDao<E extends Property> {
	
	protected Class<E> clazz;
	
	protected File file;
	
	public PropertyDao(Class<E> clazz) {
		this.clazz = clazz;
		
		try {
			this.file = File.createTempFile("geral", "properties");
		} catch (IOException e) {
			this.file = null;
		}
		
		try {
			E object = clazz.newInstance();
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public E get() throws IOException, ClassNotFoundException {
		E object = null;
		FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        object = (E) in.readObject();
        in.close();
        fileIn.close();
		return object;
	}
	
	public void set(E object) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(object);
		out.close();
		fileOut.close();
	}
	
}
