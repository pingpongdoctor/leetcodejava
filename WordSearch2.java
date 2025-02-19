import java.util.ArrayList;
import java.util.List;

// 212. Word Search II
// dfs using trienode to save memory rather than using stringbuilder
public class WordSearch2 {
    class TrieNode{
        String word;
        TrieNode[] neighbors;
        public TrieNode(){
            neighbors = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    private void insert(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.neighbors[c-'a']==null){
                cur.neighbors[c-'a'] = new TrieNode();
            }
            cur = cur.neighbors[c-'a'];
        }
        cur.word = word;
    }
    private void dfs(char[][] board, int r, int c, List<String> ans, TrieNode node){
        int m = board.length;
        int n = board[0].length;
        if(node.word!=null){
            ans.add(node.word);
            node.word=null;
        }
        if(Math.min(r,c)<0 || r==m || c==n || board[r][c]=='.'){
            return;
        }
        char cur = board[r][c];
        TrieNode[] neighbors = node.neighbors;
        TrieNode neighbor = neighbors[cur - 'a'];

        if(neighbor==null){
            return;
        }

        board[r][c] = '.';

        dfs(board,r+1,c,ans,neighbor);
        dfs(board,r-1,c,ans,neighbor);
        dfs(board,r,c+1,ans,neighbor);
        dfs(board,r,c-1,ans,neighbor);

        board[r][c] = cur;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dfs(board,i,j,ans,root);
            }
        }
        return ans;
    }
}
