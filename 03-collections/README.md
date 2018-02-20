# Project 03 - Collections

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/44fa2fc239fa479baabfb7cbac8bcfb6/486c0e96406d4cd898628ed07612cb67/?activate_block_id=block-v1%3APennX%2BSD2x%2B2T2017%2Btype%40sequential%2Bblock%40486c0e96406d4cd898628ed07612cb67).

## Requirements

Write a program that analyzes the sentiment (positive or negative) of a sentence based on the words it contains by implementing methods that use the `List`, `Set`, and `Map` interfaces from the `Java Collections API`.

Sentiment analysis is a task from the field of **computational linguistics** that seeks to determine the general attitude of a given piece of text.
For instance, we would like to have a program that could look at the text *“This project was joyful and a pleasure”* and realize that it was a positive statement while *“It made me want to pull out my hair”* is negative.

Implement the **readFile** method in **Analyzer.java**.

- This method should take the name of the file to read and read it one line at a time, creating `Sentence` objects and putting them into the `List`. Note that the method returns a List containing Sentence objects.

Implement the **allWords** method in **Analyzer.java**.

- This method should find all of the individual tokens/words in the text field of each `Sentence` in the `List` and create `Word` objects for each distinct word. The Word objects should keep track of the number of occurrences of that word in all Sentences, and the total **cumulative** score of all Sentences in which it appears. This method should then return a Set of those Word objects.

Implement the **calculateScores** method in **Analyzer.java**.

- This method should iterate over each Word in the input Set, use the Word’s `calculateScore` method to get the average sentiment score for that `Word`, and then place the text of the Word (as key) and calculated score (as value) in a `Map`.

Finally, implement the **calculateSentenceScore** method in **Analyzer.java**.

- This method should use the `Map` to calculate and return the average score of all the words in the input sentence.

## Note

Do not change the signature of the `readFile` method and do not modify `Sentence.java`. Also, please do not create new `.java` files. If you need to create new classes, add them to `Analyzer.java`. Last, please make sure that your  Analyzer class is in the default package, i.e. there is no “package” declaration at the top of the source code.
