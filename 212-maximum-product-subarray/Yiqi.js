/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    if(nums.length === 0)
        return 0;
    var res = nums[0], min = nums[0], max = nums[0];
    nums.forEach(function(item, idx) {
        //ignore the first element
        if(idx === 0)
            return;
        var tmpMax = max;
        max = Math.max(Math.max(max * item, min * item), item);
        min = Math.min(Math.min(tmpMax * item, min * item), item);
        res = Math.max(res, max);
    })
    return res;
};