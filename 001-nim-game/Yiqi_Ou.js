/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim = function(n) {
    if(n >= 134882061) 
        return n%4 !== 0;
    var state1 = true, state2 = true, state3 = true;
    var res = true;
    for(var i = 4; i <= n; i++) {
        if(state1 && state2 && state3)
            res = false;
        else 
            res = true;
        state1 = state2;
        state2 = state3;
        state3 = res;
    }
    return res;
};