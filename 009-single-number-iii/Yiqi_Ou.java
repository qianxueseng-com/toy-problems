public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length < 2)
            return res;
        int xor = 0;
        for(int i : nums)  
            xor = xor ^ i;
        int mask = 1;
        while((xor & mask) == 0)
            mask = mask << 1;
        int xor1 = 0, xor2 = 0;
        for(int i : nums) {
            if((mask & i) == 0) {
                xor1 = xor1 ^ i;
            }
            else {
                xor2 = xor2 ^ i;
            }
        }
        res[0] = xor1;
        res[1] = xor2;
        return res;
    }
}