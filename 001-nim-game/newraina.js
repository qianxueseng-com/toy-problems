/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim_1 = function(n) {
	// 方法一：正常求余
    return !(n % 4 === 0);
};

var canWinNim_2 = function(n) {
	// 方法二：位运算求余
	// 按理说位运算应该快一点，但实际用时反而慢了一点...
    return !!(n & 0x3);
};
