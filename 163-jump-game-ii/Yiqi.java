public class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        //curMaxIndex: respresents the max index we can reach within next step
        //which means its initial value is max index we can reach in first step
        //lastMaxIndex: represents the max index we can reach within current step
        //which means its initial value is 0
        int res = 0, lastMaxIndex = 0, curMaxIndex = nums[0];
        for(int i = 1; i < nums.length; i++) {
            //when we reach lastMaxIndex, the max index we can go within current step
            //we add 1 step to res and update lastMaxIndex with curMaxIndex
            if(i > lastMaxIndex) {
                res++;
                lastMaxIndex = curMaxIndex;
            }
            curMaxIndex = Math.max(i+nums[i], curMaxIndex);
        }
        return res;
    }
}


//这种解法更好，因为还能判断是否能走到最后的element
//source:http://codeganker.blogspot.com/2014/03/jump-game-ii-leetcode.html
public int jump(int[] A) {
    if(A==null || A.length==0)
        return 0;
    int lastReach = 0;
    int reach = 0;
    int step = 0;
    for(int i=0;i<=reach&&i<A.length;i++)
    {
        if(i>lastReach)
        {
            step++;
            lastReach = reach;
        }
        reach = Math.max(reach,A[i]+i);
    }
    if(reach<A.length-1)
        return 0;
    return step;
}