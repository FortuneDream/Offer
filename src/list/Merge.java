package list;

import list.ListNode;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
//比较-->拼接-->边界处理
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(0); //虚拟头结点。结果是result.next
        compare(result, list1, list2);
        return result.next;
    }

    public void compare(ListNode result, ListNode list1, ListNode list2) {
        if (list1 == null) {
            if (list2 != null) {
                result.next = list2;
                return;
            }
        }

        if (list2 == null) { //两个链表不一样长时，把剩下的链表直接拼接
            if (list1 != null) {
                result.next = list1;
                return;
            }
        }

        if (list1.val < list2.val) { //比较
            result.next = list1;
            compare(result.next, list1.next, list2);
        } else {
            result.next = list2;
            compare(result.next, list1, list2.next);
        }
    }
}
