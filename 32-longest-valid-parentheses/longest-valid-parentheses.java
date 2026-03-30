class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> ss = new Stack<>();
        int length = 0;
        int i=0;
        ss.push(-1);

        while(i< s.length()){
            char ch = s.charAt(i);
            if(ch == '('){
                ss.push(i);
            }
            else{
                ss.pop();
                if(ss.isEmpty()){
                    ss.push(i);
                }
                else{
                    int currlength = i-ss.peek();
                    length = Math.max(length, currlength);
                }
            }
            i++;
        }

        return length;
    }
}