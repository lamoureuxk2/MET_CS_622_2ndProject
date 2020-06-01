package main.objectSorter;

import main.exampleSerializableClasses.TestClass1;
import java.io.*;

public class ObjectSorterRunner {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	
	//Change generic type to class you want to test
	public static ObjectSorter<TestClass1> os = new ObjectSorter<>(new TestClass1());

	public static void main(String[] args) {
		String className = os.getClassName();
		File directory = new File(className + "_folder");
		
		//Makes folder for objects if it doesnt exist
		if(!directory.exists()) {
			directory.mkdir();
		}

	}

}
