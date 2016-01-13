/**
 * @param {number} num
 * @return {number}
 */
 //模拟111个人头=100+10+1=99+9+3，99和9都能被整除，余3
 //考虑为9的倍数如18,27等return num%9 余0
var addDigits = function(num) {
    return (num-1)%9+1
};


//好多坑
var addDigits = function(num) {
	num = typeof num === 'number' ?	num.toString() : num;
	var len = num.length,
		i;
	var rel = 0;

	while(len > 1) {
		for (i = 0; i < len; i++) {
			rel += parseInt(num[i]);
		}
		num = rel.toString();
		rel = 0;
		len = num.length;

	}
	return parseInt(num)
}