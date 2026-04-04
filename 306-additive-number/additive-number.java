class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3){
            return false;
        }

        for(int i=0; i<num.length(); i++){
            for(int j=i+1; j<num.length(); j++){
                String s1 = num.substring(0, i+1);
                String s2 = num.substring(i+1, j+1);
                boolean used = false;

                if( (s1.length() > 1 && s1.charAt(0) == '0')
                    ||  (s2.length() > 1 && s2.charAt(0) == '0') ){
                        continue;
                }

                int k=j+1;
                while(k < num.length() ){
                    
                    String sumstr = addStrings(s1, s2);
                    if(!num.startsWith(sumstr, k)){
                        break;
                    }
                    else{
                        k += sumstr.length();
                        s1=s2;
                        s2 = sumstr;
                        used = true;
                    }
                }

                if(k == num.length() && used == true){
                    return true;
                }
            }
        }

        return false;
    }

    public String addStrings(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry = 0;
        while(i>=0 || j>=0 || carry!=0){
            int sum = carry;
            if(i>=0){
                sum += s1.charAt(i--)-'0';
            }
            if(j>=0){
                sum += s2.charAt(j--)-'0';
            }

            sb.append( (char)(sum%10+'0') );
            carry = sum/10;
        }
        return sb.reverse().toString();
    }
}