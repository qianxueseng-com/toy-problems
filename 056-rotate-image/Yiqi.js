/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    var n = matrix.length;
    for(var i = 0; i < Math.floor(n/2); i++) {
        for(var j = i; j < n-1-i; j++) {
            var tmp = matrix[n-1-j][i];
            matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
            matrix[n-1-i][n-1-j] = matrix[j][n-i-1];
            matrix[j][n-1-i] = matrix[i][j];
            matrix[i][j] = tmp;
        }
    }
};