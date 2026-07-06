class Solution {
    public int numFriendRequests(int[] ages) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: ages){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }


        int count = 0;
        for(int num: hm.keySet()){
            int y = (int)(0.5 * num) + 7;
            for(int value: hm.keySet()){
                if(value>y && value<=num && !(value>100 && num<100)){
                    if(value<num){
                        count += hm.get(value) * hm.get(num);
                    }
                    else{
                        count += hm.get(value)*(hm.get(value)-1);
                    }
                }
            }

        }

        return count;
    }
}