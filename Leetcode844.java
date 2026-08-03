/**
Questions:
Can the string be empty?
Can there be uppercase letters? If yes, are they case sensitive?
What is the maximum and minimum length of the strings?
Can two strings have different lengths?

Solution 1: I will use a stack because a backspace removes the most recently typed character, which follows the Last-In-First-Out principle

s = "ab#c", t = "ad#c"
<-a c<-
<-a c<-
if cur is not #, push
if cur is # and the stack is empty, do nothing
if cur is # and the stack is not empty, pop the top element

if stack1 size is not equivalent to stack2 size => return false
use a while loop to compare stack1.pop() == stack2.pop()

Time complexity: O(2(m+n)) = O(m+n)
Space complexity: O(m+n)

Test
"ab##", t = "c#d#"

<-<-

return true

Solution 2: Traverse both strings from right to left and use skip counters to track backspaces. Skip invalid characters until reaching the next valid ones, then compare them. Return false if they differ; otherwise return true.
*/

public class Leetcode844 {
    private Deque<Character> helper(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(cur == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }

        return stack;
    }

    public boolean backspaceCompare(String s, String t) {
        // Handle first string
        Deque<Character> stack1 = helper(s);
        // Handle second string
        Deque<Character> stack2 = helper(t);

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (stack1.size() > 0) {
            if(!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }

        return true;
    }
}