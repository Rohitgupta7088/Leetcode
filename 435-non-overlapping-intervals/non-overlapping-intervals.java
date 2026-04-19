class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;
        if(n==1){
            return count;
        }

        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);

        int prevend = intervals[0][1];
        for(int i=1; i<n; i++){
            if(intervals[i][0] < prevend ){
                count++;
            }
            else{
                prevend = intervals[i][1];
            }
        }

        return count;
    }
}