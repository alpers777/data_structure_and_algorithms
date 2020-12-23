package list.library;

import org.junit.Before;

import collection.list.library.ArrayList;

public class ArrayListTest extends ListTest {

	@Before
	public void init() {
		listInteger = new ArrayList<>();
		listString = new ArrayList<>();
	}

}