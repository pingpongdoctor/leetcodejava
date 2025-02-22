// 79. Word Search
// DFS and backtracking to find the matched string
public class WordSearch {
    private boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] visit){
        if(idx == word.length()){
            return true;
        }
        
        int row = board.length;
        int column = board[0].length;

        if(Math.min(r,c)<0 || r == row || c == column || visit[r][c]){
            return false;
        }

        if(word.charAt(idx) != board[r][c]){
            return false;
        }

        visit[r][c] = true;

        if(dfs(board,word,idx+1,r+1,c,visit) || dfs(board,word,idx+1,r-1,c,visit) || dfs(board,word,idx+1,r,c+1,visit) || dfs(board,word,idx+1,r,c-1,visit)){
            return true;
        };

        visit[r][c] = false;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visit = new boolean[row][column];

        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                char firstChar = word.charAt(0);
                if(board[r][c] == firstChar){
                    if(dfs(board,word,0,r,c,visit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
