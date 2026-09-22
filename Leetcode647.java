/**
Time complexity: O(n^2)
Space complexity: O(1)
*/

public class Leetcode647 {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            if (i+1 < s.length()) {
                l = i;
                r = i + 1;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    count++;
                    l--;
                    r++;
                }
            }
        }

        return count;
    }
}