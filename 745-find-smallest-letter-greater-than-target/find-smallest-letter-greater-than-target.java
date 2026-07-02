class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return helper(letters, 0, letters.length-1, target);
    }

    public char helper(char letters[], int si, int ei, char target){
        if(si > ei){
            if(si<letters.length){
                return letters[si];
            }
            else{
                return letters[0];
            }
        }

        int mid = si+(ei-si)/2;

        if(letters[mid] == target){
            int i=mid+1;
            while(i<letters.length && letters[i]==letters[i-1]){
                i++;
            }
            if(i<letters.length){
                return letters[i];
            }
            else{
                return letters[0];
            }
        }

        if(letters[mid]-'a' > target-'a'){
            return helper(letters, si, mid-1, target);
        }
        else{
            return helper(letters, mid+1, ei, target);
        }
    }
}