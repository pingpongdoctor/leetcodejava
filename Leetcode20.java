/**
Solution 1: Use a stack to keep tracking the valid pairs of parenthesis

Edge case: string.length() == 1 -> return false
Edge case: string.charAt(0) is a closing bracket -> return false

0   1   2   3   4   5
(   )   [   ]   {   }
                    i
return true

0   1   2   3
(   [   ]   )
            j

return true
0   1   2   3
(   [   )   ]
        k

<-( [<-

return false

Use a while loop to process all characters
if it is an opening, add to stack.
If it is a closing bracket, compare with the top element of the stack. If they match, pop the top element out. If not match, return false.
After the loop terminates, if the stack is not empty, return false. Otherwise, return true.

Test:
{
"}" : "{",
"]" : "[",
")" : "(",
}

0   1   2   3
(   [   )   ]
        i

<-([<-

*/

public class Leetcode20 {
    public static final HashMap<Character,Character> map = new HashMap<Character,Character>();
    private Deque<Character> stack;

    public Solution() {
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        stack = new ArrayDeque<Character>();
    }

    public boolean isValid(String s) {
        if(s.length() == 1) {
            return false;
        }

        if(s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']') {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(!map.containsKey(cur)) {
                stack.push(cur);
            } else {
                // If the stack is empty at the time the cur is a closing bracket, return false
                if(stack.isEmpty()) {
                    return false;
                }

                if(map.get(cur) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}