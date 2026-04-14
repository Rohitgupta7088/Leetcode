class Solution {
    public int[][] reconstructQueue(int[][] people){
        if(people.length <= 1){
            return people;
        }

        List<List<Integer>> bigll = new ArrayList<>();
        peoplearrange(people, bigll);
        List<List<Integer>> resultlist = new ArrayList<>();
        resultlist.add( new ArrayList<>(bigll.get(0)) );
        arrangeK(resultlist, bigll, 1);

        int arr[][] = new int[people.length][people[0].length];
        for(int i=0; i<resultlist.size(); i++){
            for(int j=0; j<resultlist.get(i).size(); j++){
                arr[i][j] = resultlist.get(i).get(j);
            }
        }

        return arr;
    }
    public void peoplearrange(int[][] people, List<List<Integer>> bigll){
        List<Integer> ll = new ArrayList<>();
        int max = 0;
        int maxidx = -1;

        boolean allused = true;
        for(int i=0; i<people.length; i++){
            if(people[i][0] != -1){
                allused = false;
                break;
            }
        }

        if(allused){
            return;
        }

        for(int i=0; i<people.length; i++){
            if(people[i][0] == -1){
                continue;
            }
            if( maxidx == -1 ||
                people[i][0] > max ||
                (people[i][0] == max && people[i][1] < people[maxidx][1])){
                max = people[i][0];
                maxidx = i;
            }            
        }

        ll.add(people[maxidx][0]);
        ll.add(people[maxidx][1]);

        people[maxidx][0] = -1;

        bigll.add(new ArrayList<>(ll));
        peoplearrange(people, bigll);
    }

    public void arrangeK(List<List<Integer>> resultlist, List<List<Integer>> bigll, int idx){
        if(resultlist.size() == bigll.size()){
            return;
        }

        int k = bigll.get(idx).get(1); 
        resultlist.add(k, new ArrayList<>(bigll.get(idx)));
        arrangeK(resultlist, bigll, idx+1);
    }
}