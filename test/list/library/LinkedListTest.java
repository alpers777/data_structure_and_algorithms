package list.library;

import org.junit.Before;

import collection.list.library.LinkedList;

public class LinkedListTest extends ListTest {

	@Before
	public void init() {
		listInteger = new LinkedList<>();
		listString = new LinkedList<>();
	}

}
