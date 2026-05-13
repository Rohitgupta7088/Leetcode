class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        Stack<Character> s1 = new Stack<>();
        for(int i=0; i<n1; i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                s1.push(ch);
            }
            else if(!s1.isEmpty() && ch == '#'){
                s1.pop();
            }
        }

        Stack<Character> t1 = new Stack<>();
        for(int i=0; i<n2; i++){
            char ch = t.charAt(i);
            if(ch != '#'){
                t1.push(ch);
            }
            else if(!t1.isEmpty() && ch == '#'){
                t1.pop();
            }
        }

        return s1.equals(t1);
    }
}