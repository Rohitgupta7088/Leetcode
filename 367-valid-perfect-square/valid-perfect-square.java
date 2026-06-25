class Solution {
    public boolean isPerfectSquare(int num) {
        return helper(1, num, num);
    }

    public boolean helper(int a, int b, int num){
        if(b-a == 1){
            return false;
        }

        int mid =  a+(b-a)/2;

        if((long)mid*mid > (long)num){
            return helper(a, mid, num);
        }
        else if((long)mid*mid < (long)num){
            return helper(mid, b, num);
        }

        return true;
    }
}