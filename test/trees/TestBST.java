package trees;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBST {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	private BST<Integer> bst = new BST<>();
	
	@BeforeEach
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
	
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	    bst.clear();
	}

	@Test
	public void inorderTest() {
		bst.inorder(e -> System.out.print(e + " "));
		Assert.assertEquals("-1 1 5 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void preorderTest() {
		bst.preorder(e -> System.out.print(e + " "));
		Assert.assertEquals("5 -1 1 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void postorderTest() {
		bst.postorder(e -> System.out.print(e + " "));
		Assert.assertEquals("-1 1 6 8 10 78 99 5", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void iteroterTest() {
		
		for (Integer e : bst) {
			System.out.print(e + " ");
		}
		Assert.assertEquals("-1 1 5 6 8 10 78 99", outputStreamCaptor.toString().trim());
	}

}
