package trees;

import collection.list.library.ArrayList;

public class AVL<E extends Comparable<E>> extends BST<E> {

	@Override /** Insert an element and rebalance if necessary */
	public boolean insert(E e) {
		if (super.insert(e)) {
			balancePath(e); // Balance from e to the root if necessary
			return true; // e is inserted
		}
		return false;
	}

	public boolean delete(E element) {
		super.delete(element);

		if (root == null)
			return false; // Element is not in the tree

		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (element.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (element.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left children (See Figure 23.6)
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (element.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;

				// Balance the tree if necessary
				balancePath(parent.element);
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
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
				// Special case: parentOfRightMost is current
				parentOfRightMost.left = rightMost.left;

			// Balance the tree if necessary
			balancePath(parentOfRightMost.element);
		}
		
		size--;
	    return true; // Element inserted
	}

	private void balancePath(E e) {
		ArrayList<AVLTreeNode<E>> path = path(e);
		for (int i = path.size() - 1; i >= 0; i--) {
			AVLTreeNode<E> A = path.get(i);
			updateHeight(A);

			int balanceFactor = balanceFactor(A);

			if (Math.abs(balanceFactor) == 2) {
				AVLTreeNode<E> parentOfA = (i > 0) ? path.get(i - 1) : null;
				if (balanceFactor == 2) {
					if (balanceFactor((AVLTreeNode<E>) A.right) >= 0) {
						balanceRR(A, parentOfA); // Perform RR rotation
					} else {
						balanceRL(A, parentOfA); // Perform RL rotation
					}
				} else { // balanceFactor == -2
					if (balanceFactor((AVLTreeNode<E>) A.left) <= 0) {
						balanceLL(A, parentOfA); // Perform LL rotation
					} else {
						balanceLR(A, parentOfA); // Perform LR rotation
					}
				}
			}

		}
	}

	private void balanceRR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
		AVLTreeNode<E> B = (AVLTreeNode<E>) A.right; // A is right-heavy and B is right-heavy

		if (A == root) {
			root = B;
		} else {
			if (parentOfA.left == A) {
				parentOfA.left = B;
			} else {
				parentOfA.right = B;
			}
		}

		A.right = B.left; // Make T2 the right subtree of A
		B.left = A;
		updateHeight(A);
		updateHeight(B);

	}

	private void balanceLR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
		AVLTreeNode<E> B = (AVLTreeNode<E>) A.left; // A is left-heavy
		AVLTreeNode<E> C = (AVLTreeNode<E>) B.right; // B is right-heavy

		if (A == root) {
			root = C;
		} else {
			if (parentOfA.left == A) {
				parentOfA.left = C;
			} else {
				parentOfA.right = C;
			}
		}

		A.left = C.right; // Make T3 the left subtree of A
		B.right = C.left; // Make T2 the right subtree of B
		C.left = B;
		C.right = A;

		// Adjust heights
		updateHeight(A);
		updateHeight(B);
		updateHeight(C);
	}

	private void balanceLL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
		AVLTreeNode<E> B = (AVLTreeNode<E>) A.left; // A is left-heavy and B is left-heavy

		if (A == root) {
			root = B;
		} else {
			if (parentOfA.left == A) {
				parentOfA.left = B;
			} else {
				parentOfA.right = B;
			}
		}

		A.left = B.right; // Make T2 the left subtree of A
		B.right = A; // Make A the left child of B
		updateHeight(A);
		updateHeight(B);

	}

	private void balanceRL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
		AVLTreeNode<E> B = (AVLTreeNode<E>) A.right; // A is right-heavy
		AVLTreeNode<E> C = (AVLTreeNode<E>) B.left; // B is left-heavy

		if (A == root) {
			root = C;
		} else {
			if (parentOfA.left == A) {
				parentOfA.left = C;
			} else {
				parentOfA.right = C;
			}
		}

		A.right = C.left; // Make T2 the right subtree of A
		B.left = C.right; // Make T3 the left subtree of B
		C.left = A;
		C.right = B;

		// Adjust heights
		updateHeight(A);
		updateHeight(B);
		updateHeight(C);

	}

	/** Return the balance factor of the node */
	private int balanceFactor(AVLTreeNode<E> node) {
		if (node.right == null) // node has no right subtree
			return -node.height;
		else if (node.left == null) // node has no left subtree
			return +node.height;
		else
			return ((AVLTreeNode<E>) node.right).height - ((AVLTreeNode<E>) node.left).height;
	}

	/** Update the height of a specified node */
	private void updateHeight(AVLTreeNode<E> node) {
		if (node.left == null && node.right == null) // node is a leaf
			node.height = 0;
		else if (node.left == null) // node has no left subtree
			node.height = 1 + ((AVLTreeNode<E>) (node.right)).height;
		else if (node.right == null) // node has no right subtree
			node.height = 1 + ((AVLTreeNode<E>) (node.left)).height;
		else
			node.height = 1 + Math.max(((AVLTreeNode<E>) (node.right)).height, ((AVLTreeNode<E>) (node.left)).height);
	}

	/** Returns a path from the root leading to the specified element */
	private ArrayList<AVLTreeNode<E>> path(E e) {
		ArrayList<AVLTreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.addLast((AVLTreeNode<E>) current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array list of nodes
	}

	protected TreeNode<E> createNewNode(E e) {
		return new AVLTreeNode<>(e);
	}

	/** AVLTreeNode is TreeNode plus height */
	protected static class AVLTreeNode<E> extends BST.TreeNode<E> {
		protected int height = 0; // New data field

		public AVLTreeNode(E o) {
			super(o);
		}
	}

}
