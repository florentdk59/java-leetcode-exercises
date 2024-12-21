package com.florent.leetcode.twosumtarget;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <br/>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <br/>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <br/>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <br/>
 * Constraints:
 *     2 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 *     -109 <= target <= 109
 *     Only one valid answer exists.
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
