/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    var tmp = 0;
    while(num >= 10) {
        while(num > 0) {
            tmp += (num % 10);
            num = Math.floor(num/10);
        }
        num = tmp;
        tmp = 0;
    }
    return num;
};
