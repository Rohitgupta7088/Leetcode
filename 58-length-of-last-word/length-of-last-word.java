class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        Integer ei = null;
        Integer si = null;
        int len = 0;
        while(i>=0){

            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }

            si = i;
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            ei=i+1;

            if(si != null & ei != null){
                break;
            }
        }

        return si-ei+1;
    }
}