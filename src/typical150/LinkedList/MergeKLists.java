package typical150.LinkedList;

import java.util.PriorityQueue;

//23.合并K个升序链表
/*给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。*/
//思路 合并两个链表的时候用双指针
//合并多个链表可以每一个链表都记录当前最小的是哪个链表 可以用一个小顶堆
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode hair = new ListNode(), p = hair;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return hair.next;
    }
}
