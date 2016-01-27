/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    var res = [];
    res.push([]);
    nums.sort(function(val1, val2) {
        return val1-val2;
    });
    //init
    if(nums.length === 0)
        return res;
    res.push([nums[0]]);
    var lastAddNum = 1;
    for(var i = 1; i < nums.length; i++) {
        var begin = nums[i] === nums[i-1] ? res.length-lastAddNum : 0;
        var end = res.length;
        lastAddNum = 0;
        for(var j = begin; j < end; j++) {
            var set = [].concat(res[j]);
            set.push(nums[i]);
            res.push(set);
            lastAddNum++;
        }
    }
    return res;
};