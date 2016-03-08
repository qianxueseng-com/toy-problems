/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n > 0 && !(n & n - 1);
};

console.log(isPowerOfTwo(4));
console.log(isPowerOfTwo(3));
console.log(isPowerOfTwo(0));