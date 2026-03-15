class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int k=0;
        while(i<m && k<n){
            if(nums1[i] < nums2[k]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[k]);
                k++;
            }
        }

        while(i<m){
            list.add(nums1[i]);
            i++;
        }

        while(k<n){
            list.add(nums2[k]);
            k++;
        }

        for(int j=0; j<nums1.length; j++){
            nums1[j] = list.get(j);
        }
    }
}