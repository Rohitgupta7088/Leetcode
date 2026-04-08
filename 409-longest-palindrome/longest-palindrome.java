class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        int arr[] = new int[128];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch]++;
        }

        int length = 0;
        boolean found = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                length += arr[i];
            }
            else{
                length += arr[i]-1;
                found = true;
            }
        }

        if(found){
            length += 1;
        }
        return length;
    }
}