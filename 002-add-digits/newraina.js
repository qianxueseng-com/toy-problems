/**
 * @param {number} num
 * @return {number}
 */

// 递归写法
var addDigits_1 = function(num) {
    num = typeof num === 'number' ? num.toString() : num;
    if (num.length < 2) {
        return parseInt(num);
    } else {
        var sum = 0;
        for (var i = 0; i < num.length; i++) {
            sum += parseInt(num[i]);
        }
        return addDigits_1(sum);
    }
};

// 循环写法
var addDigits_2 = function(num) {
    num = typeof num === 'number' ? num.toString() : num;
    var len = num.length;
    var sum = 0;

    while (len > 1) {
        for (var i = 0; i < len; i++) {
            sum += parseInt(num[i]);
        }
        num = sum.toString();
        sum = 0;
        len = num.length;
    }

    return parseInt(num);
}

// 最有效的写法
var addDigits_3 = function(num) {
    return num % 9;

}

/*-----------本机测试运行时间-----------*/

function testRunningTime(funcName) {
    var count = 2000000;
    var start, end;
    start = new Date();
    for (var i = 0; i < count; i++) {
        funcName(i);
    };
    end = new Date();
    return (end - start);
}

console.log('addDigits_1: ' + testRunningTime(addDigits_1) + 'ms'); // 885ms
console.log('addDigits_2: ' + testRunningTime(addDigits_2) + 'ms'); // 875ms
console.log('addDigits_3: ' + testRunningTime(addDigits_3) + 'ms'); // 15ms
