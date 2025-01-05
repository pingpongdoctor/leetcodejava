// 3. Longest Substring Without Repeating Characters
// Sliding window with set to track duplicate characters

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int L = 0;
    Set<Character> set = new HashSet<>();

    for (int R = 0; R < s.length(); R++) {
      while (set.size() > 0 && set.contains(s.charAt(R))) {
        set.remove(s.charAt(L));
        L++;
      }
      set.add(s.charAt(R));
      max = Math.max(max, R - L + 1);
    }
    return max;
  }
}