package list.generic;

import org.junit.Test;

public class GenArrayListTest {

	@Test
	public void genArrayListTest() {
		GenArrayList<Integer> intList = new GenArrayList<>();
		intList.isEmpty();
		intList.addFirst(5);
		intList.isEmpty();
		intList.addLast(7);
		intList.addLast(2);
		intList.indexOf(2);
		intList.addLast(15);
		intList.addLast(2);
		intList.lastIndexOf(2);
		intList.removeElement(2);
		intList.contains(2);
		intList.removeFirst();
		intList.contains(5);
		intList.addLast(33);
		intList.indexOf(33);
		intList.addLast(45);
		intList.addLast(33);
		intList.lastIndexOf(33);
		intList.get(4);
		intList.get(intList.size() - 1);
		intList.size();
		intList.removeIndex(2);
		intList.size();
		intList.clear();
		intList.isEmpty();
		for(int i = 0; i < 17; i++) {
			intList.addLast((int)(Math.random() * 50));
		}
		intList.size();
		
		GenArrayList<String> stringList = new GenArrayList<>();
		stringList.isEmpty();
		stringList.addFirst("New York");
		stringList.isEmpty();
		stringList.addLast("San Francisco");
		stringList.addLast("Boston");
		stringList.addLast("Seattle");
		stringList.indexOf("New York");
		stringList.addLast("Chicago");
		stringList.addFirst("Portland");
		stringList.addLast("Portland");
		stringList.lastIndexOf("Portland");
		stringList.removeElement("Portland");
		stringList.contains("Portland");
		stringList.removeFirst();
		stringList.contains("New York");
		stringList.addLast("Los Angeles");
		stringList.indexOf("Los Angeles");
		stringList.addLast("Dallas");
		stringList.addLast("Los Angeles");
		stringList.lastIndexOf("Los Angeles");
		stringList.get(4);
		stringList.get(stringList.size() - 1);
		stringList.size();
		stringList.removeIndex(2);
		stringList.size();
		stringList.clear();
		stringList.isEmpty();
		
	}

}
