/**
Solution 1: Use hashmap to recognize the duplicates. Since the hashmap save keys and element values and values as indices, we can know which is the duplicate of the current element. As a result, we can use a sliding window to expand when there are no duplicates and to shrink to the next element of the duplicate. We use a variable named max to store the maximum length of the valid substrings.
0   1   2   3   4   5   6   7
a   b   c   a   b   c   b   b
    l
                r

max = 3
count = 1

if count > max -> set count to max
when duplicates -> update max, move left to the duplicate index + 1 if left < index + 1 (we only shrink from the left since we do not want to reprocess the elements that are opted out from the sliding window), count = r - l + 1, update the duplicate character index in the map to j
r++
if r is out of bound, update the max using the current count and terminate the loop

key     value (index)
 a         3
 b         7
 c         5

return max

Time complexity: O(n)
Space complexity: O(n)

Test
0   1   2   3   4   5
p   w   w   k   e   w
            l
                        r

cur = w
max = 3
count = 3

key     value
p          0
w          2
k          3
e           4

return max
0   1   2   3   4   5
c   c   b   b   c   c
            l
                r

max = 2
count = 1

key     value
c          1
b           3
*/

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;

        while (r < s.length()) {
            char cur = s.charAt(r);

            if (!map.containsKey(cur)) {
                map.put(cur,r);
                count++;
            } else {
                max = Math.max(max,count);
                int temp = map.get(cur) + 1;
                l = temp > l ? temp : l;
                count = r - l + 1;
                map.put(cur, r);
            }

            r++;
        }

        max = Math.max(max,count);

        return max;
    }
}