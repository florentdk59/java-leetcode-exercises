package com.florent.leetcode.mediansortedarrays;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianTwoSortedArraysSolution {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var mergedList = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).sorted().toList();
        int listSize = mergedList.size();
        int midIndex = listSize / 2;
        if (listSize % 2 > 0) {
            return mergedList.get(midIndex);
        } else {
            int value1 = mergedList.get(midIndex-1);
            int value2 = mergedList.get(midIndex);

            return (value1 + value2) / 2.0;
        }
    }

}
