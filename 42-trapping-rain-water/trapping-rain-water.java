class Solution {
    public int trap(int[] height) {
        int totaltrappedamount = 0;
        int steptrapped = 0;

        int rightmax[] = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];

        for(int i=1; i<height.length; i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }

        for(int i=height.length-2; i>=0; i--){
            rightmax[i]  =Math.max(rightmax[i+1],height[i]);
        }

        for(int i=0; i<height.length; i++){
            steptrapped = Math.min(rightmax[i],leftmax[i]) - height[i];
            totaltrappedamount += steptrapped;
        }

        return totaltrappedamount;
    }
}