class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int step=0;

        while(sum<target || (target-sum)%2 != 0){
            step++;
            sum += step;
        }

        return step;
    }
}