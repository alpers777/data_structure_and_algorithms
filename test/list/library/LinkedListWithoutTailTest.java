package list.library;

import org.junit.Before;

import collection.list.library.LinkedListWithoutTail;

public class LinkedListWithoutTailTest extends ListTest {

	@Before
	public void init() {
		listInteger = new LinkedListWithoutTail<>();
		listString = new LinkedListWithoutTail<>();
	}
}
