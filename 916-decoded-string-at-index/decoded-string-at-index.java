class Solution {
    public String decodeAtIndex(String s, int k) {
        int n=s.length();
        long length = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                length++;
            }
            else{
                int num = ch-'0';
                length *= num;
            }
        }

        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                if(k==0 || k==length){
                    return String.valueOf(ch);
                }
                length--;
            }
            else{
                int num = ch-'0';

                length /= num;
                k = (int)(k % length);
            }
        }

        return "";
    }
}