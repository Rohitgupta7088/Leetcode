class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        int len[] = new int[n];
        for(int i=0; i<n; i++){
            len[i] = nums[i].length();
        }

        Arrays.sort(len);
        int maxlen = len[n-k];
        int greater = 0;

        for(int i=0; i<n; i++){
            if(len[i]>maxlen){
                greater++;
            }
        }

        int count = k-greater;
        ArrayList<String> list = new ArrayList<>();
        for(int j=0; j<n; j++){
            if(nums[j].length() == maxlen){
                list.add(nums[j]);
            }
        }

        Collections.sort(list);

        return list.get(list.size()-count);

    }
}