package main.objectSorter;

import main.exampleSerializableClasses.TestClass1;
import main.exampleSerializableClasses.TestClass2;
import main.exampleSerializableClasses.TestClass3;
import main.exampleSerializableClasses.TestClass4;
import main.exampleSerializableClasses.TestClass5;

import java.io.*;

public class ObjectSorterRunnerThreading extends Thread {
	
	public static final String EXAMPLE_OBJECT_DIRECTORY = "RandomObjectFolderForTesting";
	
	//Change generic type to class you want to test
	public static ObjectSorter<TestClass1> os1 = new ObjectSorter<>(new TestClass1());
	public static ObjectSorter<TestClass2> os2 = new ObjectSorter<>(new TestClass2());
	public static ObjectSorter<TestClass3> os3 = new ObjectSorter<>(new TestClass3());
	public static ObjectSorter<TestClass4> os4 = new ObjectSorter<>(new TestClass4());
	public static ObjectSorter<TestClass5> os5 = new ObjectSorter<>(new TestClass5());
	

	public static void main(String[] args) {
		File inputDirectory = new File(EXAMPLE_OBJECT_DIRECTORY);
		
		ChildThread thread2 = new ChildThread(os2, inputDirectory);
		ChildThread thread3 = new ChildThread(os3, inputDirectory);
		ChildThread thread4 = new ChildThread(os4, inputDirectory);
		ChildThread thread5 = new ChildThread(os5, inputDirectory);
		
		thread2.start(); thread3.start(); thread4.start(); thread5.start();
		
		os1.sortAllInDirectory(inputDirectory);
		
		

	}
	
}
