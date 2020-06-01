package main.exampleSerializableClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestClass1InstanceGenerator {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";

	public static void main(String[] args) {
		TestClass1 testObj = new TestClass1();
		try {
			FileOutputStream fs = new FileOutputStream(EXAMPLE_OBJECT_DIRECTORY + "/example.obj");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(testObj);
			fs.close();
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
