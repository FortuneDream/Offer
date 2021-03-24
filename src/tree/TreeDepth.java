package tree;

//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
//提炼函数 f(root)=1+MAX(f(root.left)+f(roor.right))
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return 1+Math.max(leftDepth , rightDepth );
    }
}
