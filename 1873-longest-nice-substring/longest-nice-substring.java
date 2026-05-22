class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        if(n<2){
            return "";
        }

        return helper(s, 0, n);
    }

    public String helper(String s, int si, int ei){
        if(si>=ei){
            return "";
        }

        boolean arrlow[] = new boolean[26];
        boolean arrupp[] = new boolean[26];
        for(int i=si; i<ei; i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                if(arrlow[ch-'a']){
                    continue;
                }
                else{
                    arrlow[ch-'a'] = true;
                }
            }

            if(ch>='A' && ch<='Z'){
                if(arrupp[ch-'A']){
                    continue;
                }
                else{
                    arrupp[ch-'A'] = true;
                }
            }
        }

        for(int i=si; i<ei; i++){
            char ch = s.charAt(i);
            if( ch>='a' && ch<='z' && arrlow[ch-'a'] != arrupp[ch-'a'] ){
                    String left = helper(s, si, i);
                    String right = helper(s, i+1, ei);

                    return left.length()>=right.length() ? left : right;
                
            }
            else if( ch>='A' && ch<='Z' && arrlow[ch-'A'] != arrupp[ch-'A'] ){
                
                    String left = helper(s, si, i);
                    String right = helper(s, i+1, ei);

                    return left.length()>=right.length() ? left : right;
                
            }

        }

        return s.substring(si,ei);
    }
}