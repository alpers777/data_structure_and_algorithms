package list.library;

import org.junit.Before;

public class LinkedListWithoutTailTest extends ListTest {

	@Before
	public void init() {
		listInteger = new LinkedListWithoutTail<>();
		listString = new LinkedListWithoutTail<>();
	}
}
