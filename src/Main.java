import tree.ReconstructBinaryTree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    static Queue<TreeNode> nodes = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 3, 5, 6};
        int[] in = new int[]{4, 2, 1, 5, 3, 6};
        ReconstructBinaryTree tree = new ReconstructBinaryTree();

    }


    public void printTreeNode(TreeNode node) {
        if (node!=null){
            System.out.print(node.val + ",");
            if (node.left != null) {
                nodes.add(node.left);
            }else {
                System.out.print("#,");
            }

            if (node.right != null) {
                nodes.add(node.right);
            }else {
                System.out.print("#,");
            }

            printTreeNode(nodes.poll());
        }

    }
}
