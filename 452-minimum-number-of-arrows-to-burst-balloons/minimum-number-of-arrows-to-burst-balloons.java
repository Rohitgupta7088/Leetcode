class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int count = 1;
        if(n == 1){
            return count;
        }

        Arrays.sort(points, (a,b)-> a[1]-b[1]);

        int a = 0;
        for(int i=1; i<points.length; i++){
            if( Math.max(points[a][0], points[i][0]) <= Math.min(points[a][1], points[i][1])){
                continue;
            }
            else{
                a=i;
                count++;
            }
        }

        return count;
    }
}