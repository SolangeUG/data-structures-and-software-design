# Project 04 - Binary Search Trees

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/969de2fc74c340b7917fabf78d940f65/b9d9c8350ac042e1940a37d6d31b08e7/?child=first).

## Requirements

This project uses and modifies a binary search tree (BST) implementation in order to determine whether a tree is balanced.
It is important for a BST to be balanced so that its operations can be `O(log n)` and that it does not devolve into a `LinkedList`, for which most operations are `O(n)`.

First, implement the **findNode** method: given a value that is stored in the BST, this method returns the corresponding `Node` that holds it. If the value does not exist in the BST, this method should return `null`.

Then, implement the **depth** method: given a value, this method should return the `depth` of its `Node`, which is the number of ancestors between that node and the root, including the root but not the node itself. The depth of the root is defined to be `0`. If the value is `null` or does not exist in the BST, this method should return `-1`.

Next, implement the **height** method: given a value, this method should return the `height` of its `Node`, which is the greatest number of nodes between that node and any descendant node that is a leaf, including the leaf but not the node itself. The height of a leaf node is defined to be `0`. If the input value is null or does not exist in the BST, this method should return `-1`.

Next, implement the **isBalanced(Node)** method: given a `Node`, return `true` if the absolute value of the difference in heights of its left and right children is `0` or `1`, and return `false` otherwise. If the `Node` is null or does not exist in the BST, this method should return `false`.

Finally, implement the **isBalanced()** method so that it returns `true` if **isBalanced(Node)** returns `true` for **all** nodes in the tree. Note that the root being balanced does *not* imply that the entire tree is balanced.

## Note

Do not change the signatures of these five methods, and do not create any additional `.java` files for your solution. You can, of course, add to or modify the `BinarySearchTree` class and the inner `Node` class if you’d like, but if you need additional classes, please define them in `BinarySearchTree.java`. Also, please make sure your `BinarySearchTree` class is in the default package, i.e. there is no “package” declaration at the top of the source code.
