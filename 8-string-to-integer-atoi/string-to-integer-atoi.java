class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n = s.length();
        String newstr = "";

        while(i<n && s.charAt(i) == ' '){
            i++;
        }

        if( i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            newstr += s.charAt(i);
            i++;
        }

        while(i<n && s.charAt(i) >='0' && s.charAt(i) <='9'){
            newstr += s.charAt(i);
            i++;
        }

        if (newstr.equals("") || newstr.equals("+") || newstr.equals("-")) {
            return 0;
        }

        try {
            return Integer.parseInt(newstr);
        } catch (NumberFormatException e) {
            return newstr.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}