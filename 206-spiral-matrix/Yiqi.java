public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        int min = Math.min(m, n);
        for(int l = 0; l < min / 2; l++) {
            //go right direction
            for(int j = l; j < n-l; j++)
                res.add(matrix[l][j]);
            //go down direction
            for(int i = l+1; i < m-l; i++) 
                res.add(matrix[i][n-1-l]);
            //go left direction
            for(int j = n-2-l; j >= l; j--)
                res.add(matrix[m-1-l][j]);
            //go up direction
            for(int i = m-2-l; i >= l+1; i--) 
                res.add(matrix[i][l]);
        }
        //add remaining row or col
        if(min % 2 == 1) {
            //if one row remains
            if(min == m) {
                for(int j = min/2; j < n-min/2; j++)
                    res.add(matrix[min/2][j]);
            }
            //if one col remains
            else {
                for(int i = min/2; i < m-min/2; i++)
                    res.add(matrix[i][min/2]);
            }
        }
        return res;
    }
}


//another solution which I think it is simpler
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return res;
        int i = 0, j = 0, layer = 0, m = matrix.length, 
            n = matrix[0].length, count = m * n;
        char dir = 'r';
        while(count > 0) {
            res.add(matrix[i][j]);
            count--;
            if(dir == 'r') {
                if(j != n - 1 - layer) 
                    j++;
                else {
                    i++;
                    dir = 'd';
                }
            }
            else if(dir == 'd') {
                if(i != m - 1 -layer)
                    i++;
                else {
                    j--;
                    dir = 'l';
                }
            }
            else if(dir == 'l') {
                if(j != layer) 
                    j--;
                else {
                    i--;
                    dir = 'u';
                }
            }
            else {
                if(i != layer+1) 
                    i--;
                else {
                    j++;
                    layer++;
                    dir = 'r';
                }
            }
        }
        return res;
    }
}