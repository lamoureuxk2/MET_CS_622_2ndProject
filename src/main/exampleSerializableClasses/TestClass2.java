package main.exampleSerializableClasses;

public class TestClass2 implements ExampleSerializable, Comparable<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4604886844236485955L;
	public int data1;
	
	public TestClass2() {}
	
	public TestClass2(int x) {
		data1 = x;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof TestClass2) {
			if(data1 == ((TestClass2)o).data1) return 0;
			else if(data1 > ((TestClass2)o).data1) return 1;
			else return -1;
		}
		else return 0;
		
	}

}
