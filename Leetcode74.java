/**
Solution: binary search
Time complexity: O(log(m) + log(n))
Space complexity: O(1)
*/

public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int first = 0;
        int last = row - 1;

        while (first <= last) {
            int midRow = first + (last - first)/2;

            if(target >= matrix[midRow][0] && target <= matrix[midRow][column - 1]) {
                int left = 0;
                int right = column - 1;

                while (left <= right) {
                    int midColumn = left + (right-left)/2;
                    int midValue = matrix[midRow][midColumn];

                    if (target == midValue) {
                        return true;
                    } else if(target > midValue) {
                        left = midColumn + 1;
                    } else {
                        right = midColumn - 1;
                    }
                }

                return false;

            } else if (target < matrix[midRow][0]) {
                last = midRow - 1;
            } else {
                first = midRow + 1;
            }
        }

        return false;
    }  

}