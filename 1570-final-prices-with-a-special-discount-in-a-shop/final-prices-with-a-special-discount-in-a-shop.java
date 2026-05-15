class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int arr[] = new int[n];
        arr[n-1]=prices[n-1];
        Stack<Integer> ss = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int num = prices[i];
            while(!ss.isEmpty() && ss.peek()>num){
                ss.pop();
            }
            if(!ss.isEmpty()){
                arr[i] = num-ss.peek();
            }
            else{
                arr[i] = num;
            }
            ss.push(num);
        }
        return arr;
    }
}