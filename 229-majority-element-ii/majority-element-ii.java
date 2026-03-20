class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;

        Integer ref1 = null;
        Integer ref2 = null;

        for(int i=0; i<nums.length; i++){
            if(ref1 != null && nums[i] == ref1){
                count1++;
            }
            else if(ref2 != null && nums[i] == ref2){
                count2++;
            }
            else if(count1 == 0){
                ref1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
               ref2 = nums[i];
               count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == ref1){
                count1++;
            }
            else if(nums[i] == ref2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            list.add(ref1);
        }
        if(count2 > nums.length/3){
            list.add(ref2);
        }

        return list;
    }
}