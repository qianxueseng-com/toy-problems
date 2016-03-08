/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    for (var i = digits.length - 1; i >= 0; i--) {
        if (digits[i] == 9)
            digits[i] = 0;
        else {
            digits[i]++;
            return digits;
        }
    }

    digits.unshift(1);
    return digits;
};

console.log(plusOne([ 9, 9 ]));
console.log(plusOne([ 1, 9, 9 ]));
