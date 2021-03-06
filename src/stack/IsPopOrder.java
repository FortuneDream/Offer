package stack;//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//        假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
//        （注意：这两个序列的长度是相等的）
// 模拟题，注意先push，后判断，并且是while判断
import java.util.Stack;

public class IsPopOrder {
    public  static boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; ) {
            stack.push(pushA[i]);
            i++;
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        isPopOrder(pushA,popA);
    }
}
