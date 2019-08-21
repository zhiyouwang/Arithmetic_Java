package com.JnuWangPractice;

import java.util.Stack;

public class GetMinStack {
    /**
     * 找出栈中数据的最小值
     * 思路：采用两个栈，同时进栈，只记录最小值
     */
    public static class MyStack {
        // 存放数据进栈
        private Stack<Integer> stackData;
        // 存放最小值的栈
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * 数据压栈
         * @param newNum
         */
        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        /**
         * 数据出栈
         * @return
         */
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty!");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        /**
         * 取出栈中数据最小值
         * @return
         */
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty!");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println(myStack.getMin());
        myStack.push(4);
        System.out.println(myStack.getMin());
        myStack.push(1);
        System.out.println(myStack.getMin());
        System.out.println(myStack.pop());
        System.out.println(myStack.getMin());
    }

}
