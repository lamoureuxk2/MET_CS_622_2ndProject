package main.objectSorter;

import java.io.File;

public class ChildThread extends Thread {
	
	private ObjectSorter<?> sorter;
	private File directoryIn; 
	
	public ChildThread(ObjectSorter<?> sorter, File in) {
		this.sorter = sorter; this.directoryIn = in;
	}
	
	public void run() {
		sorter.sortAllInDirectory(directoryIn);
	}

}
