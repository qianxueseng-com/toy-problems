/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    var sArr=s.split("");
    var tArr=t.split("");
    //数组长度不等，直接false
    if(sArr.length!==tArr.length){
        return false;
    }
    for(var i=0;i<sArr.length;i++){
        for(var j=0;j<t.length;j++){
            if(sArr[i]===tArr[j]){
                //删除tArr中的相同项
                tArr.splice(j,1);
                break;
            }
        }
    }
    //检查tArr是否全部删除
    if(tArr.length===0){
        return true;
    }else{
        return false;
    }
};
