package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class PeopleProcessorTest {

    static List<Person> people;

    @BeforeAll
    static void setup(){
        people = Collections.unmodifiableList(Arrays.asList(
                new Person("John","Doe"),
                new Person("John","Silver"),
                new Person("Peter","Doe")
        ));
    }

    @DisplayName("Test lastnamesByFirstname() method.")
    @Test
    void testLastnamesByFirstname(){
        Map<String, List<String>> expected = Collections.unmodifiableMap(Map.of(
                "John", Arrays.asList("Doe", "Silver"),
                "Peter", Arrays.asList("Doe")
        ));

        Assertions.assertEquals(expected, PeopleProcessor.lastnamesByFirstname(people));
    }

    @DisplayName("Test firstnamesByLastname() method.")
    @Test
    void testFirstnamesByLastname(){
        Map<String, List<String>> expected = Collections.unmodifiableMap(Map.of(
                "Doe", Arrays.asList("John", "Peter"),
                "Silver", Arrays.asList("John")
        ));

        Assertions.assertEquals(expected, PeopleProcessor.firstnamesByLastname(people));
    }

}
