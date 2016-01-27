//source: http://codeganker.blogspot.com/search?q=Trapping+Rain+Water
public class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1)
            return 0;
        int left = 0, right = height.length-1;
        int maxL = 0, maxR = 0, res = 0;
        //we should not stop when left == right
        while(left <= right) {
            //if the height of max bar on current index's left is lower than
            //the height of max bar on current index's right
            if(maxL <= maxR) {
                res += maxL > height[left] ? (maxL-height[left]) : 0;
                maxL = Math.max(maxL, height[left]);
                left++;
            } else {
                res += maxR > height[right] ? (maxR-height[right]) : 0;
                maxR = Math.max(maxR, height[right]);
                right--;
            }
        }
        return res;
    }
}