/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var res = [];
    res.push([]);
    nums.sort(function(val1, val2) {
        return val1-val2;
    });
    for(var i = 0; i < nums.length; i++) {
        var size = res.length;
        for(var j = 0; j < size; j++) {
            var set = [].concat(res[j]);
            set.push(nums[i]);
            res.push(set);
        }
    }
    return res;
};