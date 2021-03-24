package tree;
//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//
//        每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历，记录每个节点的索引，当每层遍历完成后计算下一层的最大宽度(链表最后一个元素索引-链表的最前面元素索引+1)
 */
public class widthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> indexList = new LinkedList<>();
        int max = 1;
        int size = 1;
        indexList.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int index = indexList.removeFirst();
            if (node.left != null) {
                queue.add(node.left);
                indexList.add(index * 2);
            }

            if (node.right != null) {
                queue.add(node.right);
                indexList.add(index * 2 + 1);
            }
            size--;
            if (size == 0) { //本层遍历结束
                size = queue.size();
                if (indexList.size() >= 2) { //注意这个判断条件
                    max = Math.max(max, indexList.getLast() - indexList.getFirst() + 1);
                }
            }
        }
        return max;
    }
}
