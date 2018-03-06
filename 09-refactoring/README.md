# Project 09 - Refactoring

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/2762c877e0824a62b88cc161cffe401b/1a5677a66e2d44b098c55a4b1723262c/?child=first).

## Requirements

This project is about refactoring a piece of code in order to reduce its size and make it more generalizable.

Use the Extract Class refactoring pattern to create a class called **PublishingLocation** and implement that class so that it contains the *city*, *state*, and *postCode* fields and any other necessary methods. Then modify **NewspaperArticle** accordingly by removing fields and methods as needed, and then setting up the appropriate relationship between `NewspaperArticle` and this newly created `PublishingLocation` class.

Your refactoring must **not** necessitate any changes to the **Client** class in order for it to still compile.

After completing the above, the `NewspaperArticle` class is a bit smaller but still has many fields and methods that may be common to other types of documents, e.g. journal articles or books. By moving those fields and methods to another class, we can have a more generalizable class that can be used for representing other types of documents.

**Refactor NewspaperArticle** and apply either the **Extract Class** or **Extract Superclass** pattern (you need to decide which!) to create a new class called **Document** that contains the fields and methods that would be common to all types of documents. In particular, move the `title`, `author`, `date`, and `publishing location` fields and related methods to the new Document class, but leave the rest in NewspaperArticle.

While performing this refactoring, you also need to decide whether **Document** should be a `concrete class`, an `abstract class`, or an `interface`.

## Note

Your refactoring must not necessitate any changes to the **Client** class in order for it to still compile. That is, you may not change the Client class as a result of this refactoring.
