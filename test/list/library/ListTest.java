package list.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public abstract class ListTest {

	List<String> listString;
	List<Integer> listInteger;

	@Test
	public void testRemove1() {
		listInteger.addLast(1);
		listInteger.addLast(9);
		listInteger.addLast(9);
		listInteger.addLast(7);

		assertEquals(listInteger.toString(), "[1, 9, 9, 7]");

		listInteger.removeIndex(2);
		assertEquals(listInteger.toString(), "[1, 9, 7]");

	}

	@Test
	public void testAddAndRemove() {

		listString.addFirst("Adana");
		listString.addFirst("Ankara");
		listString.addFirst("Antalya");
		assertEquals("Antalya", listString.get(0));

		listString.addLast("Mersin");
		assertEquals(listString.toString(), "[Antalya, Ankara, Adana, Mersin]");

		listString.removeLast();
		assertEquals("Adana", listString.get(2));
		// --------------------------------------------------------------------- //
		listInteger.addFirst(1);
		listInteger.addFirst(2);
		listInteger.addFirst(8);
		listInteger.addFirst(9);
		assertEquals(listInteger.toString(), "[9, 8, 2, 1]");

		listInteger.removeIndex(2);
		assertEquals(3, listInteger.size());

		listInteger.add(2, 0);
		assertEquals(listInteger.toString(), "[9, 8, 0, 1]");

		listInteger.add(listInteger.size() - 1, 23);
		assertEquals(listInteger.toString(), "[9, 8, 0, 23, 1]");

		listInteger.addLast(98);
		assertEquals(listInteger.toString(), "[9, 8, 0, 23, 1, 98]");

		listInteger.removeFirst();
		assertEquals(listInteger.toString(), "[8, 0, 23, 1, 98]");

		listInteger.removeLast();
		assertEquals(listInteger.toString(), "[8, 0, 23, 1]");

		listInteger.removeIndex(2);
		assertEquals(listInteger.toString(), "[8, 0, 1]");

	}

	@Test
	public void testSet() {

		listString.addFirst("Edward");
		listString.addFirst("Bella");
		listString.addFirst("Jacob");

		listString.set(2, "Jane");

		assertEquals("Jacob", listString.get(0));
		assertEquals("Bella", listString.get(1));
		assertEquals("Jane", listString.get(2));

	}

	@Test
	public void testRemove() {

		listString.addLast("Karol");
		listString.addLast("Vanessa");
		listString.addLast("Amanda");

		assertEquals(listString.toString(), "[Karol, Vanessa, Amanda]");
	}

	@Test
	public void testContains() {

		listString.addLast("Karol");
		listString.addLast("Vanessa");
		listString.addLast("Amanda");
		assertTrue(listString.contains("Amanda"));

		listString.addFirst("Edward");
		listString.addFirst("Bella");
		listString.addFirst("Jacob");
		assertTrue(listString.contains("Edward"));

		listInteger.addFirst(1);
		listInteger.addFirst(2);
		listInteger.addFirst(8);
		listInteger.addFirst(9);
		assertTrue(listInteger.contains(1));
	}

	@Test
	public void testIndexOf() {
		// error
		listString.addLast("Karol");
		listString.addLast("Vanessa");
		listString.addLast("Amanda");

		// String e = "Amanda";
		// assertTrue(listString.indexOf(e));

		listString.addFirst("Edward");
		listString.addFirst("Bella");
		listString.addFirst("Jacob");
		assertTrue(listString.contains("Edward"));

		listInteger.addFirst(1);
		listInteger.addFirst(2);
		listInteger.addFirst(8);
		listInteger.addFirst(9);
		assertTrue(listInteger.contains(1));
	}

	public void testIsEmpty() {

		assertTrue(listString.isEmpty());
		assertTrue(!listInteger.isEmpty());

	}

	@Test
	public void testClearSizeEmpty() {
		listInteger.clear();
		assertTrue(listInteger.isEmpty());
	}

	@Test
	public void testEmptyToString() {
		assertEquals("[]", listString.toString());

	}

	@Test
	public void subList() {
		listString.addLast("Banana");
		listString.addLast("OliveOil");
		listString.addLast("Strawberry");
		listString.addLast("Blueberry");
		listString.addLast("Orange");
		listString.addLast("Cherry");
		listString.addLast("Apple");

		assertEquals("[Banana, OliveOil, Strawberry, Blueberry, Orange, Cherry, Apple]", listString.toString());

	}

}
