public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            //we calculate area by height * width. the heights = heights[idx],
            //width = right edge - left edge. so if heights[i] < height[idx], i is 
            //reactangle's right edge, otherwise push i into stack and find its right edge
            //later. Since we keep heights in stack ascending order, left edge will allways
            //be value that is under peek of the stack. If it is empty, left edge is 0
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int area = stack.isEmpty() ? i * heights[idx] : (i-stack.peek()-1) * heights[idx];
                res = Math.max(area, res);
            }
            stack.push(i);
        }
        //calculate the rectangle area whose right edge is heights.length-1
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int area = stack.isEmpty() ? heights.length * heights[idx] : 
                                (heights.length-1-stack.peek()) * heights[idx];
            res = Math.max(res, area);
        }
        return res;
    }
}