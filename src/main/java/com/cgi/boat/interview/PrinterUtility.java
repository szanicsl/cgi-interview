package com.cgi.boat.interview;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
public class PrinterUtility {

    private PrinterUtility(){
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void printTopN(@NonNull Map<String, List<String>> map, int n){
        if (n < 0) {
            throw new IllegalArgumentException("printTopN was called with a negative \"n\".");
        }

        map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .limit(n)
                .map(entry -> entry.getKey() + ": " + entry.getValue().size())
                .forEach(log::info);

    }

    public static void printTopNAccountingTies(@NonNull Map<String, List<String>> map, int n){
        if (n < 0) {
            throw new IllegalArgumentException("printTopNAccountingTies was called with a negative \"n\".");
        }

        Map<Integer, List<String>> namesGroupedByOccurrences = map.entrySet().stream()
                .collect(
                        Collectors.groupingBy(entry -> entry.getValue().size(),
                                Collectors.mapping(Map.Entry::getKey,
                                        Collectors.toList())));

        Map<String, Integer> countMappedByName = new LinkedHashMap<>();

        namesGroupedByOccurrences.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getKey() - entry1.getKey())
                .forEach(entry -> {
                    if(countMappedByName.size() < n){
                        entry.getValue()
                                .forEach(name -> countMappedByName.put(name, entry.getKey()));
                    }
                });

        countMappedByName.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(log::info);
    }
}
