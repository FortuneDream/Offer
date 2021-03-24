package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
//用end记录上一行的节点数
public class PrintMuchRowTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int start = 0, end = 1;
        ArrayList<Integer> layerList = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            layerList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            start++;
            if (end == start) {
                end = queue.size();
                start = 0;
                results.add(layerList);
                layerList = new ArrayList<>(); //这里不能用clear，会影响result的数据
            }
        }
        return results;
    }
}
