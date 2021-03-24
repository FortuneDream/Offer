package list;

//输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTail {


    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null||k==0) {
            return null;
        }
        ListNode temp = pHead;
        for (int i = 0; i < k-1; i++) {
            if (temp.next!=null){
                temp = temp.next;
            }else{
                return null;
            }
        }
        while (temp.next != null) {
            temp = temp.next;
            pHead = pHead.next;
        }
        return pHead;
    }
}
