/**
Use 1 stack to check if there are invalid open braces' indices and set to track if there are invalid open braces' indices
0   1   2   3   4   5   6   7   8   9   10  11  12
l   e   e   (   t   (   c   )   o   )   d   e   )
                                                i

<-<-
12

if not ( or ) ->. skip
if ( -> add to stack the index
if ) ->
    if stack is empty -> add index to set
    else -> pop the stack element

in the end, all indices in stack and set left are invalid. Use them to form the string correctly

Time complexity: O(n)
Space complexity:O(n)
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        // open parenthesis is 1 and close parenthesis is 2
        ArrayDeque<Integer> myStack = new ArrayDeque<>();
        HashSet<Integer> mySet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                myStack.push(i);
            }
            if(cur == ')') {
                if(myStack.isEmpty()) {
                    mySet.add(i);
                } else {
                    myStack.pop();
                }
            }
        }

        while (!myStack.isEmpty()) {
            mySet.add(myStack.pop());
        }

        for (int i = 0; i < s.length(); i++) {
            if (mySet.contains(i)) {
                continue;
            }

            result.append(s.charAt(i));
        }

        return result.toString();
    }
}