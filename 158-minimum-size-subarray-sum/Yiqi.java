//我参考了这个blog: http://www.cnblogs.com/grandyang/p/4501934.html
public class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        //test adding all numbers is larger than s
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum < s)
            return 0;
        int left = 0, right = 0, tmpSum = 0, res = nums.length;
        while(right < nums.length) {
            while(tmpSum < s && right < nums.length) {
                tmpSum += nums[right++];
            }
            while(tmpSum >= s) {
                res = Math.min(res, right-left);
                tmpSum -= nums[left++];
            }
        }
        return res;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] sum = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++) 
            sum[i] = sum[i-1] + nums[i-1];
        //adding all numbers is still less than s
        if(sum[nums.length] < s)
            return 0;
        //init res
        int res = nums.length;
        //binary search to get range of [i, right] whose sum is 
        //larger than s
        for(int i = 0; i < nums.length; i++) {
            int right = binarySearch(sum, i, i, nums.length-1, s);
            if(right == nums.length)
                break;
            res = Math.min(res, right-i+1);
        }
        return res;
    }
    
    public int binarySearch(int[] sum, int i, int left, int right, int s) {
        while(left <= right) {
            int mid = (left + right) / 2;
            //we want to calculate pos that a[i] + a[i+1] + .. + a[pos] >= s
            //a[i] + ... + a[pos] = sum[pos+1] - sum[i]
            int tmpSum = sum[mid+1] - sum[i];
            if(tmpSum == s) {
                left = mid;
                break;
            }
            else if(tmpSum > s) 
                right = mid-1;
            else
                left = mid+1;
        }
        //the reason to return left is that after binary search, if we find sum == s,
        //left would be the right ridge. If we do not find, left would be the right ridge
        //that sum just a little bit larger than s. if left == nums.length, it means we do
        //not find any sum > s
        return left;
    }
}