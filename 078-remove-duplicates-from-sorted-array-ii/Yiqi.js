/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var idx = 0, count;
    for(var i = 0; i < nums.length; i++) {
        if(i !== 0 && nums[i] === nums[i-1]) {
            count++;
            if(count >= 3)
                continue;
        }
        else {
            count = 1;
        }
        nums[idx++] = nums[i];
    }
    return idx;
};