/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
     var arr=s.split(""),num=0;
     for(var i=0;i<arr.length;i++){
         num+=(arr[i].charCodeAt(0)-64)*Math.pow(26,arr.length-1-i);
     }
     return num;
};
