package com.florent.leetcode.listnode.utils;

import com.florent.leetcode.listnode.ListNode;
import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListNodeMaker {

    public static ListNode makeListNode(ParameterizedIntList intList) {

        var rootNode = new ListNode();
        ListNode currentNode = null;
        for (var value : intList.getValues()) {
            if (currentNode == null) {
                currentNode = rootNode;
            } else {
                currentNode.setNext(new ListNode());
                currentNode = currentNode.getNext();
            }
            currentNode.setVal(value);
        }
        return rootNode;
    }


}