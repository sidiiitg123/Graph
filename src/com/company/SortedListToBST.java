package com.company;

import java.util.ArrayList;

public class SortedListToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public TreeNode sortedListToBST(ArrayList<Integer> a, int start, int end){
        if(start > end)
            return null;
        int mid = start+(end-start)/2;

        TreeNode node = new TreeNode(a.get(mid));
        node.left = sortedListToBST(a, start, mid-1);
        node.right = sortedListToBST(a, mid+1, end);
        return node;
    }

    public TreeNode sortedListToBST(ListNode a) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (a != null) {
            list.add(a.val);
            a = a.next;
        }
        return sortedListToBST(list, 0, list.size() - 1);

    }
}
