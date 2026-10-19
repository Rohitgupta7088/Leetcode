class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");
        return helper(sb, n, 1).toString();
    }

    public StringBuilder helper(StringBuilder sb, int n, int term){
        if(n == term){
            return sb;
        }

        StringBuilder newsb = new StringBuilder();
        int count = 0;
        int i=0;
        while(i<sb.length()){
            char ch = sb.charAt(i);
            while(i<sb.length() && sb.charAt(i) == ch){
                count++;
                i++;
            }

            newsb.append(String.valueOf(count));
            newsb.append(ch);
            count = 0;
        }

        return helper(newsb, n, term+1);
    }
}