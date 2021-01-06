package trees;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
*/
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import collection.list.library.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TestTree {

	BST<Integer> TreeInteger;

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));

		TreeInteger.insert(5);
		TreeInteger.insert(8);
		TreeInteger.insert(6);
		TreeInteger.insert(10);
		TreeInteger.insert(1);
		TreeInteger.insert(-1);
		TreeInteger.insert(99);
		TreeInteger.insert(78);
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
		TreeInteger.clear();
	}

	@Test
	public void inorderTest() {
//		bst.inorder(e -> System.out.print(e + " "));
		Assert.assertEquals("-1 1 5 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}

	@Test
	public void preorderTest() {
//		bst.preorder(e -> System.out.print(e + " "));
		Assert.assertEquals("5 -1 1 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}

	@Test
	public void postorderTest() {
//		bst.postorder(e -> System.out.print(e + " "));
		Assert.assertEquals("-1 1 6 8 10 78 99 5", outputStreamCaptor.toString().trim());
	}

	@Test
	public void iteratorTest() {

		for (Integer e : TreeInteger) {
			System.out.print(e + " ");
		}
		Assert.assertEquals("-1 1 5 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}

	@Test
	public void isEmptyAndClearTest() {
		TreeInteger.insert(10);
		Assert.assertEquals(false, TreeInteger.isEmpty());
		TreeInteger.clear();
		Assert.assertEquals(true, TreeInteger.isEmpty());
	}

	@Test
	public void insertionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insert(23);
		TreeInteger.insert(98);
		TreeInteger.insert(3);
		TreeInteger.insert(65);
		TreeInteger.insert(44);
		TreeInteger.insert(7);
		TreeInteger.insert(71);
		TreeInteger.insert(39);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void recursiveInsertionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insertRecursive(23);
		TreeInteger.insertRecursive(98);
		TreeInteger.insertRecursive(3);
		TreeInteger.insertRecursive(65);
		TreeInteger.insertRecursive(44);
		TreeInteger.insertRecursive(7);
		TreeInteger.insertRecursive(71);
		TreeInteger.insertRecursive(39);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void recursiveInsertionTest2() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insertRecursive2(23);
		TreeInteger.insertRecursive2(98);
		TreeInteger.insertRecursive2(3);
		TreeInteger.insertRecursive2(65);
		TreeInteger.insertRecursive2(44);
		TreeInteger.insertRecursive2(7);
		TreeInteger.insertRecursive2(71);
		TreeInteger.insertRecursive2(39);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void leftAndRightNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		TreeInteger.delete(77);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 55, 59, 67]", list.toString());

	}

	@Test
	public void leftNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		TreeInteger.delete(55);

		for (Integer e : TreeInteger) {
			list.addLast(e);
			;
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 59, 67, 77]", list.toString());

	}

	@Test
	public void rightNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		TreeInteger.delete(17);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 24, 55, 59, 67, 77]", list.toString());

	}

	@Test
	public void leftAndRightNotNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		TreeInteger.delete(67);

		for (Integer e : TreeInteger) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 55, 59, 77]", list.toString());

	}

	@Test
	public void searchTest() {
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		Assert.assertEquals(true, TreeInteger.search(77));
		Assert.assertEquals(true, TreeInteger.search(24));
		Assert.assertEquals(false, TreeInteger.search(5));
		Assert.assertEquals(false, TreeInteger.search(23));

	}

	@Test
	public void recursiveSearchTest() {
		TreeInteger.insert(24);
		TreeInteger.insert(67);
		TreeInteger.insert(13);
		TreeInteger.insert(55);
		TreeInteger.insert(2);
		TreeInteger.insert(17);
		TreeInteger.insert(77);
		TreeInteger.insert(59);
		TreeInteger.insert(15);
		Assert.assertEquals(true, TreeInteger.searchRecursive(77));
		Assert.assertEquals(true, TreeInteger.searchRecursive(24));
		Assert.assertEquals(false, TreeInteger.searchRecursive(5));
		Assert.assertEquals(false, TreeInteger.searchRecursive(23));
	}

}
