class Solution {
    public String reverseWords(String s) {
        String newstr = " ";
        int i=s.length()-1;

        while(i >= 0){

            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }
            int end=i;

            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }

            int start = i+1;
            newstr += s.substring(start,end+1)+" ";
        }

        return newstr.trim();
    }
}