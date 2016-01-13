public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] numOfPath = new int[m];
        //initialize first row
        int idx = 0;
        for(idx = 0; idx < m; idx++) {
            if(obstacleGrid[0][idx] == 1)
                break;
        }
        for(int i = 0; i < idx; i++) {
            numOfPath[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //since for case j == 0, we only change numOfPath[0] to 0 when
                //obstacleGrid[i][j] == 1
                if(obstacleGrid[i][j] == 1)
                    numOfPath[j] = 0;
                else if(j > 0) {
                    numOfPath[j] += numOfPath[j-1];
                }
            }
        }
        return numOfPath[m-1];
    }
}