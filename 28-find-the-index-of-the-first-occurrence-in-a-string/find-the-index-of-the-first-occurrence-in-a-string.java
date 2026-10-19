class Solution {
    public int strStr(String s1, String s2) {
        int i = 0;
        while(i<s1.length()){
            while(i<s1.length() && s1.charAt(i) != s2.charAt(0)){
                i++;
            }
            int si = i;
            int j = 0;
            while((si+j)<s1.length() && j<s2.length() && s1.charAt(i+j) == s2.charAt(j)){
                j++;
            }
            int ei = i+j-1;
            if((ei-si+1) == s2.length()){
                return i;
            }
            i++;
        }

        return -1;
    }
}