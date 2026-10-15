/**
Solution: DFS through all cells that start with the first character in the target string in different directions. Since we can move in different dirrections, we should not visit the same cells of the current path so I can use a 2d visited array to track. Based case is when there are n characters in the string with n is the number of characters in the target string, we can true if the string is equivalent to the target string
Time complexity: O(m*n*4^L)
Space complexity: O(L)
*/

public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) { 
                    char temp = board[i][j];
                    board[i][j] = '1';
                    if (helper(board, i, j, word, 0)) {
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int r, int c, String word, int idx){
        if (idx == word.length() - 1) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        int[][] paths = {{r+1,c},{r,c+1},{r-1,c},{r,c-1}};

        for(int[] path : paths) {
            int curR = path[0];
            int curC = path[1];

            if(curR < m && curR >= 0 && curC < n && curC >= 0) {
                if(word.charAt(idx + 1) != board[curR][curC]) {
                    continue;
                }

                char temp = board[curR][curC];
                board[curR][curC] = '1';
                result = helper(board, curR, curC, word, idx + 1);
                board[curR][curC] = temp;

                if(result) {
                    return true;
                }
                
            }
        }

        return result;
    }
}