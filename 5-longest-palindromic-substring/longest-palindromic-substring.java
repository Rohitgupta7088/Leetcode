class Solution {
    public String longestPalindrome(String s) {
        String sb = "";
        for(int i=0; i<s.length(); i++){
            String temp1 = helper(s, i, i);
            String temp2 = helper(s, i, i+1);
            if(sb.length() < temp1.length()){
                sb = temp1;
            }

            if(sb.length() < temp2.length()){
                sb = temp2;
            }
        }

        return sb.toString();
    }

    public String helper(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }
}