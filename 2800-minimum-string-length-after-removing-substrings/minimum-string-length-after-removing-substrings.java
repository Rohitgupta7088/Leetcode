class Solution {
    public int minLength(String s) {
        int n=s.length();
        Stack<Character> ss = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if( !ss.isEmpty() && ((ss.peek() == 'C' && ch == 'D') || (ss.peek() == 'A' && ch == 'B')) ){
                ss.pop();
                continue;
            }
            ss.push(ch);
        }

        return ss.size();
    }
}