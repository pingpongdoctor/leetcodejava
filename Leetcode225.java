/**
<-1 2  3  4<-  count = 2 temp = 2

Time complexity: O(1) for push, top, empty and O(n) for pop
Space complexity: O(n)
*/

public class Leetcode225 {

    private Deque<Integer> stack;
    private int top = -1;

    public MyStack() {
        stack = new ArrayDeque();
    }
    
    public void push(int x) {
        stack.offer(x);
        top = x;
    }
    
    public int pop() {
        int count = stack.size();
        int result = 0;

        while (count > 0) {
            int temp = stack.poll();

            if(count == 2) {
                top = temp;
            }

            if(count == 1) {
                result = temp;
                break;
            } else {
                stack.offer(temp);
                count --;
            }         
        }

        if(stack.size() == 0) {
            top = -1;
        }

        return result;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return stack.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */