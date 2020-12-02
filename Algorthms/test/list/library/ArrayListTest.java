package list.library;

import org.junit.jupiter.api.BeforeEach;
import list.library.ArrayList;

public class ArrayListTest extends ListTest {

	@BeforeEach
	public void init() {
		listInteger = new ArrayList<>();
		listString = new ArrayList<>();
	}

}