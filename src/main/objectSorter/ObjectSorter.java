package main.objectSorter;

import java.io.*;

public class ObjectSorter <T extends Serializable> {
	
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
			System.out.println("File: " + file.getName());
			System.out.println(e);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public void writeObjToDirectory(ObjectAndFilename<?> obj, File dir) {
		String fileToWriteName = dir.getAbsolutePath() + "/" + obj.getFilename();
		File fileToWrite = new File(fileToWriteName);
		try {
			FileOutputStream fs = new FileOutputStream(fileToWrite);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(obj.getObject());
			fs.close();
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ObjectAndFilename<T> getObjectAndFilename(File file) {
		return new ObjectAndFilename<T>(this.readObjectFile(file), file.getName());
	}

}
