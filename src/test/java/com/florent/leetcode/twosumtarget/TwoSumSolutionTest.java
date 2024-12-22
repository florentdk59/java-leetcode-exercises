package com.florent.leetcode.twosumtarget;

import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TwoSumSolutionTest {

    private TwoSumSolution solution;

    @BeforeEach
    void setup() {
        solution = new TwoSumSolution();
    }

    @Nested
    class TwoSum {

        @ParameterizedTest
        @CsvSource(value = {
                "2_7_11_15, 9, 0, 1",
                "3_2_4, 6, 1, 2",
                "3_3, 6, 0, 1",
        })
        void shouldCombineTwoListNodes(ParameterizedIntList values, int target, int expectedIdx1, int expectedIdx2) {
            int[] numbers = values.getValues().stream().mapToInt(Integer::intValue).toArray();

            var result = solution.twoSum(numbers, target);

            assertThat(result).containsExactly(expectedIdx1, expectedIdx2);
        }

    }

}