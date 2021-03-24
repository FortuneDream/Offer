package tree;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                break;
            }
            result.add(queue.peek().val);
            if (queue.peek() != null) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
            }
            queue.poll();
        }
        return result;
    }
}
