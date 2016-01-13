/**
 * @param {number[]} nums
 * @return {number}
 */

// 暴力循环，超时了
var singleNumber_1 = function(nums) {
    nums = nums.sort(function(a, b) {
        return a - b;
    });
    var i, len;
    for (i = 0, len = nums.length; i < len - 1; i++) {
        if (nums[i] !== nums[i + 1]) {
            break;
        } else {
            i++;
        }
    }
    return nums[i];
};

// 异或
var singleNumber_2 = function(nums) {
    return nums.reduce(function(x, y) {
        return x ^ y;
    });
};

// 超时了
var singleNumber_3 = function (nums) {
	var temp = [], site;
	nums.forEach(function (v, i, a) {
		site = temp.indexOf(v);
		if(site < 0) temp.push(v);
		else temp.splice(site, 1);
	});
	return temp[0];
};
