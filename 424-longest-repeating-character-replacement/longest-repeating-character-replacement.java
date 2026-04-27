class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        if(n==1){
            return 1;
        }
        int left=0;
        int right=0;
        int length=0;
        int maxfreq=0;
        int arr[] = new int[26];
        while(right<n){
            arr[s.charAt(right)-'A']++;
            maxfreq = Math.max(maxfreq, arr[s.charAt(right)-'A']);
            if((right-left+1)-maxfreq <= k){
                length = Math.max(right-left+1, length);
            }
            else{
                while((right-left+1)-maxfreq > k){
                    if(arr[s.charAt(left)-'A']>0){
                        arr[s.charAt(left)-'A']-=1;
                    }
                    left++;
                }
                length = Math.max(length, right-left+1);
            }
            right++;
        }
        return length;
    }
}