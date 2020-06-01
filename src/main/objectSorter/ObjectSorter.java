package main.objectSorter;

import java.io.*;

public class ObjectSorter <T> {
	
	//Used to get generic type at runtime
	private T exampleType;
	
	public ObjectSorter(T ex) {
		exampleType = ex;
	}
	
	public String getClassName() {
		return exampleType.getClass().getName();
	}
	
	/**
	 * Reads object file, returns Object if instanceof T, null otherwise
	 * @param file
	 * @return
	 */
	public T readObjectFile(File file){
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			Object object = ois.readObject();
			
			if(object.getClass() == this.exampleType.getClass()) {
				fis.close();
				ois.close();
				return (T)object;
			}
			else {
				fis.close();
				ois.close();
				return null;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	

}
