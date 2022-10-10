package com.android.linkedlist;

/**
 * author : cy
 * time   : 2022/10/10
 * desc   : ListNode
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
