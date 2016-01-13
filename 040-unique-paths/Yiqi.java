public class Solution {
    public int uniquePaths(int m, int n) {
        int[] numOfPath = new int[n];
        for(int i = 0; i < numOfPath.length; i++)
            numOfPath[i] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                numOfPath[j] += numOfPath[j-1];
            }
        }
        return numOfPath[n-1];
    }
}