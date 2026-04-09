class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 1 && k==1){
            return nums;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }

        int arr[] = new int[k];
        Set<Integer> ss = hm.keySet();
        int i=0;
        while(i<k){
            int max = 0;
            int ele = 0;
            for(int key: ss){
                if(hm.get(key) > max){
                    max = hm.get(key);
                    ele = key;
                }
            }
            hm.remove(ele);
            arr[i] = ele;
            i++;
        }
        return arr;
    }
}