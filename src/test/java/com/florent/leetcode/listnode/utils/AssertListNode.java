package com.florent.leetcode.listnode.utils;

import com.florent.leetcode.listnode.ListNode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import static com.florent.leetcode.listnode.utils.ListNodeDebugger.toDebugString;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@UtilityClass
public class AssertListNode {

    public static void expectListNodesAreEqual(final ListNode actual, final ListNode expected) {
        expectListNodesAreEqualRecursive(actual, expected, actual, expected);
    }

    private static void expectListNodesAreEqualRecursive(final ListNode actual, final ListNode expected,
                                                         final ListNode actualRoot, final ListNode expectedRoot) {
        if (actual == null && expected == null) {
            return;
        }

        if (actual == null || expected == null || actual.getVal() != expected.getVal()) {
            fail(String.format("ListNodes are not equal. Actual : %s. Expected : %s. Difference : %s",
                    toDebugString(actualRoot), toDebugString(expectedRoot), toDebugString(actual)));
        }

        expectListNodesAreEqualRecursive(actual.getNext(), expected.getNext(), actualRoot, expectedRoot);
    }

}