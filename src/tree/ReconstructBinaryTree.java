package tree;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历的起点和中点，中序遍历的起点和重点
    public TreeNode reTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startIn > endIn||startPre>endPre) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                node.left = reTree(pre, startPre + 1, startPre+(i-startIn) , in, startIn, i - 1); //endPre=startPre+中序遍历的根节点的左边的个数
                node.right = reTree(pre, startPre+(i-startIn)+1, endPre, in, i + 1, endIn); //startPre=startPre+中序遍历的根节点的左边的个数+1
                break;
            }
        }
        return node;
    }
}
