package trees;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import trees.BST;
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

public class TestBST extends TestTree {

	@Before
	public void init() {
		TreeInteger = new BST<>();
	}

}
