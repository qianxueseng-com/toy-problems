public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1)
            return 0;
        int left = 0, right = height.length-1, res = 0;
        while(left < right) {
            int area = (right-left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}