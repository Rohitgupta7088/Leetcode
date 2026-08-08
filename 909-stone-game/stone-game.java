class Solution {
    int pilesA = 0;
    int pilesB = 0;
    public boolean stoneGame(int[] piles) {
        helper(piles, 0, piles.length-1, true);

        return (pilesA>pilesB);
    }

    public void helper(int piles[], int left, int right, boolean alice){
        if(left>right){
            return;
        }

        if(alice){
            int sumright = 0;
            int sumleft = 0;

            for(int i=left; i<=right; i+=2){
                sumleft += piles[i];
            }

            for(int i=right; i>=left; i-=2){
                sumright += piles[i];
            }

            if(sumleft>=sumright){
                pilesA += piles[left];
                helper(piles, left+1, right, false);
            }
            else{
                pilesA += piles[right];
                helper(piles, left, right-1, false);
            }
        }
        else{
            int sumright = 0;
            int sumleft = 0;

            for(int i=left; i<=right; i+=2){
                sumleft += piles[i];
            }

            for(int i=right; i>=left; i-=2){
                sumright += piles[i];
            }

            if(sumleft>=sumright){
                pilesB += piles[left];
                helper(piles, left+1, right, true);
            }
            else{
                pilesB += piles[right];
                helper(piles, left, right-1, true);
            }
        }
    }
}