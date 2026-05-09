class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int arr[] = new int[n];
        Stack<Integer> ss = new Stack<>();
        arr[n-1] = -1;
        ss.push(nums2[n-1]);
        for(int i=n-2; i>=0; i--){
            if(ss.size() > 0 && ss.peek() > nums2[i]){
                arr[i] = ss.peek();
            }
            else if(ss.size() > 0 && ss.peek() < nums2[i]){
                while(ss.size() > 0 && ss.peek()<nums2[i]){
                    ss.pop();
                }
            }

            if(ss.isEmpty()){
                arr[i]=-1;
            }
            else{
                arr[i]=ss.peek();
            }

            ss.push(nums2[i]);
        }

        int result[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    result[i] = arr[j];
                    continue;
                }
            }
        }

        return result;
    }
}