/**
 * Class that represents generic binary search trees.
 * @param <E> element type
 * @author Solange U. Gasengayire
 */
public class BinarySearchTree<E extends Comparable<E>> {
	/**
	 * Represents a node of the tree
	 */
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;

		Node(E value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof BinarySearchTree.Node))
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;

	/**
	 * Mark node n as visited
	 * @param n input node
	 */
	protected void visit(Node n) {
		System.out.println(n.value);
	}

	/**
	 * Determine whether the tree contains a given value
	 * @param val the value to look for
	 * @return true if there is a node with the value
	 * 		   false otherwise
	 */
	public boolean contains(E val) {
		return contains(root, val);
	}

	/**
	 * Determine whether the subtree from Node n contains a given value
	 * @param n the root node of the subtree
	 * @param val the value to look for
	 * @return true if the value is found in the subtree
	 * 		   false otherwise
	 */
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}

	/**
	 * Add a value to the tree
	 * @param val value to be added
	 * @return true if the value was successfully added
	 * 		   false otherwise
	 */
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}

	/**
	 * Add a value to the given's node's subtree
	 * @param n the root node of the subtree
	 * @param val the value to be added
	 * @return true if the value was successfully added
	 * 		   false otherwise
	 */
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			// this ensures that the same value does not appear more than once
			return false;
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}

	/**
	 * Remove a given value from the tree
	 * @param val value to be removed
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	public boolean remove(E val) {
		return remove(root, null, val);
	}

	/**
	 * Remove a given node from a tree
	 * @param n the node to be removed
	 * @param parent its parent node
	 * @param val the value of the node to be removed
	 * @return true if the operation succeeds
	 * 		   false otherwise
	 */
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) < 0) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) > 0) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	/**
	 * Return the maximum value of a given node's subtree
	 * @param n the root node of the subtree
	 * @return the maximum value in the subtree
	 */
	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/* ***********************************************
	 * 												 *
	 * 			IMPLEMENT THE METHODS BELOW!		 *
	 *											 	 *
	 * ***********************************************/


	/**
	 * Return the node with a given value from the tree
	 * @param val the value to look for
	 * @return the node with the specified value if it exists
	 * 		   null otherwise
	 */
	public Node findNode(E val) {
		return findNode(root, val);
	}

	/**
	 * Return the node with a given value from a given subtree
	 * @param node the root node of the subtree
	 * @param val the value to look for
	 * @return the node with the specified value if found in the subtree
	 * 		   null otherwise
	 */
	private Node findNode(Node node, E val) {

		if (node != null && val != null) {
			if (val.equals(node.value)) {
				return node;
			} else if (val.compareTo(node.value) > 0) {
				return findNode(node.rightChild, val);
			} else if (val.compareTo(node.value) < 0) {
				return findNode(node.leftChild, val);
			}
		}

		return null;
	}

	/**
	 * Return the depth of the node with the given value
	 * @param val the input value
	 * @return the depth of the value in the tree
	 * 		   or -1 if the value is not found in the tree
	 */
	protected int depth(E val) {
		return depth(root, val);
	}

	/**
	 * Return the depth of a given value from the root node of a subtree
	 * @param node the root node of the subtree
	 * @param val the value to look for
	 * @return the depth of the value in the subtree
	 * 		   or -1 if the value is not found in the subtree
	 */
	private int depth(Node node, E val) {
		if (node != null && findNode(val) != null) {
			if (val.equals(node.value)) {
				return 0;
			} else if (val.compareTo(node.value) > 0) {
				return 1 + depth(node.rightChild, val);
			} else if (val.compareTo(node.value) < 0) {
				return 1 + depth(node.leftChild, val);
			}
		}
		return -1;
	}

	/**
	 * Return the height of a given value in a tree
	 * @param val the input value
	 * @return the height of node with the input value
	 * 		   or -1 if the value is not found in the tree
	 */
	protected int height(E val) {
		Node valNode = findNode(val);
		if (valNode != null) {
			return height(valNode);
		}
		return -1;
	}

	/**
	 * Return the height of a given value from the root node of a subtree
	 * @param node the root node of the subtree
	 * @return the height of node with the input value
	 * 		   or -1 if the value is not found in the tree
	 */
	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = 0;
		int rightHeight = 0;

		// explore the left subtree if applicable
		if (node.leftChild != null) {
			leftHeight = 1 + height(node.leftChild);
		}

		// explore the right subtree if applicable
		if (node.rightChild != null) {
			rightHeight = 1 + height(node.rightChild);
		}

		// return the maximum calculated height from both subtrees
		return Math.max(leftHeight, rightHeight);
	}


	/**
	 * Determine whether the subtree from Node n is balanced
	 * @param n the root node of the subtree
	 * @return true if the absolute value of the difference in heights of its left and right children is 0 or 1
	 * 		   false otherwise
	 */
	protected boolean isBalanced(Node n) {
		// case when n is null or not in the tree
		if (n == null || !contains(n.value)) {
			return false;
		}

		// compute heights of left and right subtrees
		int leftHeight = height(n.leftChild);
		int rightHeight = height(n.rightChild);

		// absolute value of difference must be 0 or 1
		return Math.abs(leftHeight - rightHeight) <= 1;
	}

	/**
	 * Determine whether the whole BS tree is balanced
	 * @return true if isBalanced(Node n) is true for all the nodes of the tree
	 * 		   false otherwise
	 */
	public boolean isBalanced() {

		if (root != null) {
			boolean result = isBalanced(root);

			// no need to continue if the root is not balanced
			if (!result) {
				return false;
			}

			if (root.leftChild != null) {
				// is the left subtree balanced?
				root = root.leftChild;
				result = isBalanced();
			}

			// no need to continue if left subtree is not balanced
			if (!result) {
				return false;
			}

			if (root.rightChild != null) {
				root = root.rightChild;
				result = isBalanced();
			}
			return result;
		}
		return false;
	}

	/**
	 * Tester method
	 * @param args program arguments
	 */
	public static void main(String[] args) {

		boolean treeBal;
		boolean nodeBal;
		BinarySearchTree<String> bst = new BinarySearchTree<>();
		bst.add("dog");
		bst.add("cat");
		bst.add("pig");

		treeBal = bst.isBalanced();
		System.out.println("TRUE | Is tree(dog, cat, pig) balanced? " + treeBal);

		bst.add("ant");
		treeBal = bst.isBalanced();
		System.out.println("TRUE | Is tree(dog, cat, pig, ant) balanced? " + treeBal);

		bst.add("skunk");
		treeBal = bst.isBalanced();
		System.out.println("TRUE | Is tree(dog, cat, pig, skunk) balanced? " + treeBal);

		bst.add("skunk");
		bst.add("zebra");
		treeBal = bst.isBalanced();
		System.out.println("FALSE | Is tree(dog, cat, pig, skunk, zebra) balanced? " + treeBal);

		bst.add("ant");
		bst.add("aah!");
		treeBal = bst.isBalanced();
		System.out.println("FALSE | Is tree(dog, cat, pig, ant, aah!) balanced? " + treeBal);

		bst.add("ant");
		bst.add("aah!");

		nodeBal = bst.isBalanced(bst.findNode("dog"));
		System.out.println("FALSE | Is node(dog) balanced? " + nodeBal);

		bst.add("skunk");
		bst.add("zebra");
		treeBal = bst.isBalanced();
		System.out.println("FALSE | Is tree(dog, cat, pig, ant, aah!, skunk, zebra) balanced? " + treeBal);

		String[] values = {"dog", "cat", "pig", "ant", "aah!", "skunk", "zebra"};
		for (String value: values) {
			int ht = bst.height(bst.findNode(value));
			System.out.println("Height of node(" + value + ") is " + ht);

			nodeBal = bst.isBalanced(bst.findNode(value));
			System.out.println("Is node(" + value + ") balanced? " + nodeBal);
		}

		nodeBal = bst.isBalanced(bst.findNode("ant"));
		System.out.println("FALSE | Is node(ant) balanced? " + nodeBal);
	}

}
