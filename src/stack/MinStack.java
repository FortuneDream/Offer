package stack;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//        注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
//多一个minStack保存当前最小，以及较小的node
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty()) {
            stack.push(node);
            minStack.push(node);
        } else {
            if (node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
