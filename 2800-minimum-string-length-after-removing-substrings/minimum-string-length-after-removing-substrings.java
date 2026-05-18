class Solution {
    public int minLength(String s) {
        //int n=s.length();
        // Stack<Character> ss = new Stack<>();

        // for(int i=0; i<n; i++){
        //     char ch = s.charAt(i);
        //     if( !ss.isEmpty() && ((ss.peek() == 'C' && ch == 'D') || (ss.peek() == 'A' && ch == 'B')) ){
        //         ss.pop();
        //         continue;
        //     }
        //     ss.push(ch);
        // }

        // return ss.size();



        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(sb.length()>0){
                char sblast = sb.charAt(sb.length()-1);
                if( (sblast == 'A' && ch=='B') || (sblast == 'C' && ch == 'D') ){
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
            }
            sb.append(ch);
        }

        return sb.length();
    }
}