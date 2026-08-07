/**
Using two stacks
["4","13","5","/","+"]
result = 13/5
stack
<-4 13/5<-
operator = +
a = 13/5
b = 4
temp = 13/5+4 = 6

a = stack.pop();
b = stack.pop();
if(/ || -) {
b/a
b - a
} else {
a*b
a+b

Time complexity: O(n)
Space complexity: O(n)
}

Test:
["4","13","5","/","+"]

<-   <-

cur = +
a = 2
b = 4
result = 6

*/

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length < 3) {
            return Integer.parseInt(tokens[0]);
        }

        Deque<Integer> myStack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];

            if(!cur.equals("+") && !cur.equals("-") && !cur.equals("/") && !cur.equals("*")) {
                myStack.push(Integer.parseInt(cur));
                continue;
            }

            int a = myStack.pop();
            int b = myStack.pop();
            int result = 0;

            switch(cur) {
                case "/" -> result = b / a;
                case "-" -> result = b - a;
                case "+" -> result = a + b;
                case "*" -> result = a * b;
            }

            myStack.push(result);
        }

        return myStack.pop();
    }
}

