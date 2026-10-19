class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
            if(hm.get(num)>(n/2)){
                max = num;
                break;
            }
        }

        return max;
    }
}