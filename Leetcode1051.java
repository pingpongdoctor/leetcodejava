//Count sorting with no comparision. Time complexity: O(n). Space complexity: O(n)

public class Leetcode1051 {
    public int heightChecker(int[] heights) {
        int[] expected = new int[101];

        for(int height : heights) {
            expected[height]++;
        }

        int[] list = new int[heights.length];
        int j = 0;

        for(int i = 0; i < expected.length; i++) {
            while (expected[i] > 0) {
                list[j++] = i;
                expected[i]--;
            }
        }

        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != list[i]) {
                count++;
            }
        }
        return count;
    }
}