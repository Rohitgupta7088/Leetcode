class Solution {
    // public int numFriendRequests(int[] ages) {
    //     HashMap<Integer, Integer> hm = new HashMap<>();
    //     for(int num: ages){
    //         hm.put(num, hm.getOrDefault(num,0)+1);
    //     }

    //     int count = 0;
    //     for(int num: hm.keySet()){
    //         int y = (int)(0.5 * num) + 7;
    //         for(int value: hm.keySet()){
    //             if(value>y && value<=num && !(value>100 && num<100)){
    //                 if(value<num){
    //                     count += hm.get(value) * hm.get(num);
    //                 }
    //                 else{
    //                     count += hm.get(value)*(hm.get(value)-1);
    //                 }
    //             }
    //         }
    //     }

    //     return count;
    // }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int num: ages){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        int count = 0;
        for(int num: hm.keySet()){
            int left = helperleft(ages, 0, ages.length-1, (num/2)+7);
            int right = helperright(ages, 0, ages.length-1, num);

            if(left>right) continue;

            int range = right-left;

            count += hm.get(num)*range;
        }

        return count;
    }

    public int helperleft(int ages[], int si, int ei, int target){
        if(si>ei){
            return si;
        }

        int mid = si+(ei-si)/2;

        if(mid == 0){
            if(ages[mid]>target){
                return mid;
            }
            else{
                return helperleft(ages, mid+1, ei, target);
            }
        }

        if(ages[mid-1]<=target && ages[mid]>target){
            return mid;
        }

        if(ages[mid]<=target){
            return helperleft(ages, mid+1, ei, target);
        }
        else{
            return helperleft(ages, si, mid-1, target);
        }
    }

    public int helperright(int ages[], int si, int ei, int target){
        if(si>ei){
            return ei;
        }

        int mid = si+(ei-si)/2;

        if(mid == ages.length-1){
            if(ages[mid]<=target){
                return mid;
            }
            else{
                return helperright(ages, si, mid-1, target);
            }
        }

        if(ages[mid]<=target && ages[mid+1]>target){
            return mid;
        }

        if(ages[mid]>target){
            return helperright(ages, si, mid-1, target);
        }
        else{
            return helperright(ages, mid+1, ei, target);
        }
    }
}