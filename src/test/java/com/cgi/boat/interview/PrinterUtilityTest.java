package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PrinterUtilityTest {

    @DisplayName("Test NullPointerException should be thrown.")
    @Test
    void testNullPointerExceptionShouldBeThrown(){
        Assertions.assertThrows(NullPointerException.class, () -> PrinterUtility.printTopN(null,1));
        Assertions.assertThrows(NullPointerException.class, () -> PrinterUtility.printTopNAccountingTies(null,1));
    }

    @DisplayName("Test IllegalArgumentException should be thrown.")
    @Test
    void testIllegalArgumentExceptionShouldBeThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> PrinterUtility.printTopN(Collections.EMPTY_MAP,-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PrinterUtility.printTopNAccountingTies(Collections.EMPTY_MAP,-1));
    }
}
