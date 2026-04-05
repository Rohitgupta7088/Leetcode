class Solution {
    public String decodeString(String s) {
        Stack<Character> ss = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ']'){
                ss.push(ch);
            }
            else{
                StringBuilder temp = new StringBuilder();
                while(!ss.isEmpty() && ss.peek() != '['){
                    temp.append(ss.pop());
                }
                ss.pop();
                temp.reverse();

                StringBuilder digit = new StringBuilder();
                while(!ss.isEmpty() && Character.isDigit(ss.peek())){
                    digit.append(ss.pop());
                }

                int num = Integer.parseInt(digit.reverse().toString());

                StringBuilder repeat = new StringBuilder();
                for(int k=0; k<num; k++){
                    repeat.append(temp);
                }

                for(int k=0; k<repeat.length(); k++){
                    ss.push(repeat.charAt(k));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while(!ss.isEmpty()){
            result.append(ss.pop());
        }

        return result.reverse().toString();
    }
}