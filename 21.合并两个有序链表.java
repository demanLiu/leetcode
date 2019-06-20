/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (55.00%)
 * Likes:    489
 * Dislikes: 0
 * Total Accepted:    76.8K
 * Total Submissions: 139.4K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode head = new ListNode(0);
        head = newList;
        while(l1 != null && l2 != null ){
            if(l1.val > l2.val){
                ListNode temp = new ListNode(l2.val);
                newList.next = temp;
                l2 = l2.next;
            }else if(l1.val <l2.val){
                ListNode temp = new ListNode(l1.val);
                newList.next = temp;
                l1 = l1.next;
            }else{
                ListNode temp = new ListNode(l1.val);
                newList.next = temp;
                newList = newList.next;
                ListNode temp1 = new ListNode(l2.val);
                newList.next = temp1;
                l1 = l1.next;
                l2 = l2.next;

            }
            newList = newList.next;
        }
        while(l1 != null){
            ListNode temp = new ListNode(l1.val);
            newList.next = temp;
            newList = newList.next;
            l1 =l1.next;
        }
        while(l2 != null){
            ListNode temp = new ListNode(l2.val);
            newList.next = temp;
            newList = newList.next;
            l2 = l2.next;
        }
        return head.next;
    }
}

