class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(!(ch>='a' && ch<='z') && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }
            else if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}