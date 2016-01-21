/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    var xor = 0;
    for(var i = 0; i <= nums.length; i++) {
        xor ^= i;
    }
    nums.forEach(function(item) {
        xor ^= item;
    });
    return xor;
};