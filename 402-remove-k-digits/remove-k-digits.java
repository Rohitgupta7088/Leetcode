class Solution {
    public String removeKdigits(String num, int k) {
        // StringBuilder newstr = new StringBuilder();
        // int i=0;
        // int n=num.length();
        // while( newstr.length() < (n-k) ){
        //     int min = Integer.MAX_VALUE;
        //     int j=i;
        //     while( j<=k+newstr.length() && j<n ){
        //         if( (num.charAt(j)-'0') < min){
        //             min = num.charAt(j)-'0';
        //             i=j;
        //         }
        //         j++;
        //     }
        //     newstr.append( (char)(min+'0') );
        //     i++;
        // }

        // int j=0;
        // while( j<newstr.length() && newstr.charAt(j) == '0'){
        //     newstr.deleteCharAt(j);
        // }

        // if(newstr.length() == 0){
        //     return "0";
        // }

        // return newstr.toString();

        if(num.length() == 1 && k==1){
            return "0";
        }
        Stack<Character> ss = new Stack<>();
        int count = 0;
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(!ss.isEmpty() && count < k && (ch-'0') < (ss.peek()-'0')){
                ss.pop();
                count++;
            }
            ss.push(ch);
        }

        while(k>count && !ss.isEmpty()){
            ss.pop();
            count++;
        }

        StringBuilder newstr = new StringBuilder();
        while( !ss.isEmpty() ){
            newstr.append(ss.pop());
        }

        newstr = newstr.reverse();

        int i=0;
        while(i<newstr.length() && newstr.charAt(i) == '0'){
            newstr.deleteCharAt(i);
        }

        if(newstr.length() == 0){
            return "0";
        }

        return newstr.toString();
    }
}