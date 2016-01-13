/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var len = nums.length;
    var pos = 0;
    var temp;
    for (var i = 0; i < len; i++) {
        if (nums[i] !== 0) {
            if (pos !== i) {
                temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
            pos++;
        }
    }
};
