class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele: nums){
            if(hm.containsKey(ele)){
                hm.put(ele, hm.get(ele)+1);
            }
            else{
                hm.put(ele,1);
            }
        }

        int maxlen = 0;
        Set<Integer> key = hm.keySet();
        for(int k: key){
            if(hm.containsKey(k+1)){
                maxlen = Math.max(maxlen, hm.get(k)+hm.get(k+1));
            }
        }

        return maxlen;
    }
}