class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> biglist = new ArrayList<>();
        List<Integer> oldlist = new ArrayList<>();
        oldlist.add(1);
        biglist.add(new ArrayList<>(oldlist));

        int row = 1;
        while(row < numRows){
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1);
            for(int i=1; i<oldlist.size(); i++){
                newlist.add(oldlist.get(i) + oldlist.get(i-1));
            }
            newlist.add(1);

            biglist.add(newlist);
                
            oldlist.clear();
            for(int j=0; j<newlist.size(); j++){
                oldlist.add(newlist.get(j));
            }

            row++;
        }

        return biglist;
    }
}