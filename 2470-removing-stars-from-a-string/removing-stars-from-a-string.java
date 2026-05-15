class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> ss = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(!ss.isEmpty() && ch == '*'){
                ss.pop();
            }
            else if(ch != '*'){
                ss.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!ss.isEmpty()){
            sb.append(ss.pop());
        }

        return sb.reverse().toString();
    }
}