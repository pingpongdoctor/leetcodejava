import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
Solution: create a map of numbers and associated letters. Use backtracking and dfs to track all possible solution.
Time complexity: O(4^n) using geometric series formular (r^h -1)/(r-1) with r is the number of paths at each node in tree visualization and h is the height of the tree. h = n + 1;
Space complexity O(3^a*4^b) with a is the number of digits that have 3 characters and b is the number of digit that have 4 characters.
*/

public class Leetcode17 {
    private static final HashMap<Integer,List<Character>> map = new HashMap<>();;

    static {
        map.put(2,Arrays.asList('a','b','c'));
        map.put(3,Arrays.asList('d','e','f'));
        map.put(4,Arrays.asList('g','h','i'));
        map.put(5,Arrays.asList('j','k','l'));
        map.put(6,Arrays.asList('m','n','o'));
        map.put(7,Arrays.asList('p','q','r','s'));
        map.put(8,Arrays.asList('t','u','v'));
        map.put(9,Arrays.asList('w','x','y','z'));
    }
    
    public List<String> letterCombinations(String digits) {
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();

        helper(digits, 0, path, result);
        return result;
    }
    
    private void helper(String digits, int next, StringBuilder path, List<String> result) {
        if(path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        if (next >= digits.length()) {
            return;
        }

        int nextDigit = digits.charAt(next) - '0';

        if(!map.containsKey(nextDigit)) {
            return;
        }

        List<Character> list = map.get(nextDigit);
        
        for (int i = 0; i < list.size(); i++) {
            char cur = list.get(i);
            path.append(cur);
            helper(digits, next+1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}