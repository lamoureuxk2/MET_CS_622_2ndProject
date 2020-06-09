package main.exampleSerializableClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestClass1InstanceGenerator {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	public static final int AMOUNT_OF_OBJECTS_TO_GENERATE = 10;

	public static void main(String[] args) {
		TestClass1 testObj = new TestClass1();
		TestClass1[] testObjArr = testObjectArray();
		try {
			
			
			for(TestClass1 obj : testObjArr) {
				FileOutputStream fs = new FileOutputStream(EXAMPLE_OBJECT_DIRECTORY + "/example"+ obj.data1 +".obj");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(obj);
				fs.close();
				os.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static TestClass1[] testObjectArray() {
		TestClass1[] array = new TestClass1[AMOUNT_OF_OBJECTS_TO_GENERATE];
		for(int i = 0; i < array.length; i++) {
			array[i] = new TestClass1(i);
		}
		return array;
	}

}
