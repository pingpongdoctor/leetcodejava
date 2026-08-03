import java.util.ArrayDeque;
import java.util.Deque;

/**
1   2   3   4

stack
<-1  2  3  4<-
<-2 3  4<-

while loop to keep poping elements from stack1 until it is empty. Each popped element is then pushed to the stack2 except for the last element that is popped.
Then, dump all element from the stack2 to stack1, the first transfered element is the new element at the front of the implemented queue.
*/

class Leetcode232 {
    private int front;
    private Deque<Integer> myQueue;

    public MyQueue() {
        front = -1;
        myQueue = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        if(myQueue.size() == 0) {
            front = x;
        }

        myQueue.push(x);
    }
    
    public int pop() {
        if(myQueue.size() < 2) {
            int result = myQueue.pop();
            front = -1;
            return result;
        }

        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        int result = 0;

        while(myQueue.size() > 0) {
            int deleted = myQueue.pop();
            if (myQueue.size() > 0) {
                stack2.push(deleted);
            } else {
                result = deleted;
            }
        }

        while (stack2.size() > 0) {
            int temp = stack2.pop();
            myQueue.push(temp);

            if(myQueue.size() == 1) {
                front = temp;
            }
        }

        return result;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return myQueue.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

