package list.library;

import org.junit.Before;

import collection.list.library.DoubleLinkedList;;

public class DoubleLinkedListTest extends ListTest{
	
	@Before
	public void init() {
		listInteger = new DoubleLinkedList<>();
		listString = new DoubleLinkedList<>();
	}

}
