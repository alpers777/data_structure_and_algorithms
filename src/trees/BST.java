package trees;

import java.util.Iterator;
import java.util.function.Consumer;

import collection.list.library.ArrayList;
import collection.list.library.List;

public class BST<E extends Comparable<E>> implements Iterable<E> {

	protected TreeNode<E> root;

	protected int size;

	// O(1)
	public int size() {
		return size;
	}

	// O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	public void clear() {
		size = 0;
		root = null;
	}

	// O(logn)
	public boolean insert(E element) {
		if (isEmpty()) {
			root = createNewNode(element);
			size++;
			return true;
		}

		TreeNode<E> parrent = null;
		TreeNode<E> currentNode = root;

		while (currentNode != null) {
			if (element.compareTo(currentNode.element) > 0) {
				parrent = currentNode;
				currentNode = currentNode.right;
			} else if (element.compareTo(currentNode.element) < 0) {
				parrent = currentNode;
				currentNode = currentNode.left;
			} else
				return false; // Equals
		}

		if (element.compareTo(parrent.element) > 0)
			parrent.right = createNewNode(element);
		else if (element.compareTo(parrent.element) < 0)
			parrent.left = createNewNode(element);

		size++;

		return true;
	}

	// O(logn)
	public boolean insertRecursive(E element) {
		if (isEmpty()) {
			root = createNewNode(element);
			size++;
			return true;
		}

		return insertRecursiveHeper(element, root);
	}

	// O(logn)
	private boolean insertRecursiveHeper(E element, TreeNode<E> parrent) {
		if (element.compareTo(parrent.element) > 0) {
			if (parrent.right == null) {
				parrent.right = createNewNode(element);
				size++;
				return true;
			} else
				return insertRecursiveHeper(element, parrent.right);
		} else if (element.compareTo(parrent.element) < 0) {
			if (parrent.left == null) {
				parrent.left = createNewNode(element);
				size++;
				return true;
			} else
				return insertRecursiveHeper(element, parrent.left);
		} else
			return false; // Equals

	}

	// O(logn)
	public void insertRecursive2(E element) {
		root = insertRecursiveHeper2(element, root);
	}

	// O(logn)
	private TreeNode<E> insertRecursiveHeper2(E element, TreeNode<E> parrent) {
		if (parrent == null) {
			size++;
			return createNewNode(element);
		}

		if (element.compareTo(parrent.element) > 0) {
			parrent.right = insertRecursiveHeper2(element, parrent.right);
		} else if (element.compareTo(parrent.element) < 0) {
			parrent.left = insertRecursiveHeper2(element, parrent.left);
		}

		return parrent; // Equals

	}

	public boolean search(E element) {
		TreeNode<E> currentNode = root;
		while (currentNode != null) {
			if (element.compareTo(currentNode.element) > 0)
				currentNode = currentNode.right;
			else if (element.compareTo(currentNode.element) < 0)
				currentNode = currentNode.left;
			else
				return true; // Equals
		}

		return false;
	}

	public boolean searchRecursive(E element) {
		return searchRecursiveHelper(element, root);
	}

	private boolean searchRecursiveHelper(E element, TreeNode<E> currentNode) {
		if (currentNode == null)
			return false;

		if (element.compareTo(currentNode.element) > 0)
			return searchRecursiveHelper(element, currentNode.right);
		else if (element.compareTo(currentNode.element) < 0)
			return searchRecursiveHelper(element, currentNode.left);
		else
			return true; // Equals
	}

	public boolean delete(E element) {
		if (isEmpty())
			return false;

		TreeNode<E> parent = null;
		TreeNode<E> current = root;

		while (current != null) {
			if (element.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else if (element.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else {
				delete(parent, current); // Equals
				break;
			}
		}

		return false;

	}

	private void delete(TreeNode<E> parent, TreeNode<E> current) {

		// Case 1 left and right are null
		if (current.left == null && current.right == null) {
			if (current == root) { // or parent == null
				root = null;
			} else if (parent.left == current) {
				parent.left = null;
			} else { // (parrent.right == current) is true
				parent.right = null;
			}
		}
		// Case 2 left is null right is not null
		else if (current.left == null && current.right != null) {
			if (current == root) { // or parent == null
				root = current.right;
			} else if (parent.left == current) {
				parent.left = current.right;
			} else { // (parrent.right == current) is true
				parent.right = current.right;
			}
		}
		// Case 3 left is not null right is null
		else if (current.left != null && current.right == null) {
			if (current == root) { // or parent == null
				root = current.left;
			} else if (parent.left == current) {
				parent.left = current.left;
			} else { // (parrent.right == current) is true
				parent.right = current.left;
			}
		}
		// Case 4 left is not null right is not null
		else { // (current.left != null && current.right != null) is true
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;

	}

	/** Inorder traversal from the root */
	public void inorder(Consumer<E> consumer) {
		inorderHelper(root, consumer);
	}

	private void inorderHelper(TreeNode<E> node, Consumer<E> consumer) {
		if (node == null)
			return;

		inorderHelper(node.left, consumer);
		consumer.accept(node.element);
		inorderHelper(node.right, consumer);

	}

	/** Postorder traversal from the root */
	public void postorder(Consumer<E> consumer) {
		postorderHelper(root, consumer);
	}

	private void postorderHelper(TreeNode<E> node, Consumer<E> consumer) {
		if (node == null)
			return;

		inorderHelper(node.left, consumer);
		inorderHelper(node.right, consumer);
		consumer.accept(node.element);
	}

	/** Preorder traversal from the root */
	public void preorder(Consumer<E> consumer) {
		preorderHelper(root, consumer);
	}

	private void preorderHelper(TreeNode<E> node, Consumer<E> consumer) {
		if (node == null)
			return;

		consumer.accept(node.element);
		inorderHelper(node.left, consumer);
		inorderHelper(node.right, consumer);
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}

	protected static class TreeNode<E> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		TreeNode(E e) {
			element = e;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new InorderIterrator();
	}

	class InorderIterrator implements Iterator<E> {

		private List<E> list = new ArrayList<E>();
		private int currenIndex;

		public InorderIterrator() {
			inorder(root);
		}

		private void inorder(TreeNode<E> node) {
			if (node == null)
				return;

			inorder(node.left);
			list.addLast(node.element);
			inorder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currenIndex < list.size();
		}

		@Override
		public E next() {
			return list.get(currenIndex++);
		}

	}

}
