class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ll = new ArrayList<>();

        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
            if(hm.get(num)>(n/3) && !ll.contains(num)){
                ll.add(num);
            }
        }

        return ll;
    }
}