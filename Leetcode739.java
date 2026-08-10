/**
Solution 1: decreasing monotoic stack
0     1   2   3   4   5   6   7
1     1   4   2   1   1   0   0
                                  i  
<-<-

[]

if arr[i] < top || stack is empty -> add arr[i] to stack, i++
while not stack empty and arr[i] >= top -> pop top element, arr[popIdx] = i - popIdx

Time complexity O(n);
Space complexity 0(n)

Test
0   1   2   3   4   5   6   7   8   9
89  1  70  58  47  47  46  76  100 70
                    i

<-89,1  70,2    58,3<-
popped = 47,4
*/

public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> myStack = new ArrayDeque<>();
        int i = 0;

        while (i < temperatures.length) {
            while (!myStack.isEmpty() && temperatures[i] > myStack.peek()[0]) {
                int[] poppedEle = myStack.pop();
                temperatures[poppedEle[1]] = i - poppedEle[1];
            }

            myStack.push(new int[]{temperatures[i], i});
            
            i++;
        }

        while (!myStack.isEmpty()) {
            int[] poppedEle = myStack.pop();
            temperatures[poppedEle[1]] = 0;
        }

        return temperatures;
    }
}