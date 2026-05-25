class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int result[] = new int[n];
        for(int i=0; i<n; i++){
            result[i] = helper(nums, queries[i]);
        }

        return result;
    }

    public int helper(String nums[], int query[]){
        int trim = query[1];
        int k = query[0];

        String newarr[][] = new String[nums.length][2];
        for(int i=0; i<nums.length; i++){
            newarr[i][0] = nums[i].substring(nums[i].length()-trim);
            newarr[i][1] = String.valueOf(i);
        }

        Arrays.sort( newarr,  (a,b) -> a[0].compareTo(b[0]));

        return Integer.parseInt(newarr[k-1][1]);
    }
}