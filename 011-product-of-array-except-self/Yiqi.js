/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    var output = [];
    output.push(1);
    //output[i] represents the production from a[0] ... a[i-1]
    for(var i = 1; i < nums.length; i++) {
        output.push(output[i-1] * nums[i-1]);
    }
    var outputAfter = nums[nums.length-1];
    for(i = nums.length-2; i >= 0; i--) {
        output[i] = outputAfter * output[i];
        outputAfter = outputAfter * nums[i];
    }
    return output;
};