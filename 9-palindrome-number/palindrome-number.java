class Solution {
    public boolean isPalindrome(int x) {
        // String num = String.valueOf(x);
        // int n = num.length();
        // for(int i=0; i<n/2; i++){
        //     if(num.charAt(i) != num.charAt(n-i-1)){
        //         return false;
        //     }
        // }

        // return true;

        if(x<0) return false;
        int orginal = x;
        int reverse = 0;
        while(x>0){
            reverse = (reverse*10)+(x%10);
            x = x/10;
        }

        return orginal==reverse;
    }
}