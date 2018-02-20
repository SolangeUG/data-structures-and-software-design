# Project 02 - Queues and Stacks

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/44fa2fc239fa479baabfb7cbac8bcfb6/c246839fafee4770975035fd1c2bed51/?child=first).

## Requirements

Implement a method that determines whether an `HTML` file is well formatted using a stack. Every time your code encounters an open tag, it should push it onto the stack; when it encounters a close tag, it should pop the tag off the top of the stack, and if they don’t match, then you’ll know the file is not well formatted.

In `HtmlValidator.java`, implement the **isValidHtml** method. **isValidHtml** should take as input a Queue of `HtmlTags` and return a Stack of `HtmlTags` that verifies the correctness of the tag structure, according to the specification below:

- if the `HTML` file is well formatted, the method should return an empty Stack
- if the HTML file is not well formatted, the method should return the Stack in its current state (i.e., with its current values) at the time the code determined that the tags were not balanced.

## Note

Do not change the signature of the isValid method (its parameter list, name, and return value type). Also, do not create any additional .java files for your solution, and please do not modify HtmlTag.java. If you need additional classes, you can define them in HtmlValidator.java. Last, be sure that your HtmlValidator class is in the default package, i.e. there is no “package” declaration at the top of the source code.
