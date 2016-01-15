/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    var res = 0;
    nums.forEach(function(item, idx, array) {
        res = item ^ res;
    });
    return res;
};