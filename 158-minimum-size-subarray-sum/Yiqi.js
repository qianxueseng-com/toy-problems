/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
    if(nums.length === 0)
        return 0;
    //test adding all numbers is larger than s
    var tmpSum = nums.reduce(function(pre, cur, idx, array) {
       return pre + cur; 
    });
    if(tmpSum < s)
        return 0;
    //generate sum array so that sum[i] = nums[0]+..+nums[i-1]
    var sum = [];
    sum.push(0);
    nums.forEach(function(item, idx, array) {
       sum.push(sum[sum.length-1] + item); 
    });
    var res = nums.length;
    for(var i = 0; i < nums.length; i++) {
        var right = binarySearch(sum, i, i, nums.length-1, s);
        if(right == nums.length)
            break;
        res = Math.min(res, right-i+1);
    }
    return res;
};

/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
    if(nums.length === 0)
        return 0;
    var tmpSum = nums.reduce(function(pre, cur, idx, array) {
       return pre+cur; 
    });
    if(tmpSum < s)
        return 0;
    tmpSum = 0;
    var left = 0, right = 0, res = nums.length;    
    while(right < nums.length) {
        while(tmpSum < s && right < nums.length) {
            tmpSum += nums[right++];
        }
        while(tmpSum >= s) {
            res = Math.min(right-left, res);
            tmpSum -= nums[left++];
        }
    }
    return res;
};

function binarySearch(sum, i, left, right, s) {
    while(left <= right) {
        var mid = Math.floor((left + right)/2);
        var tmpSum = sum[mid+1] - sum[i];
        if(tmpSum == s) {
            left = mid;
            break;
        }
        else if(tmpSum > s) {
            right = mid-1;
        }
        else {
            left = mid+1;
        }
    }
    return left;
}