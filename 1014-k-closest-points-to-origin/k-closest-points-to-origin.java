class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        if(n == 1 && k == 1){
            return points;
        }

        helper(points, 0, n - 1, k - 1);

        int answer[][] = new int[k][2];

        for(int i = 0; i < k; i++){
            answer[i][0] = points[i][0];
            answer[i][1] = points[i][1];
        }

        return answer;
    }

    public void helper(int points[][], int si, int ei, int target){
        if(si >= ei){
            return;
        }

        int pivotDist = distance(points[si]);

        int i = si;

        for(int j = si + 1; j <= ei; j++){

            if(distance(points[j]) <= pivotDist){

                i++;

                int temp0 = points[i][0];
                int temp1 = points[i][1];

                points[i][0] = points[j][0];
                points[i][1] = points[j][1];

                points[j][0] = temp0;
                points[j][1] = temp1;
            }
        }

        int temp0 = points[si][0];
        int temp1 = points[si][1];

        points[si][0] = points[i][0];
        points[si][1] = points[i][1];

        points[i][0] = temp0;
        points[i][1] = temp1;

        if(i == target){
            return;
        }
        else if(i < target){
            helper(points, i + 1, ei, target);
        }
        else{
            helper(points, si, i - 1, target);
        }
    }

    public int distance(int point[]){
        int x = point[0];
        int y = point[1];

        return (x * x) + (y * y);
    }
}