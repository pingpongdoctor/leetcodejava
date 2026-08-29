/**
Solution 1: Use hashmap to store the character frequency of one string and check if the other string have charaters that exists in the map. When I encouter one existing character, I decrement the frequency. If the frequency is 0, I remove the character and its frequency from the map. If the map is empty after the loop terminates, it means all characters in 2 string match based on character and frequency.
*/

public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            char cur = t.charAt(j);

            if(!map.containsKey(cur)) {
                return false;
            }

            if (map.get(cur) > 1) {
                map.put(cur, map.get(cur) - 1);
            } else {
                map.remove(cur);
            }
        }

        return map.isEmpty();
    }
}