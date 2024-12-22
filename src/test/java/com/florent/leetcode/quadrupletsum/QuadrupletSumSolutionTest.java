package com.florent.leetcode.quadrupletsum;

import com.florent.leetcode.quadrupletsum.utils.AssertIntList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class QuadrupletSumSolutionTest {

    final static int[] LARGE_ARRAY = new int[] {
            -489,-475,-469,-468,-467,-462,-456,-443,-439,-425,-425,-410,-401,-342,-341,-331,-323,-307,-299,-262,-254,-245,-244,-238,-229,-227,-225,-224,-221,-197,-173,-171,-160,-142,-142,-136,-134,-125,-114,-100,-86,-81,-66,-47,-37,-34,4,7,11,34,60,76,99,104,113,117,124,139,141,143,144,146,157,157,178,183,185,189,192,194,221,223,226,232,247,249,274,281,284,293,298,319,327,338,340,368,375,377,379,388,390,392,446,469,480,490
    };

    private QuadrupletSumSolution solution;

    @BeforeEach
    void setup() {
        solution = new QuadrupletSumSolution();
    }

    @Nested
    class FourSum {

        @ParameterizedTest
        @MethodSource("argumentsShouldFindTheFourSum")
        void shouldFindTheFourSum(List<Integer> values, int target, List<List<Integer>> expectedLists) {
            int[] nums = values.stream().mapToInt(Integer::intValue).toArray();

            var result = solution.fourSum(nums, target);

            AssertIntList.expectListOfListsAreEqualInAnyOrder(result, expectedLists);
        }

        static Stream<Arguments> argumentsShouldFindTheFourSum() {
            return Stream.of(
                    // case 1
                    Arguments.of(List.of(1, 0, -1, 0, -2, 2),
                            0,
                            List.of(List.of(-2, -1, 1, 2),
                                    List.of(-2, 0, 0, 2),
                                    List.of(-1, 0, 0, 1))),

                    // case 2
                    Arguments.of(List.of(2, 2, 2, 2, 2),
                            8,
                            List.of(List.of(2, 2, 2, 2))),

                    // case 3
                    Arguments.of(List.of(-2, -1, -1, 1, 1, 2, 2),
                            0,
                            List.of(List.of(-2, -1, 1, 2),
                                    List.of(-1, -1, 1, 1))),

                    // case 4
                    Arguments.of(List.of(0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7),
                            6,
                            List.of(List.of(-10,-2,8,10),
                                    List.of(-9,-3,8,10),
                                    List.of(-9,-2,7,10),
                                    List.of(-9,0,7,8),
                                    List.of(-4,-2,2,10),
                                    List.of(-4,0,2,8),
                                    List.of(-3,0,2,7),
                                    List.of(0,2,2,2))),

                    // case 5
                    Arguments.of(List.of(1, 2, 3, 4),
                            30,
                            List.of()),

                    // case 6
                    Arguments.of(List.of(1, 5, 1, 5, 1, 5, 1),
                            4,
                            List.of(List.of(1, 1, 1, 1))),

                    // case 7
                    Arguments.of(List.of(1000000000, 1000000000, 1000000000, 1000000000),
                            -294967296,
                            List.of())

            );

        }
    }

    @Nested
    class FourSumPerformance {

        @Test
        @Timeout(value = 55, unit = TimeUnit.MILLISECONDS)
        void shouldNotFindTheFourSum() {
            var result = solution.fourSum(LARGE_ARRAY, 2738);

            AssertIntList.expectListOfListsAreEqualInAnyOrder(result, List.of());
        }

    }

    @Nested
    class FourSumSlow {

        @Test
        @Timeout(value = 245, unit = TimeUnit.MILLISECONDS)
        void shouldNotFindTheFourSum() {
            var result = solution.fourSumSlow(LARGE_ARRAY, 2738);

            AssertIntList.expectListOfListsAreEqualInAnyOrder(result, List.of());
        }

    }


}
