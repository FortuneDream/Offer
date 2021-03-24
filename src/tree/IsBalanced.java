package tree;

//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//平衡树的条件：任意左子树的深度-右边子树的深度<=1
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    //树的深度f(root)=1+Max(f(root.left),f(root.right))
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
