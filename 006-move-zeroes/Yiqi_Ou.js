/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var idx = 0;
    nums.forEach(function(item, index, array) {
       if(item) {
           var tmp = array[idx];
           array[idx++] = item;
       } 
    });
    for(var i = idx; i < nums.length; i++) {
        nums[i] = 0;
    }
};