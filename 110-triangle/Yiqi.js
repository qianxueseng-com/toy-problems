/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    if(triangle.length === 0 || triangle[0].length === 0)   
        return 0;
    var res = [];
    //init res array so that the length equals to last row of triangle
    for(var i = 0; i < triangle[triangle.length-1].length; i++)
        res.push(0);
    res[0] = triangle[0][0];
    for(i = 1; i < triangle.length; i++) {
        var nums = triangle[i];
        res[nums.length-1] = nums[nums.length-1] + res[nums.length-2];
        for(var j = nums.length-2; j >= 1; j--)
            res[j] = Math.min(res[j], res[j-1]) + nums[j];
        res[0] += nums[0];
    }
    var min = res[0];
    res.forEach(function(item) {
        min = Math.min(min, item);
    });
    return min;
};