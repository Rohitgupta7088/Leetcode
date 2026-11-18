class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while(i<n && s.charAt(i) == ' '){
            i++;
        }

        int sign = 1;
        if(i<n){
            if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(s.charAt(i) == '+'){
                i++;
            }
        }

        while(i<n && s.charAt(i) == '0'){
            i++;
        }

        long result = 0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            long digit = s.charAt(i)-'0';
            if(result > (Integer.MAX_VALUE - digit)/10L){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = (result*10)+digit;
            i++;
        }

        result = result*sign;
        return (int)result;
    }
}