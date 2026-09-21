import java.util.ArrayList;
import java.util.List;

/**
Solution 1: Brute force. Generate all possible substring of the input and check if they are palindrom
0   1   2   3   4
b   a   b   a   d
    i
        j

i = 0 loop from i to 4
j = i + 1 innner loop from j to 4
"b" "ba"  "bab" ...

i = 1
j = 2
"a" "ab" "aba" ... 

Forming all possible substring takes O(n^2)

For each substring, it takes O(n) to check if it is a palindorm using two pointers

Time complexity: O(n^3)

Space complexity: O(n)
*/

public class Leetcode5 {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        // Forming the possible substrings
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();

            for (int j = i; j < s.length(); j++) {
                list.add(s.charAt(j));
                int l = 0;
                int r = list.size() - 1;
                boolean isPalindrom = true;

                // Check if substring is a palindrom
                while (l <= r) {
                    if(list.get(l).equals(list.get(r))) {
                        l++;
                        r--;
                    } else {
                        isPalindrom = false;
                        break;
                    }
                }

                if (isPalindrom && list.size() > max) {
                    max = list.size();
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindrome2(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Evalulate the case in which the palindrom has an even number of character
            int l = i;
            int r = i;

            while (l - 1 >= 0 && r + 1 < s.length()) {
                if(s.charAt(l-1) == s.charAt(r+1)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
                start = l;
                end = r;
            }

            int l2 = i;
            int r2 = i + 1;

            if (r2 < s.length() && s.charAt(r2) == s.charAt(l2)) {
                while (l2 - 1 >= 0 && r2 + 1 < s.length()) {
                    if(s.charAt(l2-1) == s.charAt(r2+1)) {
                        l2--;
                        r2++;
                    } else {
                        break;
                    }
                }

                if (r2 - l2 + 1 > max) {
                    max = r2 - l2 + 1;
                    start = l2;
                    end = r2;
                }
            }
        }

        return s.substring(start, end+1);
    }
}