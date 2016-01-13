/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */

 //The problem has an obvious recursive pattern. The number of paths to grid[i][j]
 //is equal to grid[i-1][j] + grid[i][j]. So we can easily solve it recursively.
 //But in that way, we compute the same results repeatedly which makes me think that 
 //we can use dynamic programming to reduce time complexity. We can define a two dimension
 //array and compute from grid[0][0]. Thus we got time complexity o(n*m) solution.
 //I notice the value of grid[i][j] is only based on grid[i-1][j] and grid[i][j-1], current value's
 //upper and left element. Thus we can reduce space by using one dimensional array
var uniquePaths = function(m, n) {
    var numOfPath = [];
    for(var i = 0; i < n; i++)
        numOfPath.push(1);
    for(i = 1; i < m; i++) {
        for(var j = 1; j < n; j++) {
            numOfPath[j] += numOfPath[j-1];
        }
    }
    return numOfPath[n-1];
};