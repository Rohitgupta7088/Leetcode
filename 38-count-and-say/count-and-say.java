class Solution {
    public String countAndSay(int n) {
        String oldstr = "";
        return c_s(1, oldstr, n);
    }

    public String c_s(int num, String oldstr, int n){
        if(num > n){
            return oldstr;
        }

        String newstr = "";
        if(num == 1){
            oldstr = "1";
            return c_s(num+1, oldstr, n);
        }

        int i=0;
        while(i < oldstr.length()){
            int count = 1;
            char curr = oldstr.charAt(i);
            
            int j=i+1;
            while( j<oldstr.length() && oldstr.charAt(j) == oldstr.charAt(i)){
                count ++;
                j++;
            }
            i=j-1;

            newstr += (char)(count + '0');
            newstr += oldstr.charAt(i);
            i++;
        }

        return c_s(num+1, newstr, n);
    }
}