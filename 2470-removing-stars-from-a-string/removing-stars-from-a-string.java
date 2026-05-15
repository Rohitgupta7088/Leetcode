class Solution {
    public String removeStars(String s) {
        int n=s.length();
        // Stack<Character> ss = new Stack<>();
        // for(int i=0; i<n; i++){
        //     char ch = s.charAt(i);
        //     if(!ss.isEmpty() && ch == '*'){
        //         ss.pop();
        //     }
        //     else if(ch != '*'){
        //         ss.push(ch);
        //     }
        // }

        // StringBuilder sb = new StringBuilder();
        // while(!ss.isEmpty()){
        //     sb.append(ss.pop());
        // }

        // return sb.reverse().toString();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='*' && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }
            else if(ch !='*'){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}