public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] res = new int[grid[0].length];
        res[0] = grid[0][0];
        for(int i = 1; i < res.length; i++) 
            res[i] += res[i-1] + grid[0][i];
        
        for(int i = 1; i < grid.length; i++) {
            res[0] += grid[i][0];
            for(int j = 1; j < grid[0].length; j++) {
                res[j] = Math.min(res[j], res[j-1]) + grid[i][j];
            }
        }
        return res[grid[0].length-1];
    }
}