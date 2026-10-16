import java.util.ArrayList;
import java.util.List;

/**
Solution: Backtracking to track all possible combination of substring that are palindrom partitioning.
Time complexity: O((n^2)/2 + 2^n + n*2^(n-1))
- n^2/2: fill the palindrome table (one cell per l <= r)
- 2^n: recursion nodes (cut-or-extend choice between each adjacent pair)
- n * 2^(n-1): copying up to 2^(n-1) valid partitions, each with up to n segments

Space complexity: O(n^2 + n + n*2^(n-1))
- n^2: palindrome table
- n: recursion depth
- n * 2^(n-1): stored result (up to 2^(n-1) partitions, each has upto n segments)
*/

public class Leetcode131 {
    public List<List<String>> partition(String s) {
        int[][] arr = new int[s.length()][s.length()];

        for(int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int l = j;
                int r = i + j - 1;

                if(l == r) {
                    arr[l][r] = 1;
                } else if(r - l == 1) {
                    arr[l][r] = s.charAt(l) == s.charAt(r) ? 1 : 0;
                } else {
                    arr[l][r] = s.charAt(l) == s.charAt(r) && arr[l+1][r-1] == 1 ? 1 : 0;
                }
            }
        }

        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        path.add(s.charAt(0) + "");
        helper(0,0,s,path,result, arr);

        return result;
    }

    private void helper(int i, int j, String s, List<String> path, List<List<String>> result, int[][] arr) {
        if (j == s.length() - 1) {
            if (arr[i][j] == 1) {
                result.add(new ArrayList(path));
            }
            return;
        }

        // start new palindrom only if the last element in the path is the palindrom
        if(arr[i][j] == 1) {
            path.add(s.charAt(j+1) + "");
            helper(j + 1, j + 1, s, path, result, arr);
            path.remove(path.size() - 1);
        }

        // extend the last element in the path
        String last = path.remove(path.size() - 1);
        path.add(last + s.charAt(j+1));

        helper(i, j + 1, s, path, result, arr);

        path.remove(path.size() - 1);
        path.add(last);
    }
}