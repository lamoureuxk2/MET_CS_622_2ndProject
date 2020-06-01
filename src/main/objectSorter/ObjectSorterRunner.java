package main.objectSorter;

import main.exampleSerializableClasses.TestClass1;

public class ObjectSorterRunner {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	
	//Change generic type to class you want to test
	public static ObjectSorter<TestClass1> os = new ObjectSorter<>(new TestClass1());

	public static void main(String[] args) {
		

	}

}
