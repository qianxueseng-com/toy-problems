public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(board, visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, boolean[][] visited, String word, int x, int y, int idx) {
        if(idx == word.length())
            return true;
        int m = board.length, n = board[0].length;
        //x, y should be inside board, not visited before and board[x][y] should match char in word
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || board[x][y] != word.charAt(idx))
            return false;
        visited[x][y] = true;
        boolean res = helper(board, visited, word, x+1, y, idx+1) ||
                      helper(board, visited, word, x-1, y, idx+1) ||
                      helper(board, visited, word, x, y-1, idx+1) ||
                      helper(board, visited, word, x, y+1, idx+1);
        //backtracking: restore the visited state, so that other paths can use char here
        visited[x][y] = false;
        return res;
    }
}