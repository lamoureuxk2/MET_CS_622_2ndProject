package main.objectSorter;

import java.io.*;

public class ObjectAndFilename <T> implements Comparable {

	private T object;
	private String filename;
	
	ObjectAndFilename(T obj, String fn){
		setObject(obj); setFilename(fn);
	}
	
	@Override
	public int compareTo(Object o) {
		if(object instanceof Comparable) {
			return ((Comparable)(this.object)).compareTo(o);
		}
		else return 0;
	}
	
	public void writeObjToDirectory(File dir) {
		String fileToWriteName = dir.getAbsolutePath() + "/" + filename;
		File fileToWrite = new File(fileToWriteName);
		try {
			FileOutputStream fs = new FileOutputStream(fileToWrite);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this.object);
			fs.close();
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isNotNull() {
		return object != null;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
