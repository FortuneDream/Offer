package list;

import list.ListNode;

//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (head.next != null) {
           next=head.next; //指向下一个，保证在逆转后还可以指向该节点
           head.next=pre; //逆转
           pre=head; //当前成为下一个将要逆转的其前一个
           head=next; //移动当前指针
        }
        head.next=pre; //注意这里，最后一个节点和倒数第二个还需要再链接一次
        return head;

    }
}
