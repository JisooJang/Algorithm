package leetcode;

/*
https://leetcode.com/problems/design-a-stack-with-increment-operation/
Design a stack which supports the following operations.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 */
public class Probelm1381 {
    class CustomStack {
        int[] elements = null;
        int pick = -1;
        int maxSize = 0;

        public CustomStack(int maxSize) {
            elements = new int[maxSize];
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if(pick < maxSize - 1) {
                elements[++pick] = x;
            }
        }

        public int pop() {
            if(pick >= 0) {
                return elements[pick--];
            } else {
                return -1;
            }
        }

        public void increment(int k, int val) {
            if(k > elements.length) {
                k = elements.length;
            }
            for(int i=0 ; i<k ; i++) {
                elements[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
