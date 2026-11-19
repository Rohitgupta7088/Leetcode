// class Solution {
//     public int longestSubstring(String s, int k) {
//         int n = s.length();

//         if(s.length() == 0){
//             return 0;
//         }

//         int arr[] = new int[256];
//         for(int i=0; i<n; i++){
//             arr[s.charAt(i)]++;
//         }

//         char invalid = 0;
//         boolean found = false;
//         for(int i=0; i<arr.length; i++){
//             if(arr[i]>0 && arr[i]<k){
//                 invalid = (char)i;
//                 found = true;
//                 break;
//             }
//         }

//         if(!found){
//             return s.length();
//         }

//         int idx = s.indexOf(invalid);
//         String leftstr = s.substring(0, idx);
//         String rightstr = s.substring(idx+1);

//         int left = longestSubstring(leftstr, k);
//         int right = longestSubstring(rightstr, k);

//         return Math.max(left, right);
//     }
// }








class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxlen = 0;

        for(int target = 1; target <= 26; target++) {

            int arr[] = new int[26];
            int left = 0;
            int unique = 0;
            int countAtLeastK = 0;

            for(int right = 0; right < n; right++) {

                int idx = s.charAt(right) - 'a';

                if(arr[idx] == 0) {
                    unique++;
                }

                arr[idx]++;

                if(arr[idx] == k) {
                    countAtLeastK++;
                }

                while(unique > target) {

                    int leftidx = s.charAt(left) - 'a';

                    if(arr[leftidx] == k) {
                        countAtLeastK--;
                    }

                    arr[leftidx]--;

                    if(arr[leftidx] == 0) {
                        unique--;
                    }

                    left++;
                }

                if(unique == target && unique == countAtLeastK) {
                    maxlen = Math.max(maxlen, right-left+1);
                }
            }
        }

        return maxlen;
    }
}