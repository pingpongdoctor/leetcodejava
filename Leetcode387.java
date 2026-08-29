/**
Solution 1: Save the all characters in a map where keys are characters and values are the index. When a new character is already included in map, the pair of that character will have value -1. At the end, all keys left in the map that do not have value -1 are the non-repeating characters. Loop through the map and return the smallest value of a key which is the index the the first non-repeating character.

"leetcode"

key     value
l          0
e          -1
t          3
c          4
o          5
d          6

Time complexity: O(n)
Space complexity: O(n)

Test:
"leetcode"

key     value
 l         0
 e          -1
 t          3
 c          4
 o          5
 d          6

Solution 2: Store the frequency of all charaters in a map. Then loop through the string from the left. Return the first character included in the map that has frequency 1 since it the first non-repeating character

Time complexity: O(n)
Space complexity: O(n)
*/

public class Leetcode387 {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur,0) + 1);
        }
        
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);

            if (map.get(cur) == 1) {
                return j;
            }
        }

        return -1;
    }
}