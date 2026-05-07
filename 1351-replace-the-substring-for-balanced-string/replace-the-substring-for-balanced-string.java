class Solution {
    // public int balancedString(String s) {
    //     int n=s.length();
    //     int arr[] = new int[26];
    //     for(int i=0; i<n; i++){
    //         char ch = s.charAt(i);
    //         arr[ch-'A']++;
    //     }

    //     boolean alreadyBalanced = true;
    //     for (int i = 0; i < 26; i++) {
    //         if (arr[i] > n/4) {
    //             alreadyBalanced = false;
    //             break;
    //         }
    //     }
    //     if(alreadyBalanced){
    //         return 0;
    //     }

    //     int windowarr[] = new int[26];
    //     int left = 0;
    //     int right = 0;
    //     int limit = n/4;
    //     int change = n;
    //     while(right < n){
    //         char ch = s.charAt(right);
    //         windowarr[ch-'A']++;
    //         while(left<= right && isvalid(arr, windowarr, limit)){
    //             change = Math.min(change, right-left+1);
    //             windowarr[s.charAt(left)-'A']--;
    //             left++;
    //         }
    //         right++;
    //     }

    //     return change;
    // }

    // public boolean isvalid(int arr[], int windowarr[], int limit){
    //     for(int i=0; i<26; i++){
    //         if(arr[i]-windowarr[i]>limit){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public int balancedString(String s) {
        int n = s.length();
        int k = n/4;
        int arr[] = new int[128];
        for(int i=0; i<n; i++){
            arr[s.charAt(i)]++;
        }

        if(arr['Q'] == k && arr['W'] == k && arr['E'] == k && arr['R'] == k){
            return 0;
        }

        int left = 0;
        int right =  0;
        int minlen = n;
        while(right<n){
            arr[s.charAt(right)]--;
            while(left<n && arr['Q'] <=k && arr['W']<=k && arr['E']<=k && arr['R']<=k){
                arr[s.charAt(left)]++;
                minlen = Math.min(minlen, right-left+1);
                left++;
            }
            right++;
        }

        return minlen;
    }
}