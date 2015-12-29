/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    var n = nums.sort(function(a, b) {
        return a - b;
    });
     var len = n.length;
    for (var i = 1;i < len; i=i+2) {
        if (n[i]!=n[i-1]) {
            return n[i-1]
        }
    }
    return n[i-1]
};
//我的计算机知识太弱了。。。。居然还有这种方法
var singleNumber = function(nums) {
  return nums.reduce(function(a, b) {
          return a ^ b;
      });
}
