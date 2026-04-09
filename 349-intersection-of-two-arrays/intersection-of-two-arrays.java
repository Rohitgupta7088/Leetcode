class Solution {
    public int[] intersection(int[] nums1, int[] nums2){
    //     List<Integer> ll = new ArrayList<>();
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     if(nums1.length <= nums2.length){
    //         int i=0;
    //         while(i<nums1.length){
    //             if(i>0 && nums1[i] == nums1[i-1]){
    //                 i++;
    //                 continue;
    //             }
    //             else if(present( nums2, nums1[i], 0, nums2.length-1) ){
    //                 ll.add(nums1[i]);
    //             }
    //             i++;
    //         }
    //     }
    //     else{
    //         int j=0;
    //         while(j<nums2.length){
    //             if(j>0 && nums2[j] == nums2[j-1]){
    //                 j++;
    //                 continue;
    //             }
    //             else if(present( nums1, nums2[j], 0, nums1.length-1) ){
    //                 ll.add(nums2[j]);
    //             }
    //             j++;
    //         }
    //     }

    //     int arr[] = new int[ll.size()];
    //     for(int i=0; i<ll.size(); i++){
    //         arr[i] = ll.get(i);
    //     }

    //     return arr;
    // }

    // public boolean present(int arr[], int target, int si, int ei){
    //     if(si > ei){
    //         return false;
    //     }

    //     int mid = si+(ei-si)/2;
    //     if(arr[mid] == target){
    //         return true;
    //     }
    //     else if(arr[mid] < target){
    //         return present(arr, target, mid+1, ei);
    //     }
    //     else if(arr[mid] > target){
    //         return present(arr, target, si, mid-1);
    //     }

    //     return true;
    // }

        Set<Integer> ll = new HashSet<>();
        for(int num: nums1){
            ll.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for(int num: nums2){
            if(ll.contains(num)){
                result.add(num);
            }
        }

        int arr[] = new int[result.size()];
        int i=0;
        for(int num: result){
            arr[i++] = num;
        }

        return arr;
    }
}