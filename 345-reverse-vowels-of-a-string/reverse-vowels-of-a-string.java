class Solution {
    public String reverseVowels(String s) {
        char sch[] = s.toCharArray();
       return helper(sch, 0, sch.length-1);
    }

    public String helper(char sch[], int left, int right){
        if(left >= right){
            String str = new String(sch);
            return str;
        }

        if( isvowel(sch[left]) && isvowel(sch[right]) ){
            char temp = sch[left];
            sch[left] = sch[right];
            sch[right] = temp;
            return helper(sch, left+1, right-1);
        }
        else if( isvowel(sch[left]) && !isvowel(sch[right])){
            return helper(sch, left, right-1);
        }
        else if( !isvowel(sch[left]) && isvowel(sch[right])){
            return helper(sch, left+1, right);
        }
        else{
            return helper(sch, left+1, right-1);
        }

    }

    public boolean isvowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}