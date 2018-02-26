# Project 06 - Graphs

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/969de2fc74c340b7917fabf78d940f65/f0fa49ad9e284346ad3b863250a8526b/?child=first).

## Requirements

**This project implements methods used for exploring graphs.**

Implement the following methods in the `GraphUtils.java` class:

1. **minDistance** : given a Graph, this method returns the `shortest distance` (in terms of number of edges) from the node labeled *src* to the node labeled *dest*.
The method should return -1 for any invalid inputs, including:
	- `null` values for the Graph, *src*, or *dest*;
	- there is no node labeled *src* or *dest* in the graph;
	- there is no path from *src* to *dest*.


2. **nodesWithinDistance** : given a Graph, this method returns a Set of the values of all nodes within the specified distance (in terms of number of edges) of the node labeled *src*, i.e. for which the minimum number of edges from *src* to that node is less than or equal to the specified distance. The value of the node itself should not be in the Set, even if there is an edge from the node to itself.
The method should return null for any invalid inputs, including:
	- `null` values for the Graph or *src*;
	- there is no node labeled *src* in the graph;
	- distance less than 1.
However, if distance is greater than or equal to 1 and there are no nodes within that distance (meaning: *src* is the only node in the graph), the method should return an empty Set.

3. **isHamiltonianPath** : given a Graph, this method indicates whether the List of node values represents a Hamiltonian Path. A `Hamiltonian Path` is a valid path through the graph in which every node in the graph is visited **exactly once**, except for the start and end nodes, which are the same, so that it is a cycle. If the values in the input List represent a Hamiltonian Path, the method should return true, but the method should return false otherwise (including when the input Graph or List is `null`).

## Note

Please do not change the signature of any of the three methods, and please do not create any additional `.java` files for your solution; if you need additional classes, you can define them in `GraphUtils.java`. You may modify `BreadthFirstSearch.java` and/or `DepthFirstSearch.java` as part of your solution but please do not modify any of the other code that we distributed. Last, please be sure that all code  is in the default package, i.e. there is no “package” declaration at the top of the source code.
