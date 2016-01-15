/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    var numOfPath = [];
    //initialize first row
    obstacleGrid[0].forEach(function(item, idx, array) {
       numOfPath.push(0);
    });
    numOfPath[0] = 1;
    //calculate
    obstacleGrid.forEach(function(ithRow, i, obs) {
        ithRow.forEach(function(item, j, rowArray) {
            if(item == 1)
                numOfPath[j] = 0;
            else if(j > 0)
                numOfPath[j] += numOfPath[j-1];
        });
    });
    return numOfPath[obstacleGrid[0].length-1];
};