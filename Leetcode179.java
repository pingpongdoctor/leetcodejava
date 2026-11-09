import java.util.Arrays;

/**
Instead of comparing Integer, we compare string. First, we need to covert the array into the string array. "330" always come after "303". Using comparator when sorting the array, we can compare teh string formed by a+b and b+a. If a+b is greater than b+a, a should come before be as well as the comparator function should return a negative number. That is why we need to use reversed order (b+a).compareTo(a+b).

Time complexity: O(nlogn)
Space complexity: O(n)
*/

public class Leetcode179 {
    public String largestNumber(int[] nums) {
        String[] newList = new String[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            newList[i] = nums[i] + "";
        }

        Arrays.sort(newList, (a,b) -> {
            return (b+a).compareTo(a+b);
        });

        StringBuilder str = new StringBuilder();

        for(String ele : newList) {
            str.append(ele);
        }
        if(newList[0].equals("0")) {
            return "0";
        }
        return str.toString();
    }
}