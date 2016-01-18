public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1;
        while(left < right-1) {
            int mid = (left + right)/2;
            if(matrix[mid][0] == target)
                return true;
            else if(matrix[mid][0] < target)
                left = mid;
            else 
                right = mid;
        }
        //determine which row will be used to do second binary search
        //do not forget situation that left == right
        int idx = -1;
        if(matrix[left][0] > target)
            return false;
        else if(matrix[left][0] <= target && matrix[right][0] > target)
            idx = left;
        else if(matrix[right][0] <= target)
            idx = right;
        int i = 0, j = matrix[idx].length-1;
        while(i < j - 1) {
            int mid = (i+j)/2;
            if(matrix[idx][mid] == target)
                return true;
            else if(matrix[idx][mid] < target) 
                i = mid;
            else
                j = mid;
        }
        if(matrix[idx][i] == target || matrix[idx][j] == target)
            return true;
        return false;
    }
}