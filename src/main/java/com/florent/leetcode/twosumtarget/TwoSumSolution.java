package com.florent.leetcode.twosumtarget;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        for (int index1 = 0; index1 < nums.length; index1++) {
            for (int index2 = 0; index2 < nums.length; index2++) {
                if (index1 != index2) {
                    if (nums[index1] + nums[index2] == target) {
                        return new int[] {index1, index2};
                    }
                }

            }
        }

        // no acceptable combination found : not possible according to the rules, but here is a default response
        return new int[] {-1, -1};

    }
}
