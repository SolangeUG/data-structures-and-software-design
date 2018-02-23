# Project 05 - TreeMaps and PriorityQueues

[![Java Platform](https://img.shields.io/badge/platform-Java-blue.svg)](https://docs.oracle.com/en/java/)
[![JUnit Library](https://img.shields.io/badge/framework-JUnit-25A162.svg)](https://junit.org/junit5/)

The full project specification can be found [here](https://courses.edx.org/courses/course-v1:PennX+SD2x+2T2017/courseware/969de2fc74c340b7917fabf78d940f65/daa142fa0a6b48d2932559590bce3efa/?child=first).

## Requirements

This project implements methods that process movie ratings, using the `java.util.TreeMap` and `java.util.PriorityQueue` classes from the Java Collections API.

In `MovieRatingsParser.java`, implement the **parseMovieRatings** method, which takes a List of `UserMovieRatings` as input and creates a `TreeMap` data structure from it. The `TreeMap` is a mapping from the movie’s title to a `PriorityQueue` of all its associated ratings.
Keep in mind that the same movie title may appear numerous times in the input List, and multiple instances may even have the same rating.
A distinct movie title should only appear once as a key in the `TreeMap`, however, and be mapped to a `PriorityQueue` (**min-heap**) of all the ratings for that movie.

Next, implement the following methods in `MovieRatingsProcessor.java`. All methods take as input a `TreeMap` that maps movie titles to a `PriorityQueue` of their ratings, in addition to any inputs specified:

- **getAlphabeticalMovies** : return a `List` of movie titles in alphabetical order

- **getAlphabeticalMoviesAboveRating** : given an input `int` rating, return a `List` of movie titles in alphabetical order, where all movies in the `List` do not have any ratings less than or equal to rating

- **removeAllRatingsBelow** : given an input `int` rating, modify the `TreeMap` object that was passed as an argument so that you remove all ratings in the `PriorityQueue` that are below (but not equal to) rating for every movie in the Map. If all ratings are removed from a movie’s `PriorityQueue`, then remove the mapping from the `TreeMap`. Additionally, this method should return a new `TreeMap` that maps a movie title to the number of ratings that were removed from its corresponding `PriorityQueue`; the `TreeMap` that is returned should only contain movies that had ratings removed from its `PriorityQueue`.

## Note

Do not change the signatures of the four methods and please do not modify `UserMovieRatings.java`. Also, please do not create any additional `.java` files for your solution. If you need additional classes, you can define them in `MovieRatingsProcessor.java`. Last, please be sure that your `MovieRatingsProcessor` class is in the default package, i.e. there is no “package” declaration at the top of the source code.
