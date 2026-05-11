class Solution {
    // public int calPoints(String[] operations) {
    //     int n = operations.length;
    //     Stack<Integer> ss = new Stack<>();
    //     for(int i=0; i<n; i++){
    //         String s = operations[i];
    //         if(!s.equals("C") && !s.equals("D") && !s.equals("+")){
    //             ss.push(Integer.parseInt(s));
    //         }
    //         else if(s.equals("C") ){
    //             ss.pop();
    //         }
    //         else if(s.equals("D") ){
    //             ss.push(ss.peek()*2);
    //         }
    //         else if(s.equals("+") ){
    //             int first = ss.pop();
    //             int sum = first + ss.peek();
    //             ss.push(first);
    //             ss.push(sum);
    //         }
    //     }

    //     int sum = 0;
    //     while(!ss.isEmpty()){
    //         sum += ss.pop();
    //     }

    //     return sum;
    // }

    public int calPoints(String[] operations) {
        int n=operations.length;
        int num[] = new int[n]; 
        int j=0;
        for(String s: operations){
            if(s.equals("C") && j!=0){
                j--;
            }
            else if(s.equals("D")){
                num[j] = num[j-1]*2;
                j++;
            }
            else if(s.equals("+")){
                num[j] = num[j-1]+num[j-2];
                j++;
            }
            else{
                num[j] = Integer.parseInt(s);
                j++;
            }
        }

        int sum = 0;
        for(int i=0; i<j; i++){
            sum += num[i];
        }

        return sum;
    }
}