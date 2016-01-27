public class Solution {
    public int[][] generateMatrix(int n) {
        int i = 0, j = 0, level = 0, count = n*n, num = 1;
        int[][] res = new int[n][n];
        char dir = 'r';
        while(count > 0) {
            res[i][j] = num++;
            if(dir == 'r') {
                if(j != n-1-level)
                    j++;
                else {
                    dir = 'd';
                    i++;
                }
            }
            else if(dir == 'd') {
                if(i != n-1-level)
                    i++;
                else {
                    dir = 'l';
                    j--;
                }
            }
            else if(dir == 'l') {
                if(j != level) 
                    j--;
                else {
                    dir = 'u';
                    i--;
                }
            }
            else {
                if(i != level + 1) 
                    i--;
                else {
                    level++;
                    dir = 'r';
                    j++;
                }
            }
            count--;
        }
        return res;
    }
}