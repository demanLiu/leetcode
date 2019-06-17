/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        int sum = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(l1 != null || l2 != null){
            if(l1 == null){
                sum = l2.val + step;
                l2 = l2.next;
            }else if(l2 == null){
                sum = l1.val + step;
                l1 = l1.next;
            }else{
                sum = l1.val + l2.val + step;
                l1 = l1.next;
                l2 = l2.next;
            }
            step = 0;
            if(sum >= 10){
                step = 1;
                sum -= 10;
            }
            result.next = new ListNode(sum);
            result = result.next;
        }
        if(step > 0){
            result.next = new ListNode(step);
        }
        return head.next;
    }

}

