class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int count=0;

        Stack<Character> ss = new Stack<>();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ss.push(ch);
            }
            else{
                if(!ss.isEmpty()){
                    ss.pop();
                }
                else{
                    count++;
                }
            }
        }

        while(!ss.isEmpty()){
            ss.pop();
            count++;
        }

        return count;
    }
}