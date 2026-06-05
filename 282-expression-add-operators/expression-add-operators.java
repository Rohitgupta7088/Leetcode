class Solution {
    String op = "+-*.";
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        helper(num, target, sb, ans,1);
        return ans;
    }

    public void helper(String num, int target, StringBuilder sb, List<String> ans, int idx){

        if(idx == num.length()){
            String tempstr = sb.toString();
            if(valid(tempstr) == target){
                ans.add(tempstr);
            }
            return;
        }
        for(int i=0; i<op.length(); i++){
            if(op.charAt(i) != '.'){
                if(idx < num.length()){
                    sb.append(op.charAt(i));
                    sb.append(num.charAt(idx));
                    helper(num, target, sb, ans, idx+1);
                    sb.deleteCharAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else{
                if(idx < num.length()){
                    int j=sb.length()-1;
                    while(j>=0 && sb.charAt(j) != '+' && sb.charAt(j) != '-' && sb.charAt(j) != '*'){
                        j--;
                    }

                    String currnum = sb.substring(j+1);
                    if(currnum.length() == 1 && currnum.charAt(0) == '0'){
                        continue;
                    }

                    sb.append(num.charAt(idx));
                    helper(num, target, sb, ans, idx+1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public long valid(String str){
        Stack<Long> ss = new Stack<>();
        long num = 0;
        char sign = '+';
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 +(ch-'0');
            }

            if(!Character.isDigit(ch) || i==str.length()-1){
                if(sign == '+'){
                    ss.push(num);
                }
                else if(sign == '-'){
                    ss.push(-num);
                }
                else if(sign == '*'){
                    ss.push(ss.pop()*num);
                }
                sign = ch;
                num = 0;
            }
        }

        long total= 0;
        while(!ss.isEmpty()){
            total += ss.pop();
        }

        return total;
    }
}