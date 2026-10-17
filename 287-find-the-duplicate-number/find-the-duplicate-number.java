class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> ss = new HashSet<>();
        int repeat = -1;
        for(int num: nums){
            if(ss.contains(num)){
                repeat = num;
                break;
            }
            ss.add(num);
        }
        return repeat;
    }
}