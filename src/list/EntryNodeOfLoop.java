package list;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
//先确定是否有环，快慢指针，找到相遇的地方
//再把两个指针分别放在相遇的地方，以及初始位置，再次相遇则是出口
//todo 代码还有点问题，但是不知道原因是为啥
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = isCircle(pHead);
        if (fast == null) {
            return null;
        }
        ListNode slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode isCircle(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fast;
            }
        }
        return null;
    }
}
