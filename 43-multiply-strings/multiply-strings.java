class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String str = "0";

        for(int i=num1.length()-1; i>=0; i--){
            int a=num1.charAt(i)-'0';
            StringBuilder newstr = new StringBuilder();
            int carry = 0;
            for(int j=num2.length()-1; j>=0; j--){
                int res = ( (num2.charAt(j)-'0')*a )+carry;
                int digit = res%10;
                newstr.append( (char)(digit+'0') );
                carry = res/10;
            }

            if(carry > 0){
                newstr.append( (char)(carry+'0') );
            }
            newstr.reverse();
            newstr.append(lastzero(num1.length()-1-i));
            str = addtwoStr(str, newstr.toString());
        }
        return str;
    }

    public String lastzero(int idx){
        String str = "";
        for(int i=1; i<=idx; i++){
            str += '0';
        }
        return str;
    }

    public String addtwoStr(String s1, String s2){
        StringBuilder res = new StringBuilder();
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry !=0){
            int sum = carry;
            if(i>=0){
                sum += s1.charAt(i--)-'0';
            }
            if(j>=0){
                sum += s2.charAt(j--)-'0';
            }

            res.append((char)((sum % 10) + '0'));
            carry = sum / 10;
        }

        return res.reverse().toString();
    }
}