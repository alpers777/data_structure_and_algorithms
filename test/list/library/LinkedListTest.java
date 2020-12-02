package list.library;

import org.junit.Before;

public class LinkedListTest extends ListTest {

	@Before
	public void init() {
		listInteger = new LinkedList<>();
		listString = new LinkedList<>();
	}

}
