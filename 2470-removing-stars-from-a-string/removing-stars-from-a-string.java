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

        char arr[] = new char[ss.size()];
        int i=arr.length-1;
        while(!ss.isEmpty()){
            arr[i] = ss.pop();
            i--;
        }

        return new String(arr);
    }
}