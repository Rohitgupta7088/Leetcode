class Solution {
    public int findKthLargest(int[] nums, int k) {
        mergesort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    public void mergesort(int nums[], int si, int ei){
        if(si >= ei){
           return;
        }
        int mid = si + (ei-si)/2;
        mergesort(nums, si, mid);
        mergesort(nums, mid+1, ei);
        sort(nums, si, mid, ei);
    }

    public void sort(int nums[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(nums[i] >= nums[j]){
                temp[k] = nums[j];
                j++;
            }
            else{
                temp[k] = nums[i];
                i++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = nums[i++];
        }

        while(j<=ei){
            temp[k++] = nums[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            nums[i] = temp[k];
        }
    }
}