# Project 10 - Reliability

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/2762c877e0824a62b88cc161cffe401b/36272b673f7344789c48933017e18d71/?child=first).

## Requirements

This project relates to a simple social networking concept: suggesting friends to a student based on who is taking the same classes. The objective is to use **defensive programming** to make sure that the code does not throw any exceptions but still works correctly.

Using defensive programming, modify **FriendFinder.findClassmates** so that it does not throw any `NullPointerExceptions` in case of `null` values.

Specifically:
- use **IllegalArgumentException** and **IllegalStateException** appropriately
- return **null** if the input `Student` is not taking any classes or if there are no students taking the same classes as that student
- ignore any other `null` values encountered during the operation of the method

You may **not** change the `Student`, `StudentsDataSource`, or `ClassesDataSource` code at all, **nor** should you change the `FriendFinder` constructor or the signature of `FriendFinder.findClassmates`.

Likewise, you should **not** change that method’s behavior for good/valid inputs, but rather should only be looking for and handling null objects.

## Note

Make sure that your `FriendFinder` class is in the default package, that it compiles and you have not changed its constructor or the signature of the findClassmates method.

Also, make sure you have not created any additional `.java` files and have not made any changes to `Student.java`, `StudentsDataSource.java`, or `ClassesDataSource.java`.
