/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function(nums) {
    var xor = 0;
    nums.forEach(function(item, idx, array) {
       xor ^= item; 
    });
    var mask = 1;
    while((xor & mask) === 0)
        mask <<= 1;
    var res = [];
    var num1 = 0, num2 = 0;
    nums.forEach(function(item, idx, array) {
        if(item & mask)
            num1 ^= item;
        else 
            num2 ^= item;
    });
    res.push(num1, num2);
    return res;
};