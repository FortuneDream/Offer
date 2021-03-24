package tree;

//操作给定的二叉树，将其变换为源二叉树的镜像。
//思路：从根开始，递归的交换左右子节点
public class Mirror {
    public void Mirror(TreeNode root) {
        swap(root);
    }

    private TreeNode swap(TreeNode pRoot) {
        if (pRoot != null) {
            TreeNode temp = null;
            temp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = temp;
            swap(pRoot.left);
            swap(pRoot.right);
        }
        return pRoot;
    }
}
