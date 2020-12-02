package list.library;

import org.junit.jupiter.api.BeforeEach;
import list.library.DoubleLinkedList;;

public class DoubleLinkedListTest extends ListTest{
	
	@BeforeEach
	public void init() {
		listInteger = new DoubleLinkedList<>();
		listString = new DoubleLinkedList<>();
	}

}
