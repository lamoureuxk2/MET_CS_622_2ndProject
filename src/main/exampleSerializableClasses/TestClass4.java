package main.exampleSerializableClasses;

public class TestClass4 implements ExampleSerializable, Comparable<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4604886844236485955L;
	public int data1;
	
	public TestClass4() {}
	
	public TestClass4(int x) {
		data1 = x;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof TestClass4) {
			if(data1 == ((TestClass4)o).data1) return 0;
			else if(data1 > ((TestClass4)o).data1) return 1;
			else return -1;
		}
		else return 0;
		
	}

}
