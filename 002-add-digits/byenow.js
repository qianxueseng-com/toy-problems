/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    while(num>=10){
        var minNum=0;
        var arr=num.toString().split("");
        for(var i=0,len=arr.length;i<len;i++){
            minNum+=parseInt(arr[i]);
        }
        num=minNum;
    }
    return num;
};
