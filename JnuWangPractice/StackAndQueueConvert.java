package com.JnuWangPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    /**
     * 用两个栈实现队列操作
     */
    public static class TwoStackQueue {
        // 数据压栈
        private Stack<Integer> stackPush;
        // 数据出栈进该栈
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush =new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        /**
         * 将数据压入stackPush栈中
         * @param pushInt
         */
        public void pushStack(int pushInt) {
            stackPush.push(pushInt);
        }

        /**
         * 判定条件将数据从stackPop栈中弹出来
         * @return
         */
        public int pollStack() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    // 只有同时满足两个条件才可以将数据进行入栈操作
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        /**
         * 取出栈顶元素，不弹出
         * @return
         */
        public int peekStack() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        /**
         * 用两个队列实现栈
         */
        public static class TwoQueueStack {
            private Queue<Integer> queue;
            private Queue<Integer> assist;

            public TwoQueueStack() {
                queue = new LinkedList<Integer>();
                assist = new LinkedList<Integer>();
            }

            /**
             * 入队
             * @param pushInt
             */
            public void push(int pushInt) {
                queue.add(pushInt);
            }

            /**
             * 获取队头元素，不删除
             * @return
             */
            public int peekQueue() {
                if (queue.isEmpty()) {
                    throw new RuntimeException("Stack is empty!");
                }
                while (queue.size() != 1) {
                    assist.add(queue.poll());
                }
                int result = queue.poll();
                assist.add(result);
                swap();
                return result;
            }

            public int pop() {
                if (queue.isEmpty()) {
                    throw new RuntimeException("Stack is empty");
                }
                while (queue.size() > 1) {
                    assist.add(queue.poll());
                }
                int result = queue.poll();
                swap();
                return result;
            }

            /**
             * 交换指针对象
             */
            private void swap() {
                Queue<Integer> temp = assist;
                assist = queue;
                queue = temp;
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("++++");
    }
}
