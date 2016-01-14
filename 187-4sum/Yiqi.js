/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    var res = [], items = [];
    if(nums.length < 4)
        return res;
    //javascript use lexical sort by default
    nums.sort(function(val1, val2) {
        return val1-val2;
    });
    for(var i = 0; i < nums.length-3; i++) {
        if(i !== 0 && nums[i] === nums[i-1]) 
            continue;
        items.push(nums[i]);
        threeSum(res, nums, items, i+1, target-nums[i]);
        items.pop();
    }
    return res;
};

function threeSum(res, nums, items, start, target) {
    for(var j = start; j < nums.length-2; j++) {
        if(j !== start && nums[j] === nums[j-1])
            continue;
        items.push(nums[j])
        twoSum(res, nums, items, j+1, target-nums[j]);
        items.pop();
    }
}

function twoSum(res, nums, items, start, target) {
    var left = start, right = nums.length-1, tmpItem = [];
    while(left < right) {
        if(nums[left] + nums[right] === target) {
            items.push(nums[left]);
            items.push(nums[right]);
            //clean tmpItem and push all elements in items into tmpItem
            tmpItem = [];
            tmpItem.push.apply(tmpItem, items);
            res.push(tmpItem);
            items.pop();
            items.pop();
            left++;
            while(left < right && nums[left] === nums[left-1])
                left++;
        }
        else if(nums[left] + nums[right] > target)
            right--;
        else
            left++;
    }
}