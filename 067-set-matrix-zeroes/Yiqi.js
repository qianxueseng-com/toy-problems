/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */

//use o(m+n) space
var setZeroes = function(matrix) {
    //use rows and cols to track which rows and cols should be change to zero
    var rows = {}, cols = {};
    matrix.forEach(function(row, rIndex, m) {
        row.forEach(function(item, cIndex, r) {
            if(item === 0) {
                rows[rIndex] = true;
                cols[cIndex] = true;
            }
        });
    });
    matrix.forEach(function(row, rIndex, m) {
        row.forEach(function(item, cIndex, r) {
            if(rows.hasOwnProperty(rIndex) || cols.hasOwnProperty(cIndex))
                m[rIndex][cIndex] = 0;
        })
    });
};

//use o(1) space
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    if(matrix.length === 0 || matrix[0].length === 0)
        return;
    var changeRow0To0 = false, changeCol0To0 = false;
    //should we change first row to zeros
    matrix[0].forEach(function(item, idx, array) {
        if(item === 0) 
            changeRow0To0 = true;
    });
    //should we change first column to zeros
    matrix.forEach(function(row, rIndex, m) {
        if(row[0] === 0)
            changeCol0To0 = true;
    });
    //use first row and first col to indicate whether to change corresponding
    //row and col to zero
    for(var i = 1; i < matrix.length; i++) {
        for(var j = 1; j < matrix[0].length; j++) {
            if(matrix[i][j] === 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    for(i = 1; i < matrix.length; i++) {
        for(j = 1; j < matrix[0].length; j++) {
            if(matrix[i][0] === 0 || matrix[0][j] === 0)
                matrix[i][j] = 0;
        }
    }
    if(changeRow0To0) {
        matrix[0].forEach(function(item, col, r) {
            r[col] = 0;
        })
    }
    if(changeCol0To0) {
        matrix.forEach(function(row, rIndex, m) {
            row[0] = 0;
        })
    }
};