//use o(m+n) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}

//use constant space
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean changeRow0To0 = false, changeCol0To0 = false;
        //detect should we change first col to zero
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                changeCol0To0 = true;
                break;
            }
        }
        //detect should we change first row to zero
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                changeRow0To0 = true;
                break;
            }
        }
        //keep note of whether should we change the corresponding row and col to zero
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //make change
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        //change first row and first col
        if(changeRow0To0) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if(changeCol0To0) {
            for(int i = 0; i < matrix.length; i++) 
                matrix[i][0] = 0;
        }
    }
}