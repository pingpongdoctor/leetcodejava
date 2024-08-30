// 74. Search a 2D Matrix
class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    //convert 2D to 1D array and implement binary search
    //calculate 2D indices using 1D index: rowIndex = mid/column and columnIndex = mid%column
      int row = matrix.length;
      int column = matrix[0].length;
      int left = 0;
      int right = row*column - 1;

      while(right>=left){
          int mid = (left + right)/2;
          int midValue = matrix[mid/column][mid%column];
          if(midValue > target){
              right = mid - 1;
          } else if (midValue < target){
              left = mid + 1;
          } else {
              return true;
          }
      }
      
      return false;
  }
}