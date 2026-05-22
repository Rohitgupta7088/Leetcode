class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums;
        }

        helper(nums, 0, n-1);
        return nums;
    }

    public void helper(int nums[], int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si+(ei-si)/2;

        helper(nums, si, mid);
        helper(nums, mid+1, ei);
        sort(nums, si, ei, mid);
    }

    public void sort(int nums[], int si, int ei, int mid){
        int arr[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(nums[i]>=nums[j]){
                arr[k]=nums[j];
                j++;
            }
            else{
                arr[k]=nums[i];
                i++;
            }
            k++;
        }

        while(i<=mid){
            arr[k++] = nums[i++];
        }

        while(j<=ei){
            arr[k++]=nums[j++];
        }

        for(int a=0; a<arr.length; a++){
            nums[si+a] = arr[a];
        }

    }
}