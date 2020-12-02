package list.library;

import org.junit.jupiter.api.BeforeEach;
import list.library.LinkedListWithoutTail;

public class LinkedListWithoutTailTest extends ListTest {
	@BeforeEach
	public void init() {
		listInteger = new LinkedListWithoutTail<>();
		listString = new LinkedListWithoutTail<>();
	}
}
