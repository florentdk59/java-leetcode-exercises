package com.florent.leetcode.mediansortedarrays;

import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@Slf4j
public class MedianSortedArraysSolutionTest {

    private MedianTwoSortedArraysSolution solution;

    @BeforeEach
    void setup() {
        solution = new MedianTwoSortedArraysSolution();
    }

    @Nested
    class FindMedianSortedArrays {

        @ParameterizedTest
        @CsvSource({
                "1|3, 2, 2",
                "1|2, 3|4, 2.5"
        })
        void shouldMedianElementOfTwoMergedArrays(ParameterizedIntList array1, ParameterizedIntList array2, double expectedMedian) {
            int[] nums1 = array1.getValues().stream().mapToInt(Integer::intValue).toArray();
            int[] nums2 = array2.getValues().stream().mapToInt(Integer::intValue).toArray();

            var result = solution.findMedianSortedArrays(nums1, nums2);
            log.info("shouldFindSizeOfLongestNonRepeatingChars : result({}, {}) -> {}",  array1, array2, result);

            assertThat(result).isEqualTo(expectedMedian, within(0.01));
        }

    }

}