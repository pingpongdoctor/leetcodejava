// 74. Search a 2D Matrix
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        if(row==1 && column==1){
            return matrix[0][0] == target;
        }

        for(int r = 0; r<row; r++){
            int L = 0;
            int R = column - 1;

            if(target > matrix[r][R]){
                continue;
            }
            if(target < matrix[r][L]){
                return false;
            }

            while(L<=R){
                int mid = L + (R-L)/2;
                int cur = matrix[r][mid];
                if(target > cur){
                    L = mid+1;
                } else if(target < cur){
                    R = mid -1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
