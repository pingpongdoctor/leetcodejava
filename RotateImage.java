//48. Rotate Image
//Transpose diagonally and Reverse
public class RotateImage {
  public void rotate(int[][] matrix) {
    // transpose diagonally (swich rows and columns to result in new matrix)
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }

    // reverse vertices in each row
    for (int i = 0; i < matrix.length; i++) {
      int left = 0;
      int right = matrix[0].length - 1;
      while (left < right) {
        int tmp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = tmp;
        left++;
        right--;
      }
    }
  }
}