/**
Time complexity: O(n)
Space complexity: O(n)
*/

public class Leetcode91 {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return helper(0,s,memo);
    }

    private int helper(int i, String s, int[] memo) {
        if(i == s.length()) {
            return 1;
        }

        if(s.charAt(i) == '0') {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        int way = 0;
        way += helper(i+1,s,memo);

        if(i+1 < s.length()) {
            int twoInteger = Integer.parseInt(s.substring(i, i+2));
            if(twoInteger >= 1 && twoInteger <= 26) {
                way += helper(i+2,s,memo);
            }
        }

        memo[i] = way;

        return memo[i];
    }
}