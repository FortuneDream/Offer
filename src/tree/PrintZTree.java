package tree;

import java.util.ArrayList;
import java.util.Stack;

//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
//奇数行栈stack1,打印右，左子节点。偶数行栈stack2，打印左，右子节点
//来回check两个栈需要用一个while包裹两个while
public class PrintZTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot != null) {
            stack1.push(pRoot);
            while (!stack1.empty() || !stack2.empty()) {
                ArrayList<Integer> list1 = new ArrayList<>();
                while (!stack1.empty()) {
                    TreeNode node1 = stack1.pop();
                    list1.add(node1.val);
                    if (node1.left != null) {
                        stack2.push(node1.left);
                    }
                    if (node1.right != null) {
                        stack2.push(node1.right);
                    }

                }
                if (list1.size() > 0) {
                    result.add(list1);
                }


                ArrayList<Integer> list2 = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode node2 = stack2.pop();
                    list2.add(node2.val);
                    if (node2.right != null) {
                        stack1.push(node2.right);
                    }
                    if (node2.left != null) {
                        stack1.push(node2.left);
                    }

                }
                if (list2.size() > 0) {
                    result.add(list2);
                }

            }
        }
        return result;
    }

}
