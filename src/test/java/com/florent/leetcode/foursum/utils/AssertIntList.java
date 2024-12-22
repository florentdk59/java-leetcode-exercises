package com.florent.leetcode.foursum.utils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class AssertIntList {


    public static void expectListOfListsAreEqualInAnyOrder(List<List<Integer>> actualLists, List<List<Integer>> expectedLists) {

        assertThat(actualLists)
                .as("Actual " + actualLists + ".\nExpected : " + expectedLists)
                .hasSize(expectedLists.size());

        for (List<Integer> expectedList : expectedLists) {
            var sortedExpectedList = expectedList.stream().sorted().toList();

            boolean found = actualLists.stream()
                    .map(actualList -> actualList.stream().sorted().toList())
                    .anyMatch(sortedExpectedList::equals);

            if (!found) {
                fail("FAILURE. Actual : " + actualLists + ".\nExpected : " + expectedLists);
            }

        }

    }
}
