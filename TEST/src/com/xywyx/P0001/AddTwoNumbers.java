package com.xywyx.P0001;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode l = solution.addTwoNumbers(l1,l2);
        while (l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        int a = 0;//进位
        while (l1!=null||l2!=null){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum = x+y+a;
            a=sum/10;
            head.next=new ListNode(sum%10);
            head=head.next;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if(a>0){
            head.next=new ListNode(a);
        }

        return l.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}