package com.florent.leetcode.twosumtarget;

import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TwoSumSolutionTest {

    @Nested
    class TwoSum {

        @ParameterizedTest
        @CsvSource(delimiter = ';', value = {
                "2,7,11,15; 9; 0; 1",
                "3,2,4; 6; 1; 2",
                "3,3; 6; 0; 1",
        })
        void shouldCombineTwoListNodes(ParameterizedIntList values, int target, int expectedIdx1, int expectedIdx2) {
            int[] numbers = values.getValues().stream().mapToInt(Integer::intValue).toArray();

            var result = new TwoSumSolution().twoSum(numbers, target);

            assertThat(result).containsExactly(expectedIdx1, expectedIdx2);
        }

    }

}