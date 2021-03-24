package stack;

import java.util.LinkedList;
import java.util.Queue;

//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//解法：队列成对插入，成对取出
//todo  add换成offer，如果有容器容量限制的话add会跑异常，offer则返回false,
//remove换成poll同理
//todo 为啥用LinkedBlockingQueue<>(); 不行，用Linklist就可以呢?
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) { //都为空
                continue;
            }
            if (left == null || right == null) { //其中一个为空，另外一个不为空
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


}
