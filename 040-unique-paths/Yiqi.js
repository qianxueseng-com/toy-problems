/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
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