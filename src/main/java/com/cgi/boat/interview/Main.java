package com.cgi.boat.interview;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Log4j2
public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);

        log.info("--- 3 most common first names ---");
        PrinterUtility.printTopN(lastByFirst, 3);

        log.info("--- 3 most common last names ---");
        PrinterUtility.printTopN(firstByLast, 3);

        log.info("--- 3 most common last names accounting ties ---");
        PrinterUtility.printTopNAccountingTies(firstByLast, 3);

        log.info("--- 6 most common first names ---");
        PrinterUtility.printTopN(lastByFirst, 6);

        log.info("--- 6 most common first names accounting ties ---");
        PrinterUtility.printTopNAccountingTies(lastByFirst, 6);
    }



}
