package list;

import list.ListNode;

import java.util.ArrayList;
import java.util.List;

//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
//递归打印
public class PrintListFromTailToHead {
    private ArrayList<Integer> results = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        printNext(results, listNode);
        return results;
    }

    private void printNext(List<Integer> list, ListNode listNode) {
        if (listNode.next != null) {
            printNext(list, listNode.next);
        }
        list.add(listNode.val);

    }
}


