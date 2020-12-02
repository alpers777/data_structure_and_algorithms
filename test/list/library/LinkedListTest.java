package list.library;

import org.junit.jupiter.api.BeforeEach;
import list.library.LinkedList;

public class LinkedListTest extends ListTest {

	@BeforeEach
	public void init() {
		listInteger = new LinkedList<>();
		listString = new LinkedList<>();
	}

}
