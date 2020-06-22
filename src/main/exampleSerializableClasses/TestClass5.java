package main.exampleSerializableClasses;

public class TestClass5 implements ExampleSerializable, Comparable<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4604886844236485955L;
	public int data1;
	
	public TestClass5() {}
	
	public TestClass5(int x) {
		data1 = x;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof TestClass5) {
			if(data1 == ((TestClass5)o).data1) return 0;
			else if(data1 > ((TestClass5)o).data1) return 1;
			else return -1;
		}
		else return 0;
		
	}
	
	@Override
	public String toString() {
		return String.valueOf(data1);
	}

}
