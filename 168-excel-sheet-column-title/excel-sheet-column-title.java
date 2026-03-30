class Solution {
    public String convertToTitle(int columnNumber) {
        return helper(columnNumber);
    }

    public String helper(int num){
        String newstr = "";
            // if(num<=26){
            //     newstr += (char)((num-1) +'A');
            //     return newstr;
            // }
            // else{
                while(num >0){
                    num --;
                    int rem = num % 26;
                    newstr = (char)( (rem +'A')) + newstr;
                    num = num/26;
                }
            // }

        return newstr;
    }
}