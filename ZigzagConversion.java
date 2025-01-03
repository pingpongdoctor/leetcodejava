import java.util.ArrayList;
import java.util.List;

//6. Zigzag Conversion
//using two pointers method to navigate to row and column indices in order to build 2D array
public class ZigzagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1 || s.length() <= numRows) {
      return s;
    }

    @SuppressWarnings("unchecked")
    List<Character>[] rows = new List[numRows];
    for (int i = 0; i < numRows; i++) {
      rows[i] = new ArrayList<Character>();
    }

    int r = 0;
    int dr = -1;

    for (char i : s.toCharArray()) {
      rows[r].add(i);
      if (r == numRows - 1 && dr == -1) {
        dr = 1;
      }
      if (r == 0 && dr == 1) {
        dr = -1;
      }

      if (dr == -1) {
        r++;
      } else {
        r--;
      }
    }

    StringBuilder ans = new StringBuilder();
    for (List<Character> row : rows) {
      for (Character C : row) {
        ans.append(C);
      }
    }
    return ans.toString();
  }
}