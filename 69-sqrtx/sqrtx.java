class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        return helper(1, x, x);
    }

    public int helper(int a, int b, int x){
        if(b-a == 1){
            return a;
        }

        int mid = a+(b-a)/2;
        if( (long)mid * mid > (long)x ){
            return helper(a, mid, x);
        }
        else if( (long)mid * mid < (long)x){
            return helper(mid, b, x);
        }
        
        return mid;
    }
}