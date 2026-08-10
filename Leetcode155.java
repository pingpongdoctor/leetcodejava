/**

["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

min = -3
[value,curMin]
<-[-2,-2]   [0,-2]<-

min = Math.min(min,-3)

Time complexity: O(1)
Space complexity: O(n)
*/



public class Leetcode155 {
    private Deque<int[]> myStack;
    private int min;

    public MinStack() {
        myStack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        min = Math.min(min, value);
        myStack.push(new int[]{value,min});
    }
    
    public void pop() {
        int[] deleted = myStack.pop();
        if(myStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = myStack.peek()[1];
        }
    }
    
    public int top() {
        return myStack.peek()[0];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */