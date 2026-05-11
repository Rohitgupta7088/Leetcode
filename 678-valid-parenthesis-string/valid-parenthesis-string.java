class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        if(n==1){
            return s.charAt(0)=='*';
        }

        Stack<Character> ss = new Stack<>();
        int open = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                ss.push(ch);
            }
            else if(ch == '*'){
                ss.push(ch);
            }
            else{
                if(ss.isEmpty()){
                    return false;
                }

                Stack<Character> starss = new Stack<>();
                while(!ss.isEmpty() && ss.peek() == '*'){
                    starss.push(ss.pop());
                }

                if(ss.isEmpty() && !starss.isEmpty()){
                    starss.pop();
                }
                else if(!ss.isEmpty()){
                    open--;
                    ss.pop();
                }

                while(!starss.isEmpty()){
                    ss.push(starss.pop());
                }
            }
        }

        int star=0;

        while(!ss.isEmpty()){
            char ch = ss.pop();
            if(ch == '*'){
                star++;
            }
            else if(ch=='(' && star>0){
                open--;
                star--;
            }
            else{
                return false;
            }
        }

        return open==0;
    }
}