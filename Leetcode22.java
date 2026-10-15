/**
Solution: Recursion and Backtracking. Build the combination of parentheses by recursively either adding opening bracket or closing bracket to an initial string of one opening bracket. It can be visualized as a tree that has left branch and right branch making decision to add ( or ). Base case is when number of opening bracket is equal to n and so do closing bracket. Only traverse into the right branch to add ) if the number of closing bracket is less than that of opening bracket.

Time complexity: O(2nk) the number of operations is equal to 2nk with 2n is the number of character in each valid string and k is the number of valid string. To form a valid string, it takes at most 2n steps for every string since the paths leading to the valid strings share nodes. For example, 1 path has 6 steps but 2 paths might only need 10 steps since 2 nodes are shared. The tree paths leading to invalid string are not taken by using the condition of adding closing brackets when num of close bracket is less than num of open bracket

Space complexity: O(2n + 2n + 2nk) with k is the valid string number. It takes 2n space for the call stack, 2n space for the string builder, 2nk for the space of result array
*/

public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append("(");
        helper(1, 0, n, str, result);
        return result;
    }

    private void helper(int o, int c, int n, StringBuilder str, List<String> result) {
        if (o == n && c==n) {
            result.add(str.toString());
            return;
        }

        if (o < n) {
            str.append("(");
            helper(o+1, c, n, str, result);
            str.deleteCharAt(str.length() - 1);
        }

        if (c < n && c < o) {
            str.append(")");
            helper(o, c+1, n, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}