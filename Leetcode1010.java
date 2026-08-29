/**
Qeustions:
What is the maximum and minimum length?
What is the maximum and minimum value of time?


0   1    2   3   4
30  20  150 100 40
                i

remainder = 30 -> check if map has the element with remainder 60 - 30
if yes, increment count by the frequency of the offset remainder, update the frequency of the current element remainder

count = 3

hashmap that store elements and their remainder
30  2
20  1
40  2

return count

Time complexity: O(n)
Space complexity: O(n)

count = 3

60  60  60
        i

cur = 60
remainder = 0
offset = 60

60  3
*/
public class Leetcode1010 {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length < 2) {
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < time.length; i++) {
            
            int cur = time[i];
            int remainder = cur % 60;

            if(map.isEmpty()) {
                map.put(remainder, 1);
                continue;
            }

            int offsetRemainder = remainder == 0 ? 0 : 60 - remainder;

            if (map.containsKey(offsetRemainder)) {
                count += map.get(offsetRemainder);        
            }

            map.put(remainder, map.getOrDefault(remainder,0) + 1);
        }

        return count;
    }
}