class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);

        for(int i=0; i<n; i++){
            int nums1;
            int nums2;
            if(i < v2.length){
                nums1 = Integer.parseInt(v2[i]);
            }
            else{
                nums1 = 0;
            }

            if(i < v1.length){
                nums2 = Integer.parseInt(v1[i]);
            }
            else{
                nums2 = 0;
            }

            if(nums2 < nums1) return -1;
            if(nums1 < nums2) return 1;
        }

        return 0;

    }
}