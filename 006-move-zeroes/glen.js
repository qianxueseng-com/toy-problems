/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {

    var i,
        len = nums.length;
    for (i = 0; i < len; ++i) {
        var  key = nums[i];
        if (key === 0) {
            nums.splice(i,1);
            nums.push(0);
            i--;
            len--;
        }
    }

};
