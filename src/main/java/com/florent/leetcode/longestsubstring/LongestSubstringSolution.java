package com.florent.leetcode.longestsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * s consists of English letters, digits, symbols and spaces.
 * s can be empty
 */
public class LongestSubstringSolution {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        List<Character> substringWithNonRepeatingCharacters = new ArrayList<>();
        int longestStreakOfUnknownCharacters = 0;

        for (char c : s.toCharArray()) {
            if (substringWithNonRepeatingCharacters.contains(c)) {
                if (longestStreakOfUnknownCharacters < substringWithNonRepeatingCharacters.size()) {
                    longestStreakOfUnknownCharacters = substringWithNonRepeatingCharacters.size();
                }

                // reset streak
                int indexKnownCharacter = substringWithNonRepeatingCharacters.indexOf(c);
                if (indexKnownCharacter < substringWithNonRepeatingCharacters.size() - 1) {
                    substringWithNonRepeatingCharacters = substringWithNonRepeatingCharacters.subList(indexKnownCharacter+1, substringWithNonRepeatingCharacters.size());
                } else {
                    substringWithNonRepeatingCharacters.clear();
                }
            }

            substringWithNonRepeatingCharacters.add(c);
        }

        int currentStreakOfUnknownCharacters = substringWithNonRepeatingCharacters.size();
        if (longestStreakOfUnknownCharacters < currentStreakOfUnknownCharacters) {
            longestStreakOfUnknownCharacters = currentStreakOfUnknownCharacters;
        }
        return longestStreakOfUnknownCharacters;
    }

}
