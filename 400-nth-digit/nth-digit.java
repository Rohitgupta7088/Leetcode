class Solution {

    long length = 1;
    long count = 9;
    long start = 1;
    long digit;
    public int findNthDigit(int n) {
        digit=n;
        if(n>=1 && n<=9){
            return n;
        }
        
        long num = helper();
        int idx = (int)(digit-1)%(int)length;

        String number = Long.toString(num);
        return number.charAt(idx)-'0';
    }

    public long helper(){
        long total = length * count;

        if(digit > total){
            length += 1;
            start = start*10;
            count = count*10;

            digit -= total;
            return helper();
        }
        else{
            long num = start+(digit-1)/length;
            return num;
        }
    }
}