class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums1){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else{
                hm.put(num, 1);
            }
        }

        List<Integer> ll = new ArrayList<>();
        for(int num: nums2){
            if(hm.containsKey(num) && hm.get(num)>0){
                ll.add(num);
                hm.put(num, hm.get(num)-1);
            }
        }

        int arr[] = new int[ll.size()];
        for(int i=0; i<ll.size(); i++){
            arr[i] = ll.get(i);
        }

        return arr;
    }
}