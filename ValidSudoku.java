import java.util.HashSet;
import java.util.Set;

//36. Valid Sudoku
public class ValidSudoku {
  // use set to track duplicate values
  public boolean isValidSudoku(char[][] board) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] rows = new Set[9];
    @SuppressWarnings("unchecked")
    Set<Integer>[] columns = new Set[9];
    @SuppressWarnings("unchecked")
    Set<Integer>[][] box = new Set[3][3];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
      columns[i] = new HashSet<>();
    }

    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        box[j][k] = new HashSet<>();
      }
    }

    for (int i = 0; i < 9; i++) {
      char[] curR = board[i];

      for (int j = 0; j < 9; j++) {
        if (!Character.isDigit(curR[j])) {
          continue;
        }

        int cur = curR[j] - '0';

        if (rows[i].contains(cur)) {
          return false;
        } else {
          rows[i].add(cur);
        }

        if (columns[j].contains(cur)) {
          return false;
        } else {
          columns[j].add(cur);
        }

        if (box[i / 3][j / 3].contains(cur)) {
          return false;
        } else {
          box[i / 3][j / 3].add(cur);
        }
      }
    }

    return true;
  }

  // use one hashset to store string of value and its coordinate
  // more readable
  public boolean isValidSudoku2(char[][] board) {
    Set<String> seen = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char cur = board[i][j];
        if (!Character.isDigit(cur)) {
          continue;
        }

        if (!seen.add("row" + i + "value" + cur) || !seen.add("column" + j + "value" + cur)
            || !seen.add("box" + i / 3 + "and" + j / 3 + "value" + cur)) {
          return false;
        }
      }
    }
    return true;
  }
}