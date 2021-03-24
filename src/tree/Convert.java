package tree;

import java.util.ArrayList;
import java.util.List;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//思路：先把中序遍历二叉树转换成一个从小到大的排序的链表，再左右链接起来
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        InOrder(pRootOfTree, list);
        TreeNode head = list.get(0);
        TreeNode prt = head;
        head.left = null;
        for (int i = 1; i < list.size(); i++) {
            prt.right = list.get(i);
            list.get(i).left = prt;
            prt = prt.right;
        }
        return head;
    }

    //中序遍历，并且放入数组
    private void InOrder(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode == null) {
            return;
        }
        InOrder(treeNode.left, list);
        list.add(treeNode);
        InOrder(treeNode.right, list);
    }
}
