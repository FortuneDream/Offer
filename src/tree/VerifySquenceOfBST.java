package tree;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
// 找到最后一个树为根，然后从左开始找到第一个大于根节点的位置，分割左右子树，然后在右子树上check是不是所有的节点都大于根节点。
//递归check左右子树
public class VerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int i = 0;
        for (i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = 0;
        for (j = i; j < sequence.length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        int[] left = new int[i];
        int[] right = new int[sequence.length - 1 - i];
        for (int ii = 0; ii < left.length; ii++) {
            left[ii] = sequence[ii];
        }
        for (int jj = 0; jj < right.length; jj++) {
            right[jj] = sequence[jj + i];
        }
        boolean resultLeft = true;
        if (left.length > 0) {
            resultLeft = VerifySquenceOfBST(left);
        }

        boolean resultRight = true;
        if (right.length > 0) {
            resultRight = VerifySquenceOfBST(right);
        }
        return resultLeft && resultRight;
    }


}
