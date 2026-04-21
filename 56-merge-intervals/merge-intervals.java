class Solution {
    // public int[][] merge(int[][] intervals) {
    //     int n = intervals.length;
    //     if(n == 1){
    //         return intervals;
    //     }

    //     Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

    //     List<Integer> ll = new ArrayList<>();
    //     boolean merge = false;
    //     if(Math.max(intervals[0][0],intervals[1][0])<=Math.min(intervals[0][1],intervals[1][1])){
    //         ll.add(intervals[0][0]);
    //         ll.add(Math.max(intervals[0][1],intervals[1][1]));
    //         merge = true;
    //     }
    //     else{
    //         ll.add(intervals[0][0]);
    //         ll.add(intervals[0][1]);
    //     }

    //     List<List<Integer>> bigll = new ArrayList<>();
    //     bigll.add(new ArrayList<>(ll));

    //     if(merge){
    //         helper(intervals, bigll, 2, 0);
    //     }
    //     else{
    //         helper(intervals, bigll, 1, 0);
    //     }

    //     int arr[][] = new int[bigll.size()][2];

    //     for(int i=0; i<bigll.size(); i++){
    //         for(int j=0; j<2; j++){
    //             arr[i][j] = bigll.get(i).get(j);
    //         }
    //     }

    //     return arr;
    // }

    // public void helper(int[][] intervals, List<List<Integer>> bigll, int idx, int i){
    //     List<Integer> ll = new ArrayList<>();
    //     if(idx >= intervals.length){
    //         return;
    //     }

    //     boolean overlap = false;
    //     if( Math.max(bigll.get(i).get(0),intervals[idx][0])<=Math.min(bigll.get(i).get(1),intervals[idx][1])){
    //         ll.add(bigll.get(i).get(0));
    //         ll.add(Math.max(bigll.get(i).get(1),intervals[idx][1]));

    //         bigll.set(i, new ArrayList<>(ll));
    //         overlap = true;
    //     }
    //     else{
    //         ll.add(intervals[idx][0]);
    //         ll.add(intervals[idx][1]);

    //         bigll.add(new ArrayList<>(ll));
    //     }

    //     if(overlap){
    //         helper(intervals, bigll, idx+1, i);
    //     }
    //     else{
    //         helper(intervals, bigll, idx+1, i+1);
    //     }

    // }





    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        if(intervals.length < 2){
            return intervals;
        }

        List<int[]> ll = new ArrayList<>();
        ll.add(intervals[0]);
        for(int[] curr: intervals){
            int prev[] = ll.get(ll.size()-1);
            if(Math.max(prev[0],curr[0])<=Math.min(prev[1],curr[1])){
                prev[1] = Math.max(curr[1],prev[1]);
            }
            else{
                ll.add(curr);
            }
        }

        int arr[][] = new int[ll.size()][2];
        for(int i=0; i<ll.size(); i++){
            arr[i] = ll.get(i);
        }

        return arr;
    }
}