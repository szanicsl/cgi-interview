package com.cgi.boat.interview;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Log4j2
public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        printTopN(lastByFirst, 3);

    }

    private static void printTopN(Map<String, List<String>> map, int n){
        map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .limit(n)
                .map(entry -> entry.getKey() + ": " + entry.getValue().size())
                .forEach(log::info);
    }

}
