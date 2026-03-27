class Solution {
    public int strStr(String haystack, String needle) {
        return helper(haystack, needle);
    }

    // public int helper(String s1, String s2){
    //     int i=0;
    //     while(i < s1.length()){
    //         while(i<s1.length() && s1.charAt(i) != s2.charAt(0)){
    //             i++;
    //         }
    //         int si = i;
    //         int k = i;
    //         int j = 0;
    //         while( j<s2.length() && k<s1.length() && s1.charAt(k) == s2.charAt(j) ){
    //             k++;
    //             j++;
    //         }
    //         int ei = k;
    //         if(s2.equals(s1.substring(si,ei)) ){
    //             return si;
    //         }

    //         i++;
    //     }

    //     return -1;
    // }

    public int helper(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        for(int i=0; i<=n-m; i++){
            int j=0;
            while(j<m && s1.charAt(i+j) == s2.charAt(j)){
                j++;
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }
}