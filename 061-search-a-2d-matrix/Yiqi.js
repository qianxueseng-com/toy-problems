/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    var row1 = 0, row2 = matrix.length-1;
    //binary search to find which array to do second binary search
    while(row1 < row2 - 1) {
        var mid = Math.floor((row1 + row2) / 2);
        if(matrix[mid][0] === target)
            return true;
        else if(matrix[mid][0] > target) 
            row2 = mid;
        else
            row1 = mid;
    }
    //determine which array to do binary search, do not forget the 
    //situatio where row1 == row2
    var row = -1;
    if(target < matrix[row1][0])
        return false;
    else if(matrix[row1][0] <= target && matrix[row2][0] > target)
        row = row1;
    else if(matrix[row2][0] <= target)
        row = row2;
    var col1 = 0, col2 = matrix[0].length-1;
    while(col1 < col2 - 1) {
        mid = Math.floor((col1 + col2)/2);
        if(matrix[row][mid] === target) 
            return true;
        else if(matrix[row][mid] > target)
            col2 = mid;
        else 
            col1 = mid;
    }
    if(matrix[row][col1] === target || matrix[row][col2] === target)
        return true;
    return false;
};