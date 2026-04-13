class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        if(n<3){
            int max = nums[0];
            for(int num: nums){
                max = Math.max(max,num);
            }
            return max;
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num: nums){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else{
                hm.put(num, 1);
            }
        }

        if(hm.size()<3){
            int max = Integer.MIN_VALUE;
            for(int key : hm.keySet()){
                if(key > max){
                    max = key;
                }
            }
            return max;
        }

        int a = 0;
        int i=0;
        while(i<3){
            Set<Integer> ss = hm.keySet();
            int max = Integer.MIN_VALUE;
            for(int key: ss){
                if(max < key){
                    max = key;
                }
            }

            a = max;
            hm.remove(max);
            i++;
        }

        return a;
    }
}