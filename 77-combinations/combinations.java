class Solution {
    // public List<List<Integer>> combine(int n, int k) {
    //     List<List<Integer>> bigll = new ArrayList<>();
    //     List<Integer> ll = new ArrayList<>();

    //     helper(1, bigll, ll, n, k);
    //     return bigll;
    // }

    // public void helper(int curr, List<List<Integer>> bigll, List<Integer> ll, int n, int k){

    //     if(ll.size() == k){
    //         bigll.add(new ArrayList<>(ll));
    //         return;
    //     }

    //     if(curr > n){
    //         return;
    //     }

    //     ll.add(curr);
    //     helper(curr+1, bigll, ll, n, k);
    //     ll.remove(ll.size()-1);
    //     helper(curr+1, bigll, ll, n, k);
    // }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        helper(arr, bigll, ll, 0, k);
        return bigll;
    }

    public void helper(int arr[], List<List<Integer>> bigll, List<Integer> ll, int si, int k){
        if(ll.size() == k){
            bigll.add(new ArrayList<>(ll));
            return;
        }

        if(si >= arr.length){
            return;
        }

        ll.add(arr[si]);
        helper(arr, bigll, ll, si+1, k);
        ll.remove(ll.size()-1);
        helper(arr, bigll, ll, si+1, k);
    }
}