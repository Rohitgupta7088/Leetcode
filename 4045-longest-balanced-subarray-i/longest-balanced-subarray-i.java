class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int length = 0;

        for(int i = 0; i < n; i++){

            HashSet<Integer> hs = new HashSet<>();

            int even = 0;
            int odd = 0;

            for(int j = i; j < n; j++){

                if(!hs.contains(nums[j])){

                    hs.add(nums[j]);

                    if(nums[j] % 2 == 0){
                        even++;
                    }
                    else{
                        odd++;
                    }
                }

                if(even == odd){
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
    }
}