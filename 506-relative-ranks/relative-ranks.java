class Solution {
    // public String[] findRelativeRanks(int[] score) {
    //     String str[] = new String[score.length];
    //     for(int i=0; i<score.length; i++){
    //         str[i] = String.valueOf(score[i]);
    //     }

    //     Arrays.sort(score);
    //     int idx = 0;
    //     List<Integer> ll = new ArrayList<>();
    //     helper(score, str, idx, ll);
    //     return str;
    // }

    // public void helper(int score[], String str[], int idx, List<Integer> ll){
    //     if(idx >= str.length){
    //         return;
    //     }
    //     for(int i=0; i<str.length; i++){
    //         if(ll.contains(i)){
    //             continue;
    //         }
    //         if(idx<3 && Integer.parseInt(str[i]) == score[score.length-1-idx]){
    //             if(idx == 0){
    //                 str[i] = "Gold Medal";
    //                 ll.add(i);
    //             }
    //             else if(idx == 1){
    //                 str[i] = "Silver Medal";
    //                 ll.add(i);
    //             }
    //             else if(idx == 2){
    //                 str[i] = "Bronze Medal";
    //                 ll.add(i);
    //             }
    //         }
    //         else if( idx >= 3 && Integer.parseInt(str[i]) == score[score.length-1-idx]){
    //             str[i] = String.valueOf(idx+1);
    //             ll.add(i);
    //         }
    //     }
    //     helper(score, str, idx+1, ll);
    // }




    // Optimal Approch
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String str[] = new String[n];

        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> b[0]-a[0] );

        for(int i=0; i<n; i++){
            int idx = arr[i][1];

            if(i == 0){
                str[idx] = "Gold Medal";
            }
            else if(i == 1){
                str[idx] = "Silver Medal";
            }
            else if(i == 2){
                str[idx] = "Bronze Medal";
            }
            else{
                str[idx] = String.valueOf(i+1);
            }
        }
        return str;
    }
}