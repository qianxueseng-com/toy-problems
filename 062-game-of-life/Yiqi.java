public class Solution {
    //use two bits to represents board's current state and future state
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int numOfLive = calRound(board, i, j);
                //if there are 3 neighbours, then set 2nd bit
                if(numOfLive == 3)
                    board[i][j] = board[i][j] | 2;
                //if there are 2 neighbours, then set it as "11"
                else if(numOfLive == 2 && board[i][j] == 1)
                    board[i][j] = 3;
            }
        }
        //right shift to get future state
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    public int calRound(int[][] board, int x, int y) {
        int res = 0;
        for(int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++) {
                //i, j must be inside the board and do not calculate point at 
                //board[x][y]
                if(i >= 0 && i < board.length && j >= 0 && j < board[0].length
                && (i != x || j != y)) {
                    res += (board[i][j] & 1);
                }
            }
        }
        return res;
    }
}