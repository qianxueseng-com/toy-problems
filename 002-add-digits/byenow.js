/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    while(num>=10){
        var minNum=0;
        var arr=num.toString().split("");
        for(var i=0,len=arr.length;i<len;i++){
            var newNum=parseInt(arr[i]);
            minNum+=newNum;
        }
        num=minNum;
    }
    return num;
};
