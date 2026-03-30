class Solution {
    public int titleToNumber(String columnTitle) {
       return helper(columnTitle);
    }

    public int helper(String str){
        if(str.length() == 0){
            return 0;
        }
        int num = 0;
        char ch = str.charAt(str.length()-1);
        num = (int)(ch-'A'+1);
        for(int i=str.length()-2; i>=0; i--){
            ch = str.charAt(i);
            int value = power(26, str.length()-1-i) * (int)((ch-'A')+1);
            num += value; 
        }
        return num;
    }

    public int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int num = power(x,n/2)*power(x,n/2);
        if(n%2 == 0){
            return num;
        }
        else{
            return num*x;
        }
    }
}