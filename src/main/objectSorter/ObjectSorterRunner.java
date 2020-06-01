package main.objectSorter;

import main.exampleSerializableClasses.TestClass1;
import java.io.*;

public class ObjectSorterRunner {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	
	//Change generic type to class you want to test
	public static ObjectSorter<TestClass1> os = new ObjectSorter<>(new TestClass1());

	public static void main(String[] args) {
		String className = os.getClassName();
		File outputDirectory = new File(className + "_folder");
		File inputDirectory = new File(EXAMPLE_OBJECT_DIRECTORY);
		
		//Makes folder for objects if it does not exist
		if(!outputDirectory.exists()) {
			outputDirectory.mkdir();
		} 
		
		for(File file : inputDirectory.listFiles()) {
			ObjectAndFilename<?> objAndName = os.getObjectAndFilename(file);
			if(objAndName.isNotNull()) {
				objAndName.writeObjToDirectory(outputDirectory);
			}
		}

	}
	
	

}
