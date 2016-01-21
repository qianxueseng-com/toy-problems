/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var res = [], items = [];
    candidates.sort(function(val1, val2) {
        return val1-val2;
    });
    helper(res, items, candidates, 0, target);
    return res;
};

function helper(res, items, candidates, start, target) {
    if(target === 0) {
        var tmp = items.concat();
        res.push(tmp);
    }
    for(var i = start; i < candidates.length; i++) {
        if(candidates[i] > target)
            return;
        items.push(candidates[i]);
        helper(res, items, candidates, i, target-candidates[i]);
        items.pop();
    }
}