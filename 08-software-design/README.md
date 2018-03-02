# Project 08 - Software Design

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/bd1ca9ec42034882bee3dbf3bb80c912/dfe067073833470cb93dff6b3efad0a0/?child=first).

## Requirements

**This project implements a program that allows a user to search through a collection of books and find books written by a specific author, or the number of books written in a specified year.
This program is implemented using the three-tier architecture.**

This program is perhaps not difficult to implement but the challenge here is **applying good software design principles** (`modularity`, `functional independence`, and `abstraction`) in order to create code that has high internal quality: `changeability`, `stability`, `understandability`, and `testability`.

The application must have the following methods:

- **findBookTitlesByAuthor** : for a given name, search through all of the books and return the titles of those books whose author name includes the input name.

- **findNumberOfBooksInYear** : for a given year, search through all of the books and return the number of books published in that year.

- **getAllBooks** : read the data file containing information about the books, create Book objects for each, and then return the Book objects.

- **showBookTitlesByAuthor** : using the command-line (i.e., reading from [System.in](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#in)), ask the user to enter part or all of an author’s name, then display (using [System.out](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out)) the titles of those books whose author name includes the input name.

- **showNumberOfBooksInYear** : using the command-line (i.e., reading from [System.in](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#in)), ask the user to enter a year, then display (using [System.out](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out)) the number of books published in that year.

For each of the five methods, you need to decide:

- In which class (**PresentationTier**, **LogicTier**, or **DataTier**) should it be implemented?
- What should its input parameter(s) be?
- What should its return type be?

In addition to considering **modularity** and **functional independence** in applying the three-tier architecture, be sure to also consider **abstraction** when designing each method: the caller of a method should be able to use it knowing only what it does, and not the details of how it works.

**Once you have completed your design**, implement each of the five methods according to the specifications above.

In all cases, you can handle error conditions in any way you choose, e.g. if the user enters a year that is non-numeric in `showBookTitlesByAuthor`, if the name specified in `findBookTitlesByAuthor` is null, etc. Just be sure your code works correctly for “normal” inputs.

Likewise, it is okay for `getAllBooks` to assume that the input file exists and is well-formatted.

You can use any prompt you choose for asking for input in `showBookTitlesByAuthor` and `showNumberOfBooksInYear`, and can likewise choose any output formatting you like.

Finally, implement **PresentationTier.start** so that it asks the user which feature they would like to use and invokes the appropriate methods in the appropriate classes. Once the output has been displayed, the program should terminate. As above, you can handle error cases in any way that you deem appropriate.

## Note

Please be sure that your code adheres to the following guidelines and restrictions:

- Each method listed above must go into **exactly one** of the three classes (`PresentationTier`, `LogicTier`, or `DataTier`).
- Do not add any other classes, though you may add additional fields and methods as necessary.
- Do not change the `Book` class or `Main` class.
- All methods must be public.
- All code should be in the default package, i.e. there should be no “package” declaration at the top of the source code.
