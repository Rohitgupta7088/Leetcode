class Solution {
    public double myPow(double x, int n) {
      long N = n;
      if(N < 0){
        N = -N;
        x = 1/x;
      }
      return calpow(x,N);
    }
    public double calpow(double x, long N){

        if(N==0){
            return 1;
        }

        double half = calpow(x,N/2);
        if(N % 2 != 0){
            return x*half*half;
        }
        else{
            return half*half;
        }

    }
}