package main.exampleSerializableClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestClass1InstanceGenerator {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	public static final int AMOUNT_OF_OBJECTS_TO_GENERATE = 100;

	public static void main(String[] args) {
		ExampleSerializable[] testObjArr = testObjectArray();
		try {
			int count = 0;
			
			for(ExampleSerializable obj : testObjArr) {
				FileOutputStream fs = new FileOutputStream(EXAMPLE_OBJECT_DIRECTORY + "/example"+ count++ +".obj");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(obj);
				fs.close();
				os.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static ExampleSerializable[] testObjectArray() {
		ExampleSerializable[] array = new ExampleSerializable[AMOUNT_OF_OBJECTS_TO_GENERATE];
		for(int i = 0, cycle = 1; i < array.length; i++, cycle++) {
			if(cycle <= 1) {
				array[i] = new TestClass1(i);
			}
			else if( cycle == 2 ) {
				array[i] = new TestClass2(i);
			}
			else if( cycle == 3 ) {
				array[i] = new TestClass3(i);
			}
			else if( cycle == 4 ) {
				array[i] = new TestClass4(i);
			}
			else {
				array[i] = new TestClass5(i);
				cycle = 0;
			}
		}
		return array;
	}

}
