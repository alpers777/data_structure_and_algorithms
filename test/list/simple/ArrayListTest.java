package list.simple;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void arrayListTest() {
		ArrayList list = new ArrayList();
		list.isEmpty();
		list.addFirst(5);
		list.isEmpty();
		list.addLast(7);
		list.addLast(2);
		list.indexOf(2);
		list.addLast(15);
		list.addLast(2);
		list.lastIndexOf(2);
		list.removeElement(2);
		list.contains(2);
		list.removeFirst();
		list.contains(5);
		list.addLast(33);
		list.indexOf(33);
		list.addLast(45);
		list.addLast(33);
		list.lastIndexOf(33);
		list.get(4);
		list.get(list.size() - 1);
		list.size();
		list.removeIndex(2);
		list.size();
		list.clear();
		list.isEmpty();
		
		
	}

}
