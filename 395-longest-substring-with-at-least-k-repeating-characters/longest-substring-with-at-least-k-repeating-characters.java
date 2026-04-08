class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }

    public int helper(String s, int k){

        if(s.length() == 0){
            return 0;
        }

        int arr[] = new int[256];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch]++;
        }

        char invalid = 0;
        boolean found = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0 && arr[i] < k){
                invalid = (char)i;
                found = true;
                break;
            }
        }

        if(!found){
            return s.length();
        }

        int invalididx = s.indexOf(invalid);
        String leftsub = s.substring(0, invalididx);
        String rightsub = s.substring(invalididx+1);

        int left =  helper(leftsub, k);
        int right =  helper(rightsub, k);

        return Math.max(left, right);
    }
}