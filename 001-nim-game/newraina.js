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
    return !!(n & 0x3);
};


// 本机测试运行时间
var start, end;
var count = 90000000;

start = new Date();
for (var i = 0; i < count; i++) {
	canWinNim_1(i);
};
end  = new Date();
console.log('canWinNim_1: '+ (end - start));

start = new Date();
for (var i = 0; i < count; i++) {
	canWinNim_2(i);
};
end  = new Date();
console.log('canWinNim_2: '+ (end - start));