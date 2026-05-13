class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        List<Integer> ll = new ArrayList<>();
        Stack<Integer> ss = new Stack<>();
        ss.push(asteroids[0]);
        for(int i=1; i<n; i++){
            int num = asteroids[i];
            if(ss.isEmpty()){
                ss.push(num);
            }
            else if(ss.peek()*num > 0){
                ss.push(num);
            }
            else if(ss.peek()<0 && num>0){
                ss.push(num);
            }
            else if(ss.peek()>0 && num<0 && Math.abs(ss.peek())==Math.abs(num)){
                ss.pop();
            }
            else{
                while(!ss.isEmpty() && ss.peek()>0 && num<0 && (Math.abs(ss.peek()) < Math.abs(num))){
                    ss.pop();
                }
                if(ss.isEmpty() || ss.peek() < 0){
                    ss.push(num);
                }
                else if(Math.abs(ss.peek()) == Math.abs(num)){
                    ss.pop();
                }
                else if(Math.abs(ss.peek()) < Math.abs(num)){
                    ss.push(num);
                }
            }

        }
            

        while(!ss.isEmpty()){
            ll.add(ss.pop());
        }

        int ans[] = new int[ll.size()];
        int k=0;
        for(int i=ll.size()-1; i>=0; i--){
            ans[k++] = ll.get(i);
        }

        return ans;
    }
}