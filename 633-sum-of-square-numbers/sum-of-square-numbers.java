class Solution {
    public boolean judgeSquareSum(int c) {

        int idx = helperidx(0, c, c);
        int left = 0;
        int right = idx;
        while(left<=right){
            long sum = (long)left*left + (long)right*right;
            if( sum == (long)c){
                return true;
            }

            if(sum < (long)c){
                left++;
            }
            else{
                right--;
            }
        }

        return false;
    }
    public int helperidx(int si, int ei, int target){
        if(si>ei){
            return si;
        }

        int mid = si+(ei-si)/2;
        if((long)mid*mid == (long)target){
            return mid;
        }

        if((long)mid*mid > (long)target){
            return helperidx(si, mid-1, target);
        }
        else{
            return helperidx(mid+1, ei, target);
        }
    }
}