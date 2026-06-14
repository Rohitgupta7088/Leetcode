class Solution {
    public List<Integer> splitIntoFibonacci(String nums) {
        List<Integer> ll = new ArrayList<>();
        helper(nums, ll, 0);
        return ll;
    }

    public boolean helper(String nums, List<Integer> ll, int idx){

        if(idx >= nums.length()){
            if(ll.size() >= 3){
                return true;
            }
        }

        long curr = 0;
        for(int i=idx; i<nums.length(); i++){

            if(i > idx && nums.charAt(idx)-'0' == 0){
                break;
            }

            curr = (curr*10) + (nums.charAt(i)-'0');

            if(curr > Integer.MAX_VALUE){
                break;
            }

            if(ll.size() < 2){
                ll.add((int)(curr));
                if(helper(nums, ll, i+1)) return true;
                ll.remove(ll.size()-1);
            }
            else{
                long required = (long)(ll.get(ll.size()-1)) + (long)(ll.get(ll.size()-2));
                if(curr > required){
                    break;
                }
                else if(curr < required){
                    continue;
                }
                else{
                    ll.add((int)(curr));
                    if(helper(nums, ll, i+1)) return true;
                    ll.remove(ll.size()-1);
                }
            }
        }
        return false;
    }
}