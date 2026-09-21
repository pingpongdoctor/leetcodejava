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
}