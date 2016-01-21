/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    var left = 0, right = nums.length-1;
    while(left <= right) {
        var mid = Math.floor((left + right) / 2);
        if(nums[mid] === target)    
            return mid;
        else if(nums[mid] < target) 
            left = mid+1;
        else
            right = mid-1;
    }
    return left;
};