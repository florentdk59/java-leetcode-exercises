package com.florent.leetcode.listnode.utils;

import com.florent.leetcode.listnode.ListNode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListNodeDebugger {

    public static String toDebugString(ListNode node) {
        if (node == null) {
            return "null";
        }
        return toDebugStringRecursive(node, "ListNode[");
    }

    private static String toDebugStringRecursive(final ListNode node, final String debugString) {
        if (node == null) {
            return String.format("%s]", debugString);
        }
        return toDebugStringRecursive(node.getNext(), String.format("%s%s,", debugString, node.getVal()));
    }


}