class Solution {
    public int minAddToMakeValid(String s) {
        // int n=s.length();
        // int count=0;

        // Stack<Character> ss = new Stack<>();
        // for(int i=0; i<n; i++){
        //     char ch=s.charAt(i);
        //     if(ch=='('){
        //         ss.push(ch);
        //     }
        //     else{
        //         if(!ss.isEmpty()){
        //             ss.pop();
        //         }
        //         else{
        //             count++;
        //         }
        //     }
        // }

        // return ss.size()+count;


        int n=s.length();
        int open=0;
        int close=0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }

        return close+open;
    }
}