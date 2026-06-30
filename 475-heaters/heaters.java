class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans_radius = 0;
        Arrays.sort(heaters);
        for(int i=0; i<houses.length; i++){
            int temp_radius = helper(heaters, 0, heaters.length-1, houses[i]);
            ans_radius = Math.max(ans_radius, temp_radius);
        }
        return ans_radius;
    }

    public int helper(int heaters[], int si, int ei, int target){
        if(si > ei){
            if(ei<0){
                return heaters[0]-target;
            }
            else if(si>=heaters.length){
                return target-heaters[heaters.length-1];
            }

            return Math.min(target-heaters[ei], heaters[si]-target);
        }

        int mid = si+(ei-si)/2;

        if(heaters[mid] == target){
            return 0;
        }

        if(mid==0){
            if(heaters[mid] < target){
                return helper(heaters, mid+1, ei, target);
            }
            else{
                return heaters[mid]-target;
            }
        }

        if(mid==heaters.length-1){
            if(heaters[mid] > target && heaters[mid-1]<=target){
                return Math.min(heaters[mid]-target, target-heaters[mid-1]);
            }
            else if(heaters[mid]<target){
                return helper(heaters, mid+1, ei, target);
            }
            else{
                return helper(heaters, si, mid-1, target);
            }
        }

        if(heaters[mid] >target && heaters[mid-1]<=target){
            return Math.min(heaters[mid]-target, target-heaters[mid-1]);
        }
        else if(heaters[mid] >target && heaters[mid-1]>target){
            return helper(heaters, si, mid-1, target);
        }
        else{
            return helper(heaters, mid+1, ei, target);
        }
    }
}