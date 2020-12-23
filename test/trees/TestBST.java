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

public class TestBST {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private BST<Integer> bst = new BST<>();
	private BST<Integer> integerTree = new BST<>();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));

		bst.insert(5);
		bst.insert(8);
		bst.insert(6);
		bst.insert(10);
		bst.insert(1);
		bst.insert(-1);
		bst.insert(99);
		bst.insert(78);
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
		bst.clear();
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

		for (Integer e : bst) {
			System.out.print(e + " ");
		}
		Assert.assertEquals("-1 1 5 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}

	@Test
	public void isEmptyAndClearTest() {
		integerTree.insert(10);
		Assert.assertEquals(false, integerTree.isEmpty());
		integerTree.clear();
		Assert.assertEquals(true, integerTree.isEmpty());
	}

	@Test
	public void insertionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insert(23);
		integerTree.insert(98);
		integerTree.insert(3);
		integerTree.insert(65);
		integerTree.insert(44);
		integerTree.insert(7);
		integerTree.insert(71);
		integerTree.insert(39);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void recursiveInsertionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insertRecursive(23);
		integerTree.insertRecursive(98);
		integerTree.insertRecursive(3);
		integerTree.insertRecursive(65);
		integerTree.insertRecursive(44);
		integerTree.insertRecursive(7);
		integerTree.insertRecursive(71);
		integerTree.insertRecursive(39);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void recursiveInsertionTest2() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insertRecursive2(23);
		integerTree.insertRecursive2(98);
		integerTree.insertRecursive2(3);
		integerTree.insertRecursive2(65);
		integerTree.insertRecursive2(44);
		integerTree.insertRecursive2(7);
		integerTree.insertRecursive2(71);
		integerTree.insertRecursive2(39);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[3, 7, 23, 39, 44, 65, 71, 98]", list.toString());
	}

	@Test
	public void leftAndRightNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		integerTree.delete(77);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 55, 59, 67]", list.toString());

	}

	@Test
	public void leftNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		integerTree.delete(55);

		for (Integer e : integerTree) {
			list.addLast(e);
			;
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 59, 67, 77]", list.toString());

	}

	@Test
	public void rightNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		integerTree.delete(17);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 24, 55, 59, 67, 77]", list.toString());

	}

	@Test
	public void leftAndRightNotNullDeletionTest() {
		ArrayList<Integer> list = new ArrayList<>();
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		integerTree.delete(67);

		for (Integer e : integerTree) {
			list.addLast(e);
		}
		Assert.assertEquals("[2, 13, 15, 17, 24, 55, 59, 77]", list.toString());

	}

	@Test
	public void searchTest() {
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		Assert.assertEquals(true, integerTree.search(77));
		Assert.assertEquals(true, integerTree.search(24));
		Assert.assertEquals(false, integerTree.search(5));
		Assert.assertEquals(false, integerTree.search(23));

	}

	@Test
	public void recursiveSearchTest() {
		integerTree.insert(24);
		integerTree.insert(67);
		integerTree.insert(13);
		integerTree.insert(55);
		integerTree.insert(2);
		integerTree.insert(17);
		integerTree.insert(77);
		integerTree.insert(59);
		integerTree.insert(15);
		Assert.assertEquals(true, integerTree.searchRecursive(77));
		Assert.assertEquals(true, integerTree.searchRecursive(24));
		Assert.assertEquals(false, integerTree.searchRecursive(5));
		Assert.assertEquals(false, integerTree.searchRecursive(23));
	}

}
