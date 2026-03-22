class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            String newstr = "";
            newstr += s.charAt(i);
            for(int j=i+1; j<s.length(); j++){
                if(checknewstr(newstr, s.charAt(j))){
                    newstr += s.charAt(j);
                }
                else{
                    break;
                }
            }
            arr[i] = newstr.length();
        }

        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }

        return max;
    }

    public boolean checknewstr(String newstr, char curr){
        for(int i=0; i<newstr.length(); i++){
            if(newstr.charAt(i) == curr){
                return false;
            }
        }
        return true;
    }
}