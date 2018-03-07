# Project 11 - Efficiency

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/2762c877e0824a62b88cc161cffe401b/2f63ea6bd51e4f43b079cf6c6a97c8e6/?child=first).

## Requirements

This project focuses on improving the execution time of a Java program that attempts to detect plagiarism in a corpus of documents.

The `detectPlagiarism` method takes the name of the directory containing the corpus of documents, as well as the `windowSize` and `threshold` parameters, and returns a `Map` that lists the pairs of documents, with the `Map` keys sorted by the number of matches. If two or more pairs have the same number of matches, the order in which they are stored is not specified.

Aside from the `detectPlagiarism` method, the `PlagiarismDetector` also has helper methods to:
- read a file and store its contents in a `List` of `Strings`
- create the distinct phrases, each of which is of size `windowSize`
- find the common phrases between two documents
- sort the results

There is also a `main` method that you can use to run the `detectPlagiarism` method (be sure to specify the directory containing the corpus), which then reports the execution time in seconds. Note that this measures the **wall clock** or actual elapsed time, and not the time that the program is actually running on the CPU.

**Improve the execution time of the detectPlagiarism method and the methods it uses!**

In particular, you should consider:
- does the code use the correct data structures? If it’s using a `List`, maybe it should use a `Set`, or the other way around.
- Does the code use efficient algorithms? Perhaps there are quicker ways to accomplish the same things.
- Does the code do unnecessary work? Perhaps some code can be rewritten or even removed if it is doing work that’s already been done.

In making changes to the code, you may **not** assume that:
- the program will always use the same set of documents that was provided to you, so you cannot pre-compute results
- the number and size of documents in the corpus will always be the same as the one that was provided to you, so you cannot hardcode values
- the `windowSize` and `threshold` will always have the values specified above
- the code is always executed on a multi-core/multi-processor machine, so you can’t know for certain that using threads will help.

## Note

Please be sure that:
- your `PlagiarismDetector` class is in the default package
- your `PlagiarismDetector` class compiles and you have not changed the signature of the `detectPlagiarism` method
- you have not created any additional `.java` files.
