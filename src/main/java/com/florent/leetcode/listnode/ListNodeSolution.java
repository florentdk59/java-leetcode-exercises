package com.florent.leetcode.listnode;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
@Slf4j
public class ListNodeSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var calculationList = new ArrayList<Integer>();
        addListNodes(l1, l2, calculationList);

        // calculationList now contains the sum of each digit (in reverse order still)
        return convertIntegerListToListNode(calculationList);
    }

    private static int getNullSafeListNodeVal(@Nullable ListNode listNode) {
        return listNode != null ? listNode.getVal() : 0;
    }

    @Nullable
    private static ListNode getNullSafeListNodeNext(@Nullable ListNode listNode) {
        return listNode != null ? listNode.getNext() : null;
    }

    private static void addListNodes(@Nullable ListNode l1, @Nullable ListNode l2, List<Integer> calculationList) {
        if (l1 == null && l2 == null) {
            return;
        }
        calculationList.add(getNullSafeListNodeVal(l1) + getNullSafeListNodeVal(l2));
        addListNodes(getNullSafeListNodeNext(l1), getNullSafeListNodeNext(l2), calculationList);
    }

    private static ListNode convertIntegerListToListNode(List<Integer> list) {
        var rootNode = new ListNode();

        ListNode currentNode = null;
        var leftoverFromParentNode = 0;
        for (var currentDigit : list) {
            if (currentNode == null) {
                currentNode = rootNode;
            } else {
                currentNode.setNext(new ListNode());
                currentNode = currentNode.getNext();
            }

            var adjustedCurrentDigit = currentDigit + leftoverFromParentNode;

            // test if the sum has overflown
            if (adjustedCurrentDigit >= 10) {
                leftoverFromParentNode = adjustedCurrentDigit / 10;
                adjustedCurrentDigit = adjustedCurrentDigit % 10;
            } else {
                leftoverFromParentNode = 0;
            }

            currentNode.setVal(adjustedCurrentDigit);
        }
        if (leftoverFromParentNode > 0) {
            var node = new ListNode();
            node.setVal(leftoverFromParentNode);
            currentNode.setNext(node);
        }
        return rootNode;
    }



}