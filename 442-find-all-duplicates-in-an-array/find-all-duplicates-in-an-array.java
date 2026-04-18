class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ll = new ArrayList<>();

        for(int num: nums){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else{
                hm.put(num, 1);
            }
        }

        Set<Integer> ss = hm.keySet();
        for(int val: ss){
            if(hm.get(val) > 1){
                ll.add(val);
            }
        }

        return ll;
    }
}