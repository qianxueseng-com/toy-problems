/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
    if(n<=26){
        str=String.fromCharCode(n+64);
        return str;
    }
    var arr=[],m;
    while(n>=27){
        m=(n-1)%26;
        arr.unshift(String.fromCharCode(m+65));
        n-=m;
        n/=26;
    }
    arr.unshift(String.fromCharCode(n+64));
    return arr.join("");
};
