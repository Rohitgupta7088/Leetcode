class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> bob = new HashSet<>();
        for(int num: bobSizes){
            bob.add(num);
        }

        int ans[] = new int[2];

        long sumA=0;
        long sumB=0;

        for(int num: aliceSizes){
            sumA += (long)num;
        }

        for(int num: bobSizes){
            sumB += (long)num;
        }

        long diff = (sumA-sumB);

        for(int num: aliceSizes){
            int bobnum = num-(int)(diff/2);
            if(bob.contains(bobnum)){
                ans[0] = num;
                ans[1] = bobnum;
                break;
            }
        }

        return ans;
    }
}